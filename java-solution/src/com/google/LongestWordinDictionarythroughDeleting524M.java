package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-27
 * Talk is cheap,show me the Code.
 **/
public class LongestWordinDictionarythroughDeleting524M {
    /**
     * Clarification:
     * if no char deleted. it is allows? yes
     * for s = "abc"
     * list= ["abc"]
     * the answer return abc
     * </p>
     * Keypoints:
     * straitforward. two pointers, one move in the s,and one move on the str in d that need to check.
     * for each word in d, when move the pointer forward to char c .try to move the pointer in s to find the char match c.
     * when the j move to the end but the i not. it is not the candicate we want. otherwise,when i to the end, it means we can form it by s.
     * so try to check whether update res.
     * <p>
     * <p>
     * we can see that we may repeat traversal s. so we can also try to use a map to store it.
     * but when checking s and str. we need to guarateen the index we choose from s is larger than the last one. seen the solution next to it
     *
     * </p>
     * TIME COMPLEXITY: O(C + N*m) C is the total content of d , N is the number of d ,m is the length of s
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public String findLongestWord1(String s, List<String> d) {
        String res = "";
        int len = s.length();
        for (String str : d) {
            if (str.length() > len) continue;
            int i = 0;
            int j = 0;
            while (i < str.length()) {
                char c = str.charAt(i);
                while (j < len && c != s.charAt(j)) {
                    j++;
                }
                if (j < len && c == s.charAt(j)) {
                    j++;
                } else {
                    break;
                }
                i++;
            }
            if (i == str.length()) {
                if (res.length() < str.length() || (str.length() == res.length() && res.compareTo(str) > 0)) {
                    res = str;
                }
            }
        }
        return res;
    }

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * seen above
     * </p>
     * TIME COMPLEXITY: O(C + m)
     * SPACE COMPLEXITY: O(m) : m is length of s
     * </p>
     **/
    public String findLongestWord(String s, List<String> d) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }
        String res = "";
        for (String str : d) {
            if (str.length() > s.length()) {
                continue;
            }

            int idx = -1;
            int i = 0;
            for (; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (!map.containsKey(c)) break;
                List<Integer> list = map.get(c);
                int tmp = idx;
                for (int e : list) {
                    if (e > idx) {
                        idx = e;
                        break;
                    }
                }
                if (tmp == idx) {
                    break;
                }
            }

            if (i == str.length()) {
                if (res.length() < str.length() || (res.length() == str.length() && str.compareTo(res) < 0)) {
                    res = str;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWordinDictionarythroughDeleting524M t = new LongestWordinDictionarythroughDeleting524M();

        t.findLongestWord("abpcplea", Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"}));

    }
}