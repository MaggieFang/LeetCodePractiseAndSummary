package com.easy.math;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-05-09
 * Talk is cheap,show me the Code.
 **/
public class UglyNumberII264M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints: use a treeSet, from the most basic element 2,3,5,
     * for every element,when we multiply 2,3,5 on it. it also meet ugly number definition
     * so we can use a treest, initiate with 1, and pop it out to multiply 2,3,5 and add it to set.
     * when we do n times pop. we first element is our answer.
     *
     * we should use treeset instead of  priorityQueue here since if use pq, there will be duplicate numbers in pq.
     * e.g when pop 2, we will 2*3 put 6. and  when pop 3, we also push 3*2 = 6 into it.
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            long l = set.pollFirst();
            set.add(l * 2);
            set.add(l * 3);
            set.add(l * 5);
        }
        return set.first().intValue();

    }

}
