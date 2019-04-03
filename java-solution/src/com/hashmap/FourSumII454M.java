package com.hashmap;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-02
 * Talk is cheap,show me the Code.
 **/
public class FourSumII454M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * brute force is O(N^2) , but think of two sum. using a map can reduce complexity by half.
     * so here, we can use a map to put the sum of all pairs of A and B, key is sum, the value is the number of occurrence of this sum
     * when travel C[i]+D[j],we just check if the opposite sum is in the ma[
     * </p>
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(N^2)
     * </p>
     **/
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int t = -C[i] - D[j];
                if (map.containsKey(t)) {
                    ans += map.get(t);
                }
            }
        }
        return ans;
    }
}
