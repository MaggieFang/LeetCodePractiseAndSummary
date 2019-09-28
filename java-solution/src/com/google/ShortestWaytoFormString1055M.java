package com.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-28
 **/
public class ShortestWaytoFormString1055M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * we can use two pointer , one iterate src, another iterate tar.
     * for each tar char, we move j until src[j] == tar[i], if j == src.length, ans++, j = 0 and recheck the cur target char
     * in this solution, we greedy match as many chars from src to tar as possible which can lead mininum use of src.
     * and we can build a set to save all the char in src, if there exists a char from tar which not exists in set, return -1.
     * </p>
     * TIME COMPLEXITY: O(len(source)*len(target))
     * SPACE COMPLEXITY: O(len(source))
     * </p>
     **/
    public int shortestWay(String source, String target) {
        int ans = 1;
        int slen = source.length();
        int tlen = target.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < slen; i++) {
            set.add(source.charAt(i));
        }
        int j = 0;
        int i = 0;
        while (i < tlen) {
            char c = target.charAt(i);
            if (!set.contains(c)) return -1;
            while (j < slen && c != source.charAt(j)) {
                j++;
            }
            if (j == slen) { // if to end. redo this char
                j = 0;
                ans++;
            } else {
                i++;
                j++;
            }
        }
        return ans;
    }

    /**
     * only works for unique character in source
     **/
    public int shortestWay2(String source, String target) {
        int[] sr = new int[26];
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            sr[c - 'a'] = i;
        }
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (sr[c - 'a'] == -1) return -1;
            int base = sr[c - 'a'] + ans * source.length();
            if (!(i <= base && base > pre)) {
                ans++;
            }
            pre = sr[c - 'a'] + ans * source.length();
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        ShortestWaytoFormString1055M t = new ShortestWaytoFormString1055M();
        System.out.println(t.shortestWay("abc",
                "abcbc"));
    }
}
