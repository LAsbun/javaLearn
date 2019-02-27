package designmodel.bridge;

/**
 * 正方形
 *
 * @author: louxiu
 * @create: 20190227 9:54 AM
 */
public class SquareGeometry extends Geometry {


  public SquareGeometry(CustomerColor customerColor) {
    this.customerColor = customerColor;
  }

  @Override
  public void withColor() {

    customerColor.drawColor();
    System.out.println("正方形");

  }
}
