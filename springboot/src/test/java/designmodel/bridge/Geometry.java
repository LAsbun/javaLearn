package designmodel.bridge;

/**
 * 抽象几何图形
 *
 * @author: louxiu
 * @create: 20190227 9:49 AM
 */
abstract class Geometry {

  protected CustomerColor customerColor;

  // 涂色的图形
  public abstract void withColor();

}
