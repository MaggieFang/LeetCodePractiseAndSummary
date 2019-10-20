package com.google;

import java.util.Arrays;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-28
 **/
public class DistinctSubsequencesII940H {

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * end long[26] to put the possibility that end with this char.
     * so end[c -'a'] = sum(end) + 1 means we can append c to all the existing result, + 1 means c itself.
     * e.g abc
     * end['a'] = 1, which means there are 'a'
     * end['b'] = sum(end) + 1, which means it can be 'ab','b'
     * end['c'] = sum(end) + 1, which means it can be 'ac','abc','bc','c'
     * ..
     * when we mean a duplicate, e.g for some time point, a new 'a' comes. it doesn't matter, some logic
     * since we append this 'a' to the existing 'a' in end['a'], so we still need to +1.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public static int distinctSubseqII(String S) {
        long end[] = new long[26], mod = (long) 1e9 + 7;
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
        return (int) (Arrays.stream(end).sum() % mod);
    }

    public int distinctSubseqII2(String S) {
        int end[] = new int[26], res = 0, added = 0, mod = (int) 1e9 + 7;
        for (char c : S.toCharArray()) {
            added = (res + 1 - end[c - 'a']) % mod;
            res = (res + added) % mod;
            end[c - 'a'] = (end[c - 'a'] + added) % mod;
        }
        return (res + mod) % mod;
    }


    public static void main(String[] args) {
        System.out.println(distinctSubseqII("ab"));

    }
}
