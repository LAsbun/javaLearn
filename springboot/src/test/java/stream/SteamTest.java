package stream;

import org.junit.Test;
import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by louxiu
 */

public class SteamTest {

    @Test
    public void testStream(){

        String[] lst = new String[]{"1", "2", "3", "4"};

        List<String> objects = Arrays.stream(lst).filter(c -> c.equals("2")).collect(Collectors.toList());

        System.out.println(objects.toString());


    }
}
