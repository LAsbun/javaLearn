package designmodel.observer;

/**
 * @author
 */
public class SecondObserver implements Observer {

  @Override
  public void update(String message) {
    System.out.println("SecondObserver 观察到 message已经更改 " + message);

  }
}
