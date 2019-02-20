package designmodel.methodfactory;

/**
 * @author: louxiu
 * @create: 20190220 9:57 AM
 */
public class FactoryB extends Factory {

  @Override
  public Product mannufacture() {
    return new ProductB();
  }
}
