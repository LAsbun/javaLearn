package designmodel.observer;

/**
 * @author
 */
public class FirstObserver implements Observer {

  @Override
  public void update(String message) {

    System.out.println("FirstObserver 观察到 message已经更改 " + message);
  }
}
