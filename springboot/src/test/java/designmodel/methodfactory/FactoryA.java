package designmodel.methodfactory;

/**
 * @author: louxiu
 * @create: 20190220 9:56 AM
 */
public class FactoryA extends Factory {

  @Override
  public Product mannufacture() {
    return new ProductA();
  }
}
