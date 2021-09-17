package reflecttest;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射测试
 *
 * @author shengweisong
 * @date 2021-09-14 7:31 PM
 **/
@Slf4j
public class ReflectTest {
    public static void main(String[] args) {
        test();
    }

    private static void extracted() {
        try {
            // 根据外部配置实现。动态加载
            ReflectTest reflectTest = (ReflectTest) Class.forName("reflecttest.ReflectTest").newInstance();
            reflectTest.sayHello();
            Class<?> clz = Class.forName("java.lang.String");
            Method method = clz.getMethod("format", String.class, Object.class);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void sayHello() {
        System.out.println("hello reflect");
    }

    public static void test() {
        Person person = new Person();

        person.setAge("12");
        person.setMame("dhsja");
        try {

            Class<? extends Person> personClass = person.getClass();
            Field[] declaredFields = personClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                log.info("{} | {} = {}", declaredField.getType(), declaredField.getName(), declaredField.get(person));
            }

            Method setName = personClass.getMethod("setName", String.class);
            setName.invoke(person, "nei");
            log.info("{}", person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}