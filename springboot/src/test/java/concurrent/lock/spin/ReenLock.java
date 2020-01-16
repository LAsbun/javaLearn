package concurrent.lock.spin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by louxiu
 *
 * 公平的自旋
 *
 * 原理其实就是 先给个号，然后一直轮询，最后释放
 */

public class ReenLock {

    private AtomicInteger serviceNum = new AtomicInteger();

    private AtomicInteger ticketNum = new AtomicInteger();

    private int lock(){
        int myticket = ticketNum.getAndIncrement();
        while (serviceNum.get()!=myticket){}

        return myticket;
    }

    private void unlock(int myticket){

        int next = myticket + 1;
        serviceNum.compareAndSet(myticket, next);
    }

    public static void main(String[] args) {

        ReenLock reenLock = new ReenLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int lock = reenLock.lock();

                try {
                    System.out.println(lock);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                } finally {
                    reenLock.unlock(lock);

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int lock = reenLock.lock();

                try {
                    System.out.println(lock);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                } finally {
                    reenLock.unlock(lock);

                }
            }
        });

        t1.start();
        t2.start();

    }

}
