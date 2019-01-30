package com.google;

import java.util.Stack;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class BackspaceStringCompare844E {
    /**
     * KEYPOINTS:
     * <p>
     *   the character whether in the final string is up to if there are # in the future.
     *   so from the end. count # and  decide whether to collect the character or not.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int n1 = 0;
        int n2 = 0;
        char c1 = ' ';
        char c2 = ' ';
        while (i >= 0 && j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    n1++;
                } else if (n1 != 0) {
                    n1--;
                } else {
                    c1 = S.charAt(i);
                    break;
                }
                i--;
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    n2++;
                } else if (n2 != 0) {
                    n2--;
                } else {
                    c2 = T.charAt(j);
                    break;
                }
                j--;
            }
            if (c1 != c2) {
                return false;
            } else {
                i--;
                j--;
            }
        }

        while (i >= 0) {
            if (S.charAt(i) =='#') {
                n1++;
            }else if(n1 != 0){
                n1--;
            }else {
                return  false;
            }
            i--;
        }
        while (j >= 0) {
            if (T.charAt(j) =='#') {
                n2++;
            }else if(n2 != 0){
                n1--;
            }else {
                return  false;
            }
            j--;
        }

        return true;

    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#') {
                s1.push(c);
            } else if (c == '#' && !s1.isEmpty()) {
                s1.pop();
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c != '#') {
                s2.push(c);
            } else if (c == '#' && !s2.isEmpty()) {
                s2.pop();
            }
        }
        if (s1.size() != s2.size()) {
            return false;
        }

        while (!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
            s1.pop();
            s2.pop();
        }

        return s1.isEmpty();
    }
    public static void main(String[] args){
        BackspaceStringCompare844E test = new BackspaceStringCompare844E();
        System.out.println(test.backspaceCompare2("nzp#o#g",
                "b#nzp#o#g"));
    }
}
