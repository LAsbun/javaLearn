package concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by louxiu
 */

public class Mutex implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public boolean tryAcquire(int acquire) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        public boolean tryRelease(int release) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {

        Mutex mutex = new Mutex();


//        Thread x = ObjectLock.class.newInstance();
//        x.start();

//        Thread t1 = mutex.new FuncLock2(false, mutex);
//        Thread t2 = mutex.new FuncLock2(true, mutex);
//        Thread t3 = mutex.new FuncLock2(true, mutex);
//
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();

        System.out.println(mutex.testFinally());


    }


    public boolean testFinally(){
        try{
            return true;
        }
        finally {
            System.out.println("dsadsa");
        }

    }

    public class FuncLock2 extends Thread {

        private Mutex mutex;

        private boolean boo;

        public FuncLock2(boolean b, Mutex mutex) {
            this.boo = b;
            this.mutex = mutex;
        }

        @Override
        public synchronized void run() {
            if (this.boo) {
                this.read();
            } else {
                this.write();
            }

        }

        private void read() {
            mutex.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " read lock ing...");
                for (int i = 0; i < 5; i++) {
                    System.out.println(mutex.sync.getQueuedThreads());
                    Thread.sleep(1000);
                }
            } catch (Exception e) {

            } finally {
                System.out.println(Thread.currentThread().getName() + " read lock end...");

                mutex.unlock();
            }

        }

        private void write() {
            mutex.lock();

            try {
                System.out.println(Thread.currentThread().getName() + " write lock ing..");
                for (int i = 0; i < 5; i++) {
                    System.out.println(mutex.sync.getQueuedThreads());
                    Thread.sleep(1000);
                }

            } catch (Exception e) {

            } finally {
                System.out.println(Thread.currentThread().getName() + " write end ing..");

                mutex.unlock();
            }
        }
    }


}


