package concurrent.executor;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by louxiu
 */

public class ExecutorTest {


    final ThreadPoolExecutor executorService = new ThreadPoolExecutor(4, 50, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3));


    @Test
    public void testEx() throws InterruptedException {
        int size = 6;

        for (int i = 0; i < size; i++) {
            executorService.submit(new Job());
        }
        executorService.submit(new JobInterrupt());

        for (int i = 0; i < size; i++) {
            executorService.submit(new Job());
        }

        executorService.awaitTermination(30, TimeUnit.HOURS);
//        int index = 0;
//
//        retr:
//
//        for (; ; ) {
//
//            for (; ; ) {
//                if (++index != 100) {
//                    System.out.println(index);
//
//                    continue retr;
//                } else {
//                    System.out.println("break");
//                    break retr;
//                }
//            }
//        }
//
//        System.out.println("end");


    }


    class JobInterrupt implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "inte" + "cur: " + executorService.getPoolSize());
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + "inte end " + " cur: " + executorService.getPoolSize());

        }

    }

    class Job implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start" + " cur: " + executorService.getPoolSize());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end" + " cur: " + executorService.getPoolSize());
        }

    }
}
