package designmodel.lsp;

import java.util.Map;

/**
 * @author
 */
public class Child extends Father {

  public Long getNumer(Map<String, Number> longMap) {
    System.out.println("child");
    return longMap.get("a").longValue();
  }

  // 这里虽然是覆盖了父类，但是返回值与父类返回是不一样的 Long <= number
//  @Override
//  public Long getNumer(HashMap<String, Long> hashMap) {
//    System.out.println("child");
//    return hashMap.get("a");
//  }

}
