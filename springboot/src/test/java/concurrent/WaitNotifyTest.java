package concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by louxiu
 */

public class WaitNotifyTest {

    static boolean flag = true;

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();

        Thread.sleep(1000);

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @" + new SimpleDateFormat(" HH:mm:ss ").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }

                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {


                }
            }
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

            }
        }
    }
}
