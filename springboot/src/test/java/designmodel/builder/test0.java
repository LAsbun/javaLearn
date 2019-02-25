package designmodel.builder;

import org.junit.Test;

/**
 * @author: louxiu
 * @create: 20190225 8:56 PM
 */
public class test0 {

  @Test
  public void testMain() {

    Director director = new Director();
    Builder builderA = new BuilderA();
    Builder builderB = new BuilderB();

    director.build(builderA);

    builderA.getProduct().show();

    director.build(builderB);
    builderB.getProduct().show();
  }
}
