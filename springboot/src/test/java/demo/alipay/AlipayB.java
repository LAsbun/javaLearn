package demo.alipay;

import demo.AlipayConvert;
import org.springframework.stereotype.Service;

/**
 * @author
 */
@Service
public class AlipayB implements AlipayConvert {

  @Override
  public void execute() {
    System.out.println("AlipayB");
  }
}
