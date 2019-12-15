package designmodel.lsp;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author
 */
public class test0 {

  @Test
  public void testMain() {

    HashMap<String, Long> hashMap = new HashMap<>();
    hashMap.put("a", 0L);

    Map<String, Number> map = new HashMap<>();
    map.put("a", 2L);

    Father father = new Father();
    System.out.println(father.getNumer(hashMap));

    Child child = new Child();

    System.out.println(child.getNumer(hashMap));
    // 这个就是调用的子类的重载函数
    System.out.println(child.getNumer(map));


  }


}
