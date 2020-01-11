package concurrent.lock;

/**
 * Created by louxiu
 */


public class UnLock extends Thread {

    @Override
    public void run() {
        System.out.println("----UnLock---");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("----UnLock---");

    }
}