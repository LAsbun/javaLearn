package referencetest;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 虚引用  内存空间不足，才会回收
 *
 * @author shengweisong
 * @date 2021-11-30 5:07 PM
 **/
@Slf4j
public class SoftReferenceTest {

    public static void main(String[] args) {

        Object o = new Object();

        Reference<Object> reference = new SoftReference<>(o);
        o = null;
        log.info("{}", reference.get());
        System.gc();
        log.info("{}", reference.get());


    }
}