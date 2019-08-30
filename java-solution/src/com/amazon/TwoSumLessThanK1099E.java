package com.amazon;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-30
 **/
public class TwoSumLessThanK1099E {
    public int twoSumLessThanK(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = -1;
        for (int e : A) {
            Integer pri = set.lower(K - e);
            if (pri != null) {
                res = Math.max(res, pri + e);
            }
            set.add(e);
        }
        return res;
    }
}
