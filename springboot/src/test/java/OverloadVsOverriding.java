import org.junit.Test;

/**
 * @author: louxiu@wacai.com
 * @create: 20190213 8:27 PM
 */
public class OverloadVsOverriding {


  @Test
  public void testOverLoad() {

    System.out.println(testOL1());
    System.out.println(testOL1(3));

  }

  private Integer testOL1() {
    return 1;
  }

  private Double testOL1(Integer a) {
    return 1.1;
  }

  class A {

    protected Integer returnInt() {
      return 1;
    }
  }

  class ExtendA extends A {

    @Override
    public Integer returnInt() {
      return 2;
    }
  }
}
