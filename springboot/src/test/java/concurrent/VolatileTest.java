package concurrent;

import org.junit.Test;

/**
 * Created by louxiu
 */

public class VolatileTest {

    int a = 0;

    volatile boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            System.out.println("dsadsads");
        }
        else {
            System.out.println(a);
        }
    }

    public static void main(String[] args){
        VolatileTest volatileTest = new VolatileTest();

        new Thread(){
            @Override
            public void run(){
                volatileTest.reader();
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                volatileTest.writer();
            }
        }.start();

    }

}
