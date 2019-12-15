package demo.jd;

import demo.JDConvert;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component
public class JdContext {

  private HashMap<String, JDConvert> alipayConvertHashMap = new HashMap<>();

  @Autowired
  public JdContext(List<JDConvert> alipayConvertList) {

    alipayConvertList.forEach(alipayConvert -> {
      alipayConvertHashMap.put(alipayConvert.toString().toLowerCase(), alipayConvert);
    });

  }

  public void prinAll() {
    alipayConvertHashMap.forEach((k, v) -> {

      v.execute();

    });
  }

}
