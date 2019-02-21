package designmodel.abstractfatory;

import org.junit.Test;

/**
 * @author: louxiu
 * @create: 20190221 11:06 AM
 */
public class testMain {

  @Test
  public void test0(){

    AbstractFactory A = new FactoryA();

    A.creatProductA().show();
    A.creatProductB().show();

    AbstractFactory B = new FactoryB();

    B.creatProductA().show();
    B.creatProductB().show();
  }

}
