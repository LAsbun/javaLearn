package designmodel.bridge;

/**
 * @author: louxiu
 * @create: 20190227 9:56 AM
 */
public class TriangleGeometry extends Geometry {

  public TriangleGeometry(CustomerColor customerColor) {
    this.customerColor = customerColor;
  }

  @Override
  public void withColor() {
    this.customerColor.drawColor();
    System.out.println("三角形");
  }
}
