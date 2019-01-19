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

    List<Number> chiNubers = new ArrayList<>();
    List<Number> chiChiNubers = new ArrayList<>();

    chiChiNubers.add(new NumberChiChi());
    chiChiNubers.add(new NumberChiChi());
    chiChiNubers.add(new NumberChiChi());
    chiChiNubers.add(new NumberChiChi());

    chiNubers.add(new NumberChil());
    chiNubers.add(new NumberChil());
    chiNubers.add(new NumberChil());

    sumAll(chiChiNubers);

    sumAll(chiNubers);

    sumOther(chiChiNubers);

    sumOther(chiNubers);

    // 使用Upper Bounded Wildcards 与不使用区别.
    sumAll(new ArrayList<NumberChiChi>());
    // 虽然 NumberChil extend Number  但是不能在某个函数以Number 使用
//    下面的会报错
//    sumOther(new ArrayList<NumberChil>());

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


}
