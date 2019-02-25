package designmodel.builder;

/**
 * @author: louxiu
 * @create: 20190225 8:50 PM
 */
public class BuilderA extends Builder {

  Product product = new Product();

  @Override
  void buildHD() {
    product.add("BuilderA build buildHD");
  }

  @Override
  void buildCPU() {
    product.add("BuilderA build buildCPU");
  }

  @Override
  void buildMain() {
    product.add("BuilderA build buildMain");
  }

  @Override
  Product getProduct() {
    return product;
  }
}
