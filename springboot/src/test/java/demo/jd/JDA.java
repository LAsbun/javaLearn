package demo.jd;

import demo.JDConvert;
import org.springframework.stereotype.Service;

/**
 * @author
 */
@Service
public class JDA implements JDConvert {

  @Override
  public void execute() {
    System.out.println("JDA");
  }
}
