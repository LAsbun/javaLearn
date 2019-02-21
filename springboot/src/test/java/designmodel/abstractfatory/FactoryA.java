package designmodel.abstractfatory;

/**
 * @author: louxiu
 * @create: 20190221 10:59 AM
 */
public class FactoryA extends AbstractFactory {

  @Override
  public AbstractAProduct creatProductA() {
    return new AProductA();
  }

  @Override
  public AbstractBProduct creatProductB() {
    return new BProductA();
  }
}
