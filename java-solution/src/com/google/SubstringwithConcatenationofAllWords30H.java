package com.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class SubstringwithConcatenationofAllWords30H {
    /**
     * KEYPOINTS:
     * <p>
     *     https://leetcode.windliang.cc/leetCode-30-Substring-with-Concatenation-of-All-Words.html
     *
     * </p>
     * TIME COMPLEXITY: O(m*n) n is s.length,m = words.length
     * <p>
     * SPACE COMPLEXITY: O(m)
     * <p>
     **/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return ans;
        }

        int wlen = words[0].length();
        int n = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (String ss : words) {
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }

        for (int i = 0; i <= n - wordNum * wlen; i++) {
            String sub = s.substring(i, i + wordNum * wlen);
            int j = 0;
            HashMap<String, Integer> tmp = new HashMap<>();
            while (j <= sub.length() - wlen) {
                String w = sub.substring(j, j + wlen);
                tmp.put(w, tmp.getOrDefault(w, 0) + 1);
                if (!map.containsKey(w) || tmp.get(w) > map.get(w)) {
                    break;
                }
                j += wlen;
            }
            if (j > sub.length() - wlen) {
                ans.add(i);
            }
        }
        return ans;

    }
}
