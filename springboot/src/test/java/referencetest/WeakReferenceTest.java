package referencetest;

import lombok.extern.slf4j.Slf4j;

import java.lang.ref.WeakReference;

/**
 * 弱引用  只要GC就没有了.
 *
 * @author shengweisong
 * @date 2021-11-30 5:07 PM
 **/
@Slf4j
public class WeakReferenceTest {

    public static void main(String[] args) {

        Object o = new Object();

        WeakReference<Object> weakReference = new WeakReference<>(o);
        o = null;
        log.info("{}", weakReference.get());
        System.gc();
        log.info("{}", weakReference.get());


    }
}