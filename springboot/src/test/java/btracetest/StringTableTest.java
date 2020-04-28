package btracetest;

/**
 * Created by louxiu
 */

import java.util.concurrent.TimeUnit;

public class StringTableTest {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringTableTest test = new StringTableTest();
        long ms = test.intern(1000000);
        System.out.println(ms);
    }

    public long intern(int times) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            String.valueOf(i).intern();
        }
        return System.currentTimeMillis() - start;
    }
}