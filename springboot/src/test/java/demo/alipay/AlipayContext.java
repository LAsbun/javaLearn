package demo.alipay;

import demo.AlipayConvert;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 */
@Component
public class AlipayContext {

  private HashMap<String, AlipayConvert> alipayConvertHashMap = new HashMap<>();

  @Autowired
  public AlipayContext(List<AlipayConvert> alipayConvertList) {

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
