package com.easy.twopointer;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class ValidPalindrome125 {
    public static void main(String[] args) {
    }

    public boolean isPalindromeCompareDirect(String s) {
        if (s == null || s == "") {
            return true;
        }

        int i = 0, j = s.length() - 1;
        while (i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);

            if (!Character.isLetterOrDigit(l)) {
                ++i;
            }else if (!Character.isLetterOrDigit(r)) {
                --j;
            }else if(Character.toLowerCase(l) !=Character.toLowerCase(r)){
                return false;
            }else {
                ++i;
                --j;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s == "") {
            return true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c += 32; //'a' -'A';
            }
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                builder.append(c);
            }
        }


        String newS = builder.toString();
        int i = 0, j = newS.length() - 1;
        while (i < j) {
            if (newS.charAt(i) != newS.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }


}
