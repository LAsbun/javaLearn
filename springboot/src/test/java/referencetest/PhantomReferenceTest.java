package referencetest;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * 作用是跟踪垃圾回收器收集对象的活动，
 * 在GC的过程中，如果发现有PhantomReference，
 * GC则会将引用放到ReferenceQueue中，由程序员自己处理，
 * 当程序员调用ReferenceQueue.pull()方法，
 * 将引用出ReferenceQueue移除之后，Reference对象会变成Inactive状态，
 * 意味着被引用的对象可以被回收了
 *
 * 任意时间都有可能被回收
 *
 * @author shengweisong
 * @date 2021-11-30 5:12 PM
 **/
@Slf4j
public class PhantomReferenceTest {

    public static void main(String[] args) {

        Object o = new Object();

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();


        Reference<Object> reference = new PhantomReference<>(o, referenceQueue);

        o = null;

        log.info("{}", reference.get());
        System.gc();
        Reference<?> poll = referenceQueue.poll();
//        log.info("{}", reference.get());
        log.info("{}", poll);

    }
}