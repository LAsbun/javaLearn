package concurrent;

import org.junit.Test;

/**
 * @author
 */
public class ThreadStateTest {


  @Test
  public void testNew() {

    Thread thread = new Thread();
    System.out.println(thread.getState()); // NEW

  }

  @Test
  public void testRunnable() throws InterruptedException {

    Thread testRunnable = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
          System.out.println(i);
        }
      }
    }, "testRunnable");
    testRunnable.start();
    testRunnable.join();

  }

  @Test
  public void testBlock() throws InterruptedException {

    final Object lock = new Object();

    Thread waitingA = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            Thread.sleep(20000);
            System.out.println("waiting");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

    }, "waitingA");

    Thread waitingB = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            Thread.sleep(20000);
            System.out.println("waiting");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

    }, "waitingB");


    waitingA.start();
    waitingB.start();

    Thread.sleep(50000);

  }

  public static void main(String[] args){

    final Object lock = new Object();

    Thread waitingA = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            Thread.sleep(20000);
            System.out.println("waiting");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

    }, "waitingA");

    Thread waitingB = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          try {
            Thread.sleep(20000);
            System.out.println("waiting");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

    }, "waitingB");


    waitingA.start();
    waitingB.start();

  }

}
