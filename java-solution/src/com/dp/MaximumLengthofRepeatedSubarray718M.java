package com.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-04
 **/
public class MaximumLengthofRepeatedSubarray718M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * Since a common subarray of A and B must start at some A[i] and B[j], let dp[i][j] be the longest common prefix of A[i:] and B[j:].
     * Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1. Also, the answer is max(dp[i][j]) over all i, j.
     * We can perform bottom-up dynamic programming to find the answer based on this recurrence.
     * Our loop invariant is that the answer is already calculated correctly and stored in dp for any larger i, j.
     * </p>
     * TIME COMPLEXITY: O（M*N）
     * SPACE COMPLEXITY:O（M*N）
     * </p>
     **/
    public int findLengthDP(int[] A, int[] B) {
        int ans = 0;
        int m = A.length;
        int n = B.length;
        int[][] memo = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1;
                }
                ans = Math.max(ans, memo[i][j]);

            }
        }
        return ans;
    }

    // exceed time limit
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.computeIfAbsent(B[i], x -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                continue;
            }
            for (int j : map.get(A[i])) {
                int k = 0;
                while (i + k < A.length && j + k < B.length && A[i + k] == B[j + k]) {
                    k++;
                }
                ans = Math.max(ans, k);
            }

        }
        return ans;
    }

}
