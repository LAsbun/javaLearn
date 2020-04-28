package threadsafesingle;

/**
 * Created by louxiu
 */

abstract class AbstractSingleTon {

    private int a = 0;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
