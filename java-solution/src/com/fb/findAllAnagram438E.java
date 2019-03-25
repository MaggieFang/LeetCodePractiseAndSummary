package com.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/8/18
 * Talk is Cheap,Show me the Code.
 **/
public class findAllAnagram438E {

    /**
     * KEYPOINTS:
     * <p>
     * all little letter: so we can use A[26] to store the number of p
     * and we can read every p.length substring of s to count their frequency store in B[26]
     * and to compare A and B are equal at the same position.
     * However, we needn't get substring(s,s+p.length()).
     * we look an example.  s = "cbaebabacd", p = "abc", after we check s[0,..2],when we want to count s[1..3],
     * just do s[0]-- and s[3]++ is enough. we can reuse the middle part that have been count!
     * so for traversal, just do s[i-p.length()]-- and s[i] before compare A and B.
     * <p>
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
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();

        if (p == null || p.length() == 0 || s == null || s.length() < p.length()) {
            return result;
        }

        int[] pc = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pc[p.charAt(i) - 'a']++;
        }

        int[] sc = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sc[s.charAt(i) - 'a']++;
        }

        int k = 0;
        while (k < 26 && sc[k] == pc[k]) {
            k++;
        }
        if (k >= 26) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            sc[s.charAt(i - p.length()) - 'a']--;
            sc[s.charAt(i) - 'a']++;

            k = 0;
            while (k < 26 && sc[k] == pc[k]) {
                k++;
            }
            if (k >= 26) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    //will Time Limit Exceeded !!!
    public List<Integer> findAnagramsTimeExceed(String s, String p) {

        if (p == null || p.length() == 0) {
            return null;
        }

        if (s == null || s.length() <= p.length()) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int j = 0;
            map.clear();

            while (j < p.length()) {
                char c = s.charAt(i + j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                j++;
            }

            boolean exist = true;

            for (int k = 0; k < p.length(); k++) {
                char c = p.charAt(k);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                } else {
                    exist = false;
                    break;
                }
            }

            if (!exist) {
                continue;
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    exist = false;
                    break;
                }
            }
            if (exist) {
                result.add(i);
            }

        }
        return result;
    }

    public static void main(String[] ars) {
        findAllAnagram438E test = new findAllAnagram438E();
        System.out.println(test.findAnagrams("cbaebabacd"
                , "abc"));
    }

}
