package concurrent.lock;

/**
 * Created by louxiu
 */

public class FuncLock extends Thread {

    @Override
    public synchronized void run() {
        System.out.println("----FuncLock---");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("----FuncLock---");

    }

    public FuncLock() {
        super();
    }
}