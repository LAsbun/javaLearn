package concurrent;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import model.entity.A;
import model.entity.B;
import org.junit.Test;

/**
 * @author
 */
@Slf4j
public class ThreadPoolExecutorTest {


    @Test
    public void test() {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5,
//                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000),
//                (r, executor) -> { //r:请求执行的任务  executor:当前的线程池
//                    //打印丢失的任务
//                    log.error("discard:{}", r.toString());
//                });

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//            threadPoolExecutor.submit(() -> {
//                try {
//                    System.out.println(
//                            System.currentTimeMillis() + " " + Thread.currentThread().getName() + "start");
//                    Thread.sleep(30000);
//                    System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + "end");
//                } catch (InterruptedException e) {
//                    log.info("xxxx");
//                } catch (Exception e) {
//                    log.info("", e);
//                }
//            });
//
//        }

//        Future<A> submit = threadPoolExecutor.submit(new TestInnerCallTask());
//
//        while (true) {
//            if (submit.isDone()) {
//
//                try {
//                    System.out.println(submit.get());
//                } catch (InterruptedException e) {
//
//                    log.info("123");
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                }
//
//                break;
//            } else {
//                System.out.println("wait");
//                Thread.sleep(1000);
//            }
//        }


        Map<String, List<Integer>> map = new HashMap<>();

        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 2, 34, 5, 3, 2, 3, 3};

        Arrays.stream(a).forEach(x -> {
            if (!map.containsKey(x.toString())) {
                map.put(x.toString(), new ArrayList<>());
            }
            map.get(x.toString()).add(x);
        });

        System.out.println(map);

        A aaa = new A();
        aaa.setA(111);

        B aaaa = (B) aaa;

        System.out.println(aaa);
//
//        List<Integer> collect = Arrays.stream(a).filter(x -> x % 2 == 0 && x != 4).collect(Collectors.toList());

//        System.out.println(Arrays.toString(collect.toArray()));
    }



    class TestInnerCallTask implements Callable<A> {

        public TestInnerCallTask() {
        }

        @Override
        public A call() throws Exception {
            throw new Exception("dsadsadsa");
//            A a = new A();
//            a.setA(111);
//            Thread.sleep(10000);
//            return a;
        }
    }

    @Data
    class AA {
        int a;
    }

    @Data
    class AAB extends AA {
        int bb;
    }
}
