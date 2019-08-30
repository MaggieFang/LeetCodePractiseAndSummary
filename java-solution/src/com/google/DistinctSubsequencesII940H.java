package com.google;

import java.util.Arrays;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-28
 **/
public class DistinctSubsequencesII940H {

    public static int distinctSubseqII(String S) {
        long end[] = new long[26], mod = (long) 1e9 + 7;
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum() % mod + 1;
        return (int) (Arrays.stream(end).sum() % mod);
    }

    public int distinctSubseqII2(String S) {
        int end[] = new int[26], res = 0, added = 0, mod = (int)1e9 + 7;
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
