package designmodel.observer;

import org.junit.Test;

/**
 * @author
 */
public class test {

  @Test
  public void testMain(){

    Subject subject = new RealSubject();
    subject.add(new FirstObserver());
    subject.add(new SecondObserver());
    subject.notify("hdsjahdjsahds");
    subject.notify("天真有邪");

  }

}
