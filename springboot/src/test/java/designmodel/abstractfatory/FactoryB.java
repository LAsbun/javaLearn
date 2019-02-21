package designmodel.abstractfatory;

/**
 * @author: louxiu
 * @create: 20190221 11:04 AM
 */
public class FactoryB extends AbstractFactory {

  @Override
  public AbstractAProduct creatProductA() {
    return new AProductB();
  }

  @Override
  public AbstractBProduct creatProductB() {
    return new BProductB();
  }
}
