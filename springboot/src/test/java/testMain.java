import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author: louxiu@wacai.com
 * @create: 20190119 4:21 PM
 */
public class testMain {


  @Test
  public void testUpperBoundesWild() {

    Integer i = new Integer(100);
    Integer j = new Integer(100);
    System.out.println(i == j); //false

    Double d = 5.6;


//    List<Number> chiNubers = new ArrayList<>();
//    List<Number> chiChiNubers = new ArrayList<>();
//
//    chiChiNubers.add(new NumberChiChi());
//    chiChiNubers.add(new NumberChiChi());
//    chiChiNubers.add(new NumberChiChi());
//    chiChiNubers.add(new NumberChiChi());
//
//    chiNubers.add(new NumberChil());
//    chiNubers.add(new NumberChil());
//    chiNubers.add(new NumberChil());
//
//    sumAll(chiChiNubers);
//
//    sumAll(chiNubers);
//
//    sumOther(chiChiNubers);
//
//    sumOther(chiNubers);
//
//    // 使用Upper Bounded Wildcards 与不使用区别.
//    sumAll(new ArrayList<NumberChiChi>());



    // 虽然 NumberChil extend Number  但是不能在某个函数以Number 使用
//    下面的会报错
//    sumOther(new ArrayList<NumberChil>());

  }

  private int testFinallyString(String str) {

    try {
      return str.charAt(0) - '0';
    } catch (NullPointerException e) {
      return 1;
    } catch (StringIndexOutOfBoundsException e) {
      return 2;
    } finally {
      return 6;
    }

  }

  private void sumOther(List<Number> numbers) {
    double sum = 0;

    for (Number number : numbers) {

      sum += number.doubleValue();

    }

    System.out.println(sum);


  }

  private void sumAll(List<? extends Number> numbers) {

    double sum = 0;

    for (Number number : numbers) {

      sum += number.doubleValue();

    }

    System.out.println(sum);


  }


  private class NumberChil extends Number {

    int a = 0;
    Integer b = 0;

    @Override
    public int intValue() {
      return 0;
    }

    @Override
    public long longValue() {
      return 0;
    }

    @Override
    public float floatValue() {
      return 0;
    }

    @Override
    public double doubleValue() {
      return 0;
    }
  }


  private class NumberChiChi extends NumberChil {

  }


  class testFinalClass {

    public int a = 5;

    public void setA(int a) {
      this.a = a;
    }

    public int getA() {
      try {
        return a - '0';
      } catch (Exception e) {
        return 0;
      } finally {
        return 7;
      }
    }

  }

  class testFinalClassB extends testFinalClass {

    @Override
    public void setA(int a) {
      super.setA(a);
    }
  }


}
