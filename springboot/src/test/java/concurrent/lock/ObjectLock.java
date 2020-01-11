package concurrent.lock;

/**
 * Created by louxiu
 */

public class ObjectLock extends Thread {

    private final Object object = new Object();




    @Override
    public void run() {
        synchronized (object) {
            System.out.println("----ObjectLock---");

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
            System.out.println("----ObjectLock---");

        }
    }
}
