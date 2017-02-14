import java.util.ArrayList;
import java.util.Map;

/**
 * Created by kraken on 18/03/16.
 */
public class Calc {
   
    static int count;
    static ArrayList<String>  history;

   static public double getResult(String s){
       count=0;
       history=new ArrayList<>();
       history.add(s);
       double result=getDigit(s);
       String res="Result: "+pow(result);
       history.add(res);
       return  result;
    }

    private static double getDigit(String s) {
       s=s.replaceAll(" ","");
        if (Utils.isDigit(s)) {
            double digit = Double.parseDouble(s);

            return digit;
        } else {
            Expr e = new Expr(s);

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

        System.out.println(++count + ". " + +a + " " + b + " " + c + "=" + (int) res);
        history.add(count + ". " +pow(a) + " " + b + " " + pow(c) + "=" + pow (res));

        return res;

    }
   
    static double pow(double n){
        return ((double)((int)(n*100)))/100;
    }


}
