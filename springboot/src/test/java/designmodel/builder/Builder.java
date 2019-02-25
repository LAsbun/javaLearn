package designmodel.builder;

/**
 * @author: louxiu
 * @create: 20190225 8:48 PM
 */
abstract class Builder {

  // 创建HD
  abstract void buildHD();

  // 创建CPU
  abstract void buildCPU();

  // 创建主机
  abstract void buildMain();

  abstract Product getProduct();

}
