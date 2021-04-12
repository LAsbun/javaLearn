package concurrent.semaphore;

import com.sun.jmx.snmp.tasks.ThreadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * java 信号量
 *
 * @author shengweisong
 * @date 2021-04-12 5:09 PM
 **/
@Slf4j
public class SemaphoreTest {

    private static final Semaphore se = new Semaphore(5);

    @Test
    public void testSemaphore() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    try {
                        se.acquire();
                        Thread.sleep(1000);
//                        Thread.sleep((long) (RandomUtils.nextDouble() * 1000));
                        log.info("[{}] xxx avail:{} queueLength:{}", finalI, se.availablePermits(), se.getQueueLength());
                        se.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            executorService.awaitTermination(30, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testCountDownBatch() {
        //主线程为裁判，子线程为运动员
        final CountDownLatch operatorNum = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Long s = System.currentTimeMillis();

                    try {
                        Thread.sleep(RandomUtils.nextInt(10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Long time = System.currentTimeMillis() - s;
                    log.info("运动员{}跑完,花了[{}]", Thread.currentThread().getName(), time);
                    //一个运动员跑完了
                    operatorNum.countDown();
                }
            }).start();
        }
        try {
            operatorNum.await();
            log.info("所有运行员都跑完了，裁判{}可宣布结果啦", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void TestCycleBarrier() {

//        与CountDownBatch 区别是可以被复用

        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++)
            new Writer(barrier).start();

        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CyclicBarrier重用");

        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }

    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);   //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }

    }
}