package designmodel.proxy;

import java.lang.reflect.Proxy;
import org.junit.Test;

/**
 * @author
 */
public class test {

  @Test
  public void name() {
    Subject proxy = new StaticProxy();
    proxy.show();
  }

  @Test
  public void testDynamic() {
//    DynamicProxy dynamicProxy = new DynamicProxy(new SubjectImpl());
    Subject subject = (Subject) Proxy.newProxyInstance(
        Subject.class.getClassLoader(),
        new Class<?>[]{Subject.class}, new DynamicProxy(new SubjectImpl())
    );
    subject.show();
    System.out.println(subject);
  }
}
