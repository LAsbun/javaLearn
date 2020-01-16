package concurrent.lock.spin;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by louxiu
 * MCS 自旋锁
 * 基于链表的，每个申请锁的线程都是链表上的一个节点，
 * 这些线程会一直轮询自己的本地变量，来知道它自己是否获得了锁。
 * 已经获得了锁的线程在释放锁的时候，负责通知其它线程，
 * 这样 CPU 之间缓存的同步操作就减少了很多，仅在线程通知另外一个线程的时候发生，
 * 降低了系统总线和内存的开销
 */

public class MCSLock {

    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isWaiting = true;
    }

    volatile MCSNode queue;

    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> update =
            AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class, "queue");

    public void lock(MCSNode curThread) {
        MCSNode predecessor = update.getAndSet(this, curThread); //setp 1
        if (predecessor != null) {
            predecessor.next = curThread; //step 2
            while (curThread.isWaiting) { // step 3
                System.out.println(Thread.currentThread().getName() + "waiting...");
            }
        } else {  // 只有一个线程在使用锁，没有前驱通知他，就直接标记自己已经获取到锁了
            curThread.isWaiting = false;
        }
    }

    public void unlock(MCSNode curThread) {
        if (curThread.isWaiting) {  // 拥有者释放，才有意义
            return;
        }
        if (curThread.next == null) {  // 检查是否有人排在后面
            //cas返回true 标识真的是没有排在后面
            if (update.compareAndSet(this, curThread, null)) {
                return;
            } else {
                //就表示突然有人在后面。需要等待后面的节点
                // 场景是 step运行了，但是step2还没有执行完
                while (curThread.next == null) {

                }
            }
        }
        curThread.next.isWaiting = false;
        curThread.next = null;
    }

    public static void main(String[] args) {
        MCSLock lock = new MCSLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                final MCSNode mcsNode = new MCSNode();
                lock.lock(mcsNode);

                try {
                    System.out.println("111");

                    Thread.sleep(10000);
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock(mcsNode);

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                final MCSNode mcsNode = new MCSNode();
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
