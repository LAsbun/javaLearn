package designmodel.decorator;

/**
 * @author
 */
public class FlyDecorator extends Decorator {

  public FlyDecorator(SuperMan superMan) {
    super(superMan);
  }

  @Override
  public void introduce() {
    if (null != this.superMan) {
      System.out.print("I can fly. ");
      this.superMan.introduce();
    }
  }
}
