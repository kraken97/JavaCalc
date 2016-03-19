/**
 * Created by kraken on 18/03/16.
 */
public class Experssion {
    String left="0";
    char mark;
    String right="0";

    public Experssion(char mark, String right, String left) {
        this.mark = mark;
        this.right = right;
        this.left = left;
    }

    Experssion() {
        this(' ', null, null);
    }

    @Override
    public String toString() {
        return "Experssion{" +
                "left='" + left + '\'' +
                ", mark=" + mark +
                ", right='" + right + '\'' +
                '}';
    }
}
