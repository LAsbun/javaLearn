package concurrent;

import org.apache.hadoop.util.hash.Hash;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author
 */
public class ConcurrentTest {

    private static final long count = 10000000000000l;

    public static void main(String[] args) throws InterruptedException {

        concurrency();

        serial();

    }

    private static void serial() {
        long start = System.currentTimeMillis();

        int a = 0;
        for (long i = 0; i < count; i++) {

            a += 5;

        }

        int b = 0;

        for (long i = 0; i < count; i++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time + "ms,MD5Util=" + b);

    }

    private static void concurrency() throws InterruptedException {

        long start = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {

            @Override

            public void run() {

                int a = 0;

                for (long i = 0; i < count; i++) {

                    a += 5;

                }

            }

        });

        thread.start();

        int b = 0;

        for (long i = 0; i < count; i++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time + "ms,MD5Util=" + b);

    }

    /**
     * 这里本想复现一下HashMap 线程不安全，但是没有验证成功
     * @throws InterruptedException
     */
    @Test
    public void testHashMap() throws InterruptedException {

        int size = 5;

        Thread[] threads = new Thread[size];

        HashMap<Integer, Integer> hashMap =  new HashMap<>();

        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        hashMap.put(j, j);
                    }
                }
            });
        }

        for (int i = 0; i < size; i++) {
            threads[i].start();
        }
        for (int i = 0; i < size; i++) {
            threads[i].join();
        }

    }


    @Test
    public void testConcurrentHashMap(){

        Map<String, String> cHmap = new ConcurrentHashMap<>(1);

        cHmap.put("1", "1");
        cHmap.put("2", "2");
        cHmap.put("3", "3");
        cHmap.put("4", "4");
        cHmap.put("5", "5");
        cHmap.put("6", "6");
        cHmap.put("7", "7");
        cHmap.put("8", "8");
        cHmap.put("9", "9");
        cHmap.put("10", "10");



    }

}
