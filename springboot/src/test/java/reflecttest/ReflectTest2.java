package reflecttest;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shengweisong
 * @date 2021-09-16 6:58 PM
 **/
@Slf4j
public class ReflectTest2 {

    public static void target(int i) {
        new Exception("#" + i).printStackTrace();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> reflectTest2 = Class.forName("reflecttest.ReflectTest2");
        Method target = reflectTest2.getMethod("target", int.class);
        for (int i = 0; i < 20; i++) {
            target.invoke(null, i);

        }
    }
}