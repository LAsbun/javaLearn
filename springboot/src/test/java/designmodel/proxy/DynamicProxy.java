package designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author
 */
public class DynamicProxy implements InvocationHandler {

  private Object object;

  public DynamicProxy(Object object) {
    this.object = object;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("before");
    System.out.println("this is proy" + proxy.getClass() + method.getName());
    Object invoke = method.invoke(object, args);
    System.out.println("after");
    return invoke;
  }
}
