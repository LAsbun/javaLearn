package model.entity;

import lombok.Data;

/**
 * Created by louxiu
 */
@Data
public class B extends A {
    private int b;
    private Object a;

    @Override
    public int getA() {
        return (Integer) a;
    }
}
