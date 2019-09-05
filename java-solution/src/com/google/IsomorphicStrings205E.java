package com.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-25
 **/
public class IsomorphicStrings205E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * we can use two hashmap, to store recurrance of each character. and compare the two hashmap.
     * But since they are character. we can use int[256] instead of hashmap. But there is a trick here.
     * e.g in s="eeg", t = "aab", we record m1['e'] = 0 and m2['a'] = 0, and we always compared the m1[c1] == m2[c2]
     * if not just return false. if yes, we update the m1[c1],m2[c2] to the current index.
     * </p>
     * TIME COMPLEXITY: O(n+m)
     * SPACE COMPLEXITY:  O(c)
     * </p>
     **/
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
