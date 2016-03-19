/**
 * Created by kraken on 19/03/16.
 */
public class Utils {
    public static boolean isDigit(String s) {
        if (s == null || s.length() < 1) return false;
        if (s.equals("."))return false;
        if (checkMinusAndDot(s)) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '-' && s.charAt(i) != '.' && !Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * перевірка на дрібну частину і знак
     * @param s
     * @return
     */
    private static boolean checkMinusAndDot(String s) {
        if (s.length() == 1 && s.charAt(0) == '-') return false;
        for (int i = 1, k = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                return false;
            }
            if (s.charAt(i) == '.') {
                k++;
                if (k > 1) return false;
            }
        }
        return true;
    }
}
