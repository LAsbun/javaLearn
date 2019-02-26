package designmodel.adapter;

import org.junit.Test;

/**
 * @author: louxiu
 * @create: 20190226 9:51 AM
 */
public class test0 {

  //  class
  @Test
  public void testMain() {
    Target target = new AdapterTarget(new AdapterImple());
    target.show();
  }

}
