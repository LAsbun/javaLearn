package designmodel.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: louxiu
 * @create: 20190225 8:52 PM
 */
public class Product {

  private List<String> stringList = new ArrayList<>();

  public void add(String a) {
    stringList.add(a);
  }

  public void show() {
    stringList.forEach(v -> {
      System.out.println(v);
      return;
    });
  }

}
