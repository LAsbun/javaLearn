package designmodel.builder;

/**
 * @author: louxiu
 * @create: 20190225 8:50 PM
 */
public class BuilderB extends Builder {

  Product product = new Product();

  @Override
  void buildHD() {
    product.add("BuilderB build buildHD");
  }

  @Override
  void buildCPU() {
    product.add("BuilderB build buildCPU");
  }

  @Override
  void buildMain() {
    product.add("BuilderB build buildMain");
  }

  @Override
  Product getProduct() {
    return product;
  }

}
