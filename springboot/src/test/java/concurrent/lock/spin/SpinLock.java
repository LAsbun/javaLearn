package concurrent.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by louxiu
 * <p>
 * 自旋锁
 * <p>
 * <p>
 * 这种的其实是不公平的，没有先后排序
 */

public class SpinLock {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    private void lock() {
        Thread curThread = Thread.currentThread();
        while (!owner.compareAndSet(null, curThread)) ;
    }

    private void unlock() {
        owner.compareAndSet(Thread.currentThread(), null);
    }

    public static void main(String[] args) {

        SpinLock spinLock = new SpinLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    spinLock.lock();
                    System.out.println("dsadsa");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                } finally {
                    spinLock.unlock();

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    spinLock.lock();
                    System.out.println("94382843902834902");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                } finally {
                    spinLock.unlock();

                }
            }
        });

        t1.start();
        t2.start();

    }

}
