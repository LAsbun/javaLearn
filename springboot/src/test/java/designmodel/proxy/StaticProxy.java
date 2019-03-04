package designmodel.proxy;

/**
 * @author
 */
public class StaticProxy implements Subject {

  @Override
  public void show() {
    System.out.println("这里是proxy");
    new SubjectImpl().show();
  }
}
