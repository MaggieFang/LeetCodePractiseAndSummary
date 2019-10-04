package com.google;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-20
 **/
public class CompareStringsbyFrequencyoftheSmallestCharacter1170E {
    /**
     * Clarification:
     * counting sort!!!
     * </p>
     * Keypoints:
     * Counting sort is a sorting technique based on keys between a specific range
     * since it says 1 <= queries[i].length, words[i].length <= 10
     * so we can use a base int[11] to count the words f(), and using counting sort for it.
     * so base[i] mean the number of the fre <= i.
     * so when traversal queries, get the freq of queries[i], get ans [i] = words.length - base[i]
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int[] numSmallerByFrequency2(String[] qs, String[] ws) {
        int nq = qs.length;
        int nw = ws.length;
        int[] base = new int[11];
        for (int i = 0; i < nw; i++) {
            int cur = f(ws[i]);
            base[cur]++;
        }
        for (int i = 1; i < base.length; i++) {
            base[i] += base[i - 1];
        }
        int[] ans = new int[nq];
        for (int i = 0; i < nq; i++) {
            int cur = f(qs[i]);
            ans[i] = nw - base[cur];

        }
        return ans;
    }

    /**
     * Clarification:
     * you can use Arrays.binarySearch() directly. when index found is < 0, its correct position is -index  -1
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int[] numSmallerByFrequency(String[] qs, String[] ws) {
        int nq = qs.length;
        int nw = ws.length;
        int[] base = new int[nw];
        for (int i = 0; i < nw; i++) {
            base[i] = f(ws[i]);
        }
        Arrays.sort(base);
        int[] ans = new int[nq];
        for (int i = 0; i < nq; i++) {
            int cur = f(qs[i]);
            int index = Arrays.binarySearch(base, cur);
            if (index < 0) {
                index = -index - 1;
            }
            while (index < base.length && base[index] == cur) index++; // important, 如果两个cur在base能找到，要一直右移动到找不到到位置，
            ans[i] = base.length - index;
        }
        return ans;
    }

    private int f(String s) {
        int[] ans = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a']++;
        }

        for (int e : ans) {
            if (e != 0) {
                return e;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CompareStringsbyFrequencyoftheSmallestCharacter1170E t = new CompareStringsbyFrequencyoftheSmallestCharacter1170E();
//        t.numSmallerByFrequency2(new String[]{"bba", "abaaaaaa", "aaaaaa", "bbabbabaab", "aba", "aa", "baab", "bbbbbb", "aab", "bbabbaabb"},
//                new String[]{"aaabbb", "aab", "babbab", "babbbb", "b", "bbbbbbbbab", "a", "bbbbbbbbbb", "baaabbaab", "aa"});
        t.numSmallerByFrequency2(new String[]{"cbd"}, new String[]{"zaaaz"});
    }
}
