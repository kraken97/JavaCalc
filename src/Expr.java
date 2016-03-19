/**
 * Created by kraken on 18/03/16.
 */
public class Expr {
    Expr begin;
    Experssion experssion;
    Expr end;
   public static final char[] marks = {'+', '-', '*', '/', '^'};


    public Expr(String s) {

        int index = indexMark(s);

        if (index < 0) {
            s = tryDel(s);
        }
        init(s);
    }

    void init(String s) {
        int index = indexMark(s);
        experssion = new Experssion();
        if (index > 0) {
            experssion.left = s.substring(0, index);
            experssion.mark = s.toCharArray()[index];
            this.begin = new Expr(experssion.left);
            experssion.right = s.substring(index + 1, s.length());
            this.end = new Expr(experssion.right);
        }
    }

    int indexMark(String s) {
        int index = -1,i = 0;

        while (i < marks.length && index == -1) {
            index = indexOfMark(s, marks[i]);
            i++;
        }
        return index;

    }

    String tryDel(String s) {
        int b = s.indexOf('(');
        int e = s.lastIndexOf(')');
        if (b == 0 && e == s.length() - 1) {
            return s.substring(b + 1, e);
        }
        return s;
    }


    @Override
    public String toString() {
        return
                "\n" + begin + "  " + experssion + " " + end;
    }

    private static int indexOfMark(String s, char mark) {
        int count = 0;
        char[] charS = s.toCharArray();
        for (int i = 0; i < charS.length; i++) {
            if (charS[i] == '(') count++;
            if (charS[i] == ')') count--;
            if (isMark(charS[i], mark) && count == 0) {
                return i;
            }
        }
        return -1;
    }


    static boolean isMark(char c, char mark) {
        returb c == mark
    }

}
