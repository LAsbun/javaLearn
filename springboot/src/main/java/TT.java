import java.util.List;

public class TT {

    List<String> tt;

    public TT(List<String> tt) {
        this.tt = tt;
    }


    public List<String> change() {
        this.tt.add("1");
        this.tt.add("3");
        this.tt.add("2");
        return this.tt;
    }
}
