package designmodel.decorator;

/**
 * @author
 */
abstract class Decorator implements SuperMan {

  protected SuperMan superMan;

  public Decorator(SuperMan superMan) {
    this.superMan = superMan;
  }

}
