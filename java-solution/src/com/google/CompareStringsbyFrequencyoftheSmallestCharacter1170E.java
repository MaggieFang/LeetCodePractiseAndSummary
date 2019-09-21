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
     *  you can use Arrays.binarySearch() directly. when index found is < 0, its correct position is ~index
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = fArray(queries);
        int[] w = fArray(words);
        Arrays.sort(w);
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(w, q[i]);
            if (idx >= 0) {
                while (idx < words.length && w[idx] == q[i]) {
                    idx++;
                }
            } else {
                idx = ~idx;
            }
            res[i] = words.length - idx;
        }
        return res;
    }

    private int[] fArray(String[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = f(arr[i]);
        }
        return res;
    }

    private int f(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            map[c]++;

        }
        for (int i : map) {
            if (i != 0) {
                return i;
            }
        }
        return 0;
    }
}
