package designmodel.lsp;

import java.util.HashMap;

/**
 * @author
 */
public class Father {

  public Number getNumer(HashMap<String, Long> hashMap) {
    System.out.println("father");

    return hashMap.get("a");
  }

}
