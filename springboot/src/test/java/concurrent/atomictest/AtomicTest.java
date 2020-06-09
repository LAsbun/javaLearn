package concurrent.atomictest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by louxiu
 */

public class AtomicTest {

    AtomicReference<String> atomicReference = new AtomicReference<>("a");

    @Test
    public void testReference() throws InterruptedException {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        String s = atomicReference.get();
                        atomicReference.getAndSet(s + s);
                    }

                }
            });
        }

        for (int i = 0; i < 5; i++) {
            threads[i].start();
            threads[i].join();
        }

        System.out.println(atomicReference.get().length());
    }
}
