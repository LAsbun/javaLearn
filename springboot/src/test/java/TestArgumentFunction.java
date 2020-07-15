import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import lombok.Data;
import org.junit.Test;

/**
 * @author: louxiu@wacai.com
 * @create: 20190214 12:06 PM
 */
@Data
public class TestArgumentFunction {

    private String a = "1";
    private Integer b = 0;
    private Long c = 9L;
    private boolean d = true;

    @Test
    public void test() {

        System.out.println("str " + getA());
        setValue("bb ", this::setA);
        System.out.println("str " + getA());

        System.out.println("In " + getB());
        setValue(78, this::setB);
        System.out.println("In " + getB());

        System.out.println("Lo " + getC());
        setValue(78L, this::setC);
        System.out.println("Lo " + getC());

        System.out.println("bo " + isD());
        setValue(false, this::setD);
        System.out.println("bo " + isD());


    }

    public void set(String str, Consumer<String> function) {
        function.accept(str);
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    // 设置参数
    private <T> void setValue(T value, Consumer<T> consumer) {

        consumer.accept(value);

    }

    @Test
    public void testfinal() {
        final List<String> aa = new ArrayList<>();

        aa.add("xx");
        aa.add("ssa");
        aa.add("sadsadsadsa");

        System.out.println(Arrays.toString(aa.toArray()));
    }




}
