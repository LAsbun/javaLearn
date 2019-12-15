import org.junit.Test;

/**
 * @author: louxiu@wacai.com
 * @create: 20190213 8:27 PM
 */
public class OverloadVsOverriding {


  /**
   * x xdm=10482&=sj xh=MIX 2&=login ld=171169999&=ssw l=46001&=os=android&=xt bb=9&=app ver=2.4.507&=action=get LoginInfo New&=is ky=1&=sjb z=869033024369408&=pwd=hh&=login mode=0
   */
  
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
