package threadsafesingle;

import java.util.concurrent.*;

/**
 * Created by louxiu
 */

public class Singleton0 extends AbstractSingleTon {

    private static Singleton0 singleton0 = new Singleton0();

    private Singleton0() {

    }


    public static Singleton0 getSingleton0() {
        return singleton0;
    }

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());


//        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("xx2" + System.currentTimeMillis());

        for (int i = 0; i < 5; i++) {

            executorService.submit(()->{});
        }

        System.out.println("xx" + System.currentTimeMillis());


//        executorService.jo();
        while (true) {
            int activeCount = ((ThreadPoolExecutor) executorService).getActiveCount();
            System.out.println(activeCount);
            if (activeCount == 0) {
                executorService.shutdown();
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {


            }
        }


    }
}
