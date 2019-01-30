package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/4/19
 * Talk is Cheap,Show me the Code.
 **/
public class FindtheDifference389E {

    public char findTheDifferenceBitXOR(String s, String t) {
        char c = 0;
        for(int i = 0; i < s.length();i++){
            c ^= s.charAt(i);
        }

        for(int i = 0; i < t.length();i++){
            c ^= t.charAt(i);
        }
        return c;
    }

    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--cnt[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
        return ' ';
    }
}
