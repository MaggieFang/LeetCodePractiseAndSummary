package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class ValidNum65 {
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        int countDot = 0;
        char pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '-') {
                pre = c;
                continue;
            }
            if (i > 0 && c == 'e' && Character.isDigit(pre) && i + 1 < s.length() &&
                    (s.charAt(i + 1) == '-' || Character.isDigit(s.charAt(i + 1)))) {
                pre = c;
                continue;
            }
            if (i > 0 && c == '.' && ++countDot <= 1) {
                pre = c;
                continue;
            }
            if (!Character.isDigit(c)) {
                return false;
            }
            pre = c;
        }
        return true;
    }
    public static void main(String[]  ar){
        System.out.println(isNumber("1 "));

    }
}
