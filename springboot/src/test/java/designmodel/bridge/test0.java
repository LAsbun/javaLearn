package designmodel.bridge;

import org.junit.Test;

/**
 * @author: louxiu
 * @create: 20190227 9:58 AM
 */
public class test0 {

  /**
   * 绘制一些颜色为红色和蓝色的，形状为正方形，三角形的几个图形
   */

  @Test
  public void testMain() {

    Geometry geometryA = new SquareGeometry(new RedCustomerColor());

    geometryA.withColor();

    Geometry geometryB = new TriangleGeometry(new BlueCustomerColor());
    geometryB.withColor();

  }
}
