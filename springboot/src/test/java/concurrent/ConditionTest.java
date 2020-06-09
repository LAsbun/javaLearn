package concurrent;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by louxiu
 */

public class ConditionTest {

    class BoundedQueue<T> {
        private Object[] items;
        private int addIndex, removeIndex, count;
        private Lock lock = new ReentrantLock();
        private Condition notEmpty = lock.newCondition();
        private Condition notFull = lock.newCondition();

        public BoundedQueue(int size) {
            this.items = new Object[size];
        }

        public void add(T t) throws InterruptedException {
            lock.lock();
            try {
                while (count == items.length) {
                    // 表示满了
                    System.out.println(Thread.currentThread().getName() + " is waiting empty");
                    notFull.await();
                }
                items[addIndex] = t;
                if (++addIndex == items.length) {
                    addIndex = 0;
                }
                ++count;
                // 表示非空
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        @SuppressWarnings("unchecked")
        public T pop() throws InterruptedException {
            lock.lock();
            try {

                while (count == 0) {
                    System.out.println(Thread.currentThread().getName() + " is waiting pop");
                    notEmpty.await();
                }

                Object t = items[removeIndex];

                if (++removeIndex == items.length) {
                    removeIndex = 0;
                }
                --count;
                notFull.signal();
                return (T) t;

            } finally {
                lock.unlock();
            }
        }
    }


    @Test
    public void testCondition() throws InterruptedException {

        BoundedQueue<String> boundedQueue = new BoundedQueue<>(5);

        ProductJob productJob = new ProductJob(boundedQueue);
        ConsumeJob consumeJob = new ConsumeJob(boundedQueue);
        productJob.start();
        consumeJob.start();

        productJob.join();
        consumeJob.join();
    }

    @Test
    public void testbitCom(){
        System.out.println(-64>>>1);
    }


    class ProductJob extends Thread {
        private BoundedQueue boundedQueue;

        public ProductJob(BoundedQueue boundedQueue) {
            this.boundedQueue = boundedQueue;
        }

        public void run() {
            while (true) {

                try {
                    boundedQueue.add("11");
                    // 每2s 生产一个
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class ConsumeJob extends Thread {
        private BoundedQueue boundedQueue;

        public ConsumeJob(BoundedQueue boundedQueue) {
            this.boundedQueue = boundedQueue;
        }

        public void run() {
            while (true) {

                try {
                    System.out.println(boundedQueue.pop());
                    // 每2s 生产一个
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
