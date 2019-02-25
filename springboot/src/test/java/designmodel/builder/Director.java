package designmodel.builder;

/**
 * @author: louxiu
 * @create: 20190225 8:50 PM
 */
public class Director {

  public void build(Builder builder){

    builder.buildCPU();
    builder.buildHD();
    builder.buildMain();


  }

}
