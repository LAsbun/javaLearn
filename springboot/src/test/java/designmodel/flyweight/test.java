package designmodel.flyweight;

import org.junit.Test;

/**
 * @author
 */
public class test {

  @Test
  public void testMain() {
    FlyWeightFactoy flyWeightFactoy = new FlyWeightFactoy();
    FlyWeight xx = flyWeightFactoy.getFlyweight("xx");
    FlyWeight xx1 = flyWeightFactoy.getFlyweight("xx");

    System.out.println(xx == xx1); //true

    FlyWeight flyWeightExtends = new FlyWeightExtends();
    System.out.println(xx == flyWeightExtends);  //false
  }

}
