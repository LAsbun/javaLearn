package concurrent.lock.renntrantlocktest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by louxiu
 */

public class ReenTrantLockTest {

    static ReentrantLock reentrantLock = new ReentrantLock2(true);

    static ReentrantLock reentrantLockUnfair = new ReentrantLock2(false);

    @Test
    public void testReenTrantLockUnFairAndFair() throws InterruptedException {

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Job(reentrantLock));
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }

    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();

                try {

                    System.out.print("获取锁的当前线程[" + Thread.currentThread().getName() + "]");
                    System.out.print("等待队列中的线程[");
                    ((ReentrantLock2) lock).getQueueThreads();
                    System.out.println("]");
                    reenDoSth();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }

        private void reenDoSth() {
            lock.lock();
            try {
                System.out.println("reenDoSth[" + Thread.currentThread().getName() + "]");
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public void getQueueThreads() {
            ArrayList<Thread> threads = new ArrayList<>(super.getQueuedThreads());
            threads.forEach(thread -> System.out.print(thread.getName()));
        }
    }
}
