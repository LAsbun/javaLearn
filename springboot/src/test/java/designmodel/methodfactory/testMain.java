package designmodel.methodfactory;

/**
 * @author: louxiu
 * @create: 20190220 9:57 AM
 */
public class testMain {

  public static void main(String[] args) {

    Factory factoryA = new FactoryA();
    factoryA.mannufacture().show();

    Factory factoryB = new FactoryB();
    factoryB.mannufacture().show();


  }

}
