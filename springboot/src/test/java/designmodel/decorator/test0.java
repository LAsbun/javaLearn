package designmodel.decorator;

import org.junit.Test;

/**
 * @author
 */
public class test0 {


  @Test
  public void testMain() {

    SuperMan superMan = new SuperManImpl();

    superMan = new FlyDecorator(superMan);

//    FastDecorator fastDecorator = new FastDecorator(flySuper);

    superMan.introduce();

  }

}
