package renntrantlocktest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by louxiu
 */

public class ReenTrantReadWriteLockTest {

    static Map<String, Integer> cache = new HashMap<>();

    static ReentrantReadWriteLock reentrantReadWriteLockUnFair = new ReentrantReadWriteLock2(false);
    static ReentrantReadWriteLock reentrantReadWriteLockFair = new ReentrantReadWriteLock2(true);

    @Test
    public void testWRLock() throws InterruptedException {

        int index = 0;

        int length = 14;

        Thread[] threads = new Thread[length];
        for (int i = 0; i < 10; i++) {

            threads[index++] = new ReadJob(reentrantReadWriteLockFair);
            if (i % 3 == 0) {
                threads[index++] = new WriteJob(reentrantReadWriteLockFair);
            }

        }

        for (int i = 0; i < length; i++) {
            threads[i].start();
        }

//        reentrantReadWriteLockFair.getQueueLength()

        for (int i = 0; i < length; i++) {
            threads[i].join();
        }

    }


    static class WriteJob extends Thread {

        ReadWriteLock readWriteLock;

        public WriteJob(ReadWriteLock readWriteLock) {
            this.readWriteLock = readWriteLock;
        }

        public void run() {
            readWriteLock.writeLock().lock();
            try {
                Thread.sleep(1000);
                String s = Thread.currentThread().getId() + "-" + cache.get(Thread.currentThread().getName());

                cache.put(Thread.currentThread().getName(), ((ReentrantReadWriteLock2) readWriteLock).getQueueLength());

                System.out.println("write[" + Thread.currentThread().getName() + "] " + s);
                System.out.println("[" + Thread.currentThread().getName() + "] read " + s);
                System.out.print("等待队列中的线程[");
                ((ReentrantReadWriteLock2) readWriteLock).getWaitQueue();
                System.out.println("]");

                read();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.writeLock().unlock();
            }
        }

        private void read() {

            readWriteLock.readLock().lock();
            try {

                Integer s = cache.get(Thread.currentThread().getName());
                System.out.println("[" + Thread.currentThread().getName() + "] read " + ((ReentrantReadWriteLock2) readWriteLock).getQueueLength());
//                System.out.print("等待队列中的线程[");
//                ((ReentrantReadWriteLock2) readWriteLock).getWaitQueue();
//                System.out.println("]");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readWriteLock.readLock().unlock();
            }
        }

    }

    static class ReadJob extends WriteJob {

        public ReadJob(ReadWriteLock readWriteLock) {
            super(readWriteLock);
        }

        public void run() {
            super.read();
        }
    }


    private static class ReentrantReadWriteLock2 extends ReentrantReadWriteLock {
        public ReentrantReadWriteLock2(boolean fair) {
            super(fair);
        }

        public void getWaitQueue() {
            super.getQueuedWriterThreads().forEach(thread -> System.out.print(thread.getName()));
            System.out.println();
            super.getQueuedReaderThreads().forEach(thread -> System.out.print(thread.getName()));
        }
    }

}
