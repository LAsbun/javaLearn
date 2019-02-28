package designmodel.decorator;

/**
 * @author
 */
public class FastDecorator extends Decorator {

  public FastDecorator(SuperMan superMan) {
    super(superMan);
  }

  @Override
  public void introduce() {

    if (null != this.superMan) {
      System.out.print("I run fastest.");
      this.superMan.introduce();
    }

  }
}
