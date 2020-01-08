package model.mapper;

import static org.junit.Assert.*;

import lombok.Data;
import org.junit.Test;

public class CountryMapperTest {

    @Test
    public void tt() throws CloneNotSupportedException {

        B b = new B();
        b.setA("aa");
        b.setB("bb");
        A a = (A) b.clone();
        B bb = b.clone();
        bb.setB("dsas");
        b.setA("ba");
        System.out.println(a.getA());
        System.out.println(b);
        System.out.println(bb);
    }

    @Data
    class A implements Cloneable {

        private String a;

        public A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    @Data
    class B extends A {

        private String b;

        public B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }


}