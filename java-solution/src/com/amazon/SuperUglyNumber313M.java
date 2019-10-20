package com.amazon;

import java.util.TreeSet;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-05-09
 * Talk is cheap,show me the Code.
 **/
public class SuperUglyNumber313M {
    /**
     * Clarification:
     * * same as UglyNumberII264M
     * </p>
     * Keypoints:
     * TreeSet. put 1 into it firstly, and pollFirst out. and use this min poll value multiply all the primes, and push to the treeset.
     * after n-1 times pollFirst. the next pollFirst is what we want.
     *
     * we should use treeset instead of pq, since pq will have the problem of duplicate number in the queue.
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
