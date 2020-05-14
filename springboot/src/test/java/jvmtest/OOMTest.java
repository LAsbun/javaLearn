package jvmtest;

import java.util.Random;

/**
 * Created by louxiu
 */

public class OOMTest {

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
//        System.out.println(Thread.s);
//
//        byte[] bytes = new byte[1 * 1024 * 1024 * 800];
//        System.out.println("xxx");
//        testStackOverflow();
        testBoolean(null);
    }

    public static void testBoolean(Boolean a){
        System.out.println(null == a);
    }

    /**
     * 栈溢出。每个方法算一个栈帧，-Xss20m  调整单个栈大小为20m
     */
    private static void testStackOverflow(){
//        System.out.println();
        testStackOverflow();
    }

    // -Xmx4m -Xms4m -XX:+PrintGCDetails   设置JVM HEAP 内存初始为4m 最大为4m.
    private static void testGCTest() {
        String x = "dshajdhsjaks";
        while (true) {
            x = x + new Random().nextInt(99999999) + "xx" +  new Random().nextInt(9999);
        }
    }
}
