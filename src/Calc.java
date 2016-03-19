/**
 * Created by kraken on 18/03/16.
 */
public class Calc {
    public static void main(String[] args) {
        String e="23*176+(13*83*9+1209/4)*3-(483/87*232)";
        System.out.println(e);
        System.out.println("Result: "+getDigit(e));

    }
    static int count=0;

    static double getDigit(String s) {
        if (Utils.isDigit(s)) {
            double digit = Double.parseDouble(s);
            //System.out.println(digit);
            return digit;
        } else {
            Expr e = new Expr(s);
            System.out.println(e);
            double left = getDigit(e.experssion.left);
            double right = getDigit(e.experssion.right);

            double res = calculate(left, e.experssion.mark, right);
            return res;
        }
    }

    static double calculate(double a, char b, double c) {
        double res = 0;
        switch (b) {
            case '+':
                res = a + c;
                break;
            case '-':
                res = a - c;
                break;
            case '*':
                res = a * c;
                break;
            case '/':
                res = a / c;
                break;
            case '^':
                res = Math.pow(a, c);
                break;


        }
        System.out.println(count++ + ". " + +a + " " + b + " " + c + "=" + (int) res);

        return res;

    }


}
