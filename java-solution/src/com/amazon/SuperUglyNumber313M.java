package com.amazon;

import java.util.TreeSet;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-05-09
 * Talk is cheap,show me the Code.
 **/
public class SuperUglyNumber313M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * same as UglyNumberII264M
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            long e = set.pollFirst();
            for (int p : primes) {
                set.add(e * p);
            }
        }
        return set.first().intValue();
    }
}
