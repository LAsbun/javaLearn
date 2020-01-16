package concurrent.lock.spin;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by louxiu
 *
 * CLH 其实是检查前驱节点是否获取到锁,轮询的是前驱节点的变量。
 *
 * CLH 释放状态的时候只需要更改自己的属性，但是CMS需要修改后续节点的属性
 */

public class CLHLock {

    private final static AtomicInteger in = new AtomicInteger();

    public static class CLHNode {
        private volatile boolean isWaiting = true;
        private final int a = in.getAndIncrement();
    }

    private volatile CLHNode tail;
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> update =
            AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, CLHNode.class, "tail");

    public void lock(CLHNode curNode) {
        CLHNode preNode = update.getAndSet(this, curNode);
        if (preNode != null) {

            while (preNode.isWaiting) {

            }
        }
    }

    public void unlock(CLHNode curNode) {

        if (!update.compareAndSet(this, curNode, null)) {
            curNode.isWaiting = false;
        }
    }

    public static void main(String[] args) {
        CLHLock lock = new CLHLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                final CLHLock.CLHNode mcsNode = new CLHLock.CLHNode();
                lock.lock(mcsNode);

                try {
                    System.out.println("111");

                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                } finally {
                    System.out.println("release");
                    lock.unlock(mcsNode);

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                final CLHLock.CLHNode mcsNode = new CLHLock.CLHNode();
                lock.lock(mcsNode);

                try {
                    System.out.println("2222");

                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock(mcsNode);

                }
            }
        });

        t1.start();
        t2.start();
    }

}
