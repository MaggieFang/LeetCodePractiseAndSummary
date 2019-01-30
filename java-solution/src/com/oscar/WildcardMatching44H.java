package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class WildcardMatching44H {
    public boolean compare(String str, String pattern) {
        //["aa","*"],["adceb","*a*b"],["aadeaeb","*a?b"]
        int slen = str.length();
        int plen = pattern.length();
        int i = 0, j = 0;
        int starIdx = -1;
        int save_si = -1;//关键，我开始没用，但["adceb","*a*b"]会失败
        while (i < slen) {
            char c1 = str.charAt(i);
            if (j < plen && (pattern.charAt(j) == c1 || pattern.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < plen && pattern.charAt(j) == '*') {
                starIdx = j;
                save_si = i;
                j++;
            } else if (starIdx != -1) {
                j = starIdx;
                i = save_si+1;
            }else{
                return false;
            }
        }

        while (j < plen) {
            if (pattern.charAt(j) != '*') return false;
            j++;
        }

        return true;

    }

    public static void main(String[] args) {
        WildcardMatching44H t = new WildcardMatching44H();
        System.out.println(t.compare("aadcaeb", "*a?b"));
    }
}
