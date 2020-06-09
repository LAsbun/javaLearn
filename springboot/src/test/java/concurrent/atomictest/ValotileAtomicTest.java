package concurrent.atomictest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by louxiu
 */

public class ValotileAtomicTest {

//    static volatile int a = 0;
    AtomicInteger a = new AtomicInteger(0);

    @Test
    public void testVolatileUnSafeAtomic() throws InterruptedException {
        Thread[] threads = new Thread[50];
        for (int i = 0; i < 50; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
//                        ++a;
                        a.incrementAndGet();
//                        System.out.println(++a);
                    }
                }
            });
        }

        for (int i = 0; i < 50; i++) {
            threads[i].start();

        }
        for (int i = 0; i < 50; i++) {
            threads[i].join();

        }

        System.out.println(a);
    }
}
