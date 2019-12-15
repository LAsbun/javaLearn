package demo;

import demo.alipay.AlipayContext;
import demo.jd.JdContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testMain {

  @Autowired
  private AlipayContext alipayContext;

  @Autowired
  private JdContext jdContext;

  @Test
  public void testooo() {

    alipayContext.prinAll();
    jdContext.prinAll();

  }

}
