package com.google;

import java.util.Arrays;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-25
 **/
public class IsomorphicStrings205E {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int m1[] = new int[256];
        int m2[] = new int[256];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (m1[c1] != m2[c2]) return false;
            m1[c1] = i;
            m2[c2] = i;
        }
        return true;
    }
}
