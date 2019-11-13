package designmodel.observer;

import lombok.Data;
import org.junit.Test;

/**
 * @author
 */
public class test {

  @Test
  public void testMain() {

    Subject subject = new RealSubject();
    subject.add(new FirstObserver());
    subject.add(new SecondObserver());
    subject.notify("hdsjahdjsahds");
    subject.notify("天真有邪");

    A a = new A();

    System.out.println(a);

    change(a);
    System.out.println(a);

  }

  private void change(A a) {
    a.setA("xx");
  }


  @Data
  private class A {

    private String a;
  }

}
