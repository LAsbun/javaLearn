package concurrent;

/**
 * Created by louxiu
 */

public class SynchronizedTest {


  public synchronized void doSth() {
    System.out.println("Hello World");
  }

  public void doSth1() {
    synchronized (SynchronizedTest.class) {
      System.out.println("Hello World");
    }
  }

  public static void main(String[] args) {

  }

}
