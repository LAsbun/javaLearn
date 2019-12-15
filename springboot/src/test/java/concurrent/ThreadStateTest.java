package concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

  public static void main(String[] args) {

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

  @Test
  public void testIterator() {
    List<String> a = new ArrayList();
    a.add("1");
    a.add("2");

    Iterator<String> iterator = a.iterator();

    while (iterator.hasNext()) {
      String next = iterator.next();
      if ("2".equals(next)) {
        iterator.remove();
      }
    }

    a.add("2");

    for (String s : a) {
      if ("2".equals(s)) {
        a.remove(s);
      }
    }

  }


  @Test
  public void testMin() {

    System.out.println(min(new Integer[]{1, 2, 3, 1}));
    System.out.println(min(new Double[]{1.1,.1, .2, .3, .1}));

  }

  private <T extends Number & Comparable<? super T>> T min(T[] args) {
    if (null == args || args.length == 0) {
      return null;
    }

    T _min = args[0];
    for (int i = 1; i < args.length; ++i) {
      _min = _min.compareTo(args[i]) < 0 ? _min : args[i];
    }
    return _min;
  }
}
