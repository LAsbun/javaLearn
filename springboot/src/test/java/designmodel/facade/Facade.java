package designmodel.facade;

/**
 * @author
 */
public class Facade {

  private SystemA systemA = new SystemA();

  private SystemB systemB = new SystemB();

  private SystemC systemC = new SystemC();

  public void show() {

    systemA.ShowA();
    systemB.ShowB();
    systemC.showC();

  }

}
