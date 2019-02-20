package designmodel.simplefactory;

/**
 * @author: louxiu
 * @create: 20190220 10:01 AM
 */
public class SimpleFactory {

  public void show(String product) {

    switch (product) {
      case "A":
        new ProductA().show();
        break;
      case "B":
        new ProductB().show();
        break;
      default:
        System.out.println("没有该产品");
        break;
    }

  }

}
