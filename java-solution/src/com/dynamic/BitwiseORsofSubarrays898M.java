package com.dynamic;

import java.util.HashSet;
import java.util.Set;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-30
 **/
public class BitwiseORsofSubarrays898M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  the brute force is to calculate every result r(i,j) = A[i] | A[i+1]|...|A[j]
     *  we can speed it by reusing the prior result for r(i,j+1) = r(i,j)|A[j+1], this will O(n^2)
     *
     *  further improvement: we can think about segment, for first element, the result is A0,
     *  when we comes to A1, we need to add A0|A1, A1. so we can use the prior result
     *  when comes to A2, we need to add A0|A1|A2, A1|A2,A2
     *  so we see that, we can always preserve our current result set to compute the next Ai involved and always update our cur result set.
     * </p>
     * TIME COMPLEXITY: O(NlogW) N is the length of A and W is the max size of elements in  A.
     * SPACE COMPLEXITY: O(NlogW)
     * </p>
     **/
    public int subarrayBitwiseORs2(int[] A) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int x : A) {
            Set<Integer> cur2 = new HashSet<>();
            cur2.add(x);
            for (int y : cur) {
                cur2.add(x | y);
            }
            set.addAll(cur2);
            cur = cur2;
        }
        return set.size();
    }


    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            int r = A[i];
            for (int j = i + 1; j < A.length; j++) {
                r = r | A[j];
                set.add(r);
            }
        }
        return set.size();

    }
}
