package concurrent;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by louxiu
 */

public class VolatileTest {

    public static boolean stop = false;

    int a = 0;

    volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            System.out.println("dsadsads");
        } else {
            System.out.println(a);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        VolatileTest volatileTest = new VolatileTest();
//
//        new Thread(){
//            @Override
//            public void run(){
//                volatileTest.reader();
//            }
//        }.start();
//        new Thread(){
//            @Override
//            public void run(){
//                volatileTest.writer();
//            }
//        }.start();

        Thread workThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stop) {
                    i++;
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        workThread.start();
        TimeUnit.SECONDS.sleep(3);
        stop = true;
    }


}
