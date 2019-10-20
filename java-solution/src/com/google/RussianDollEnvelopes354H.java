package com.google;

import java.util.Arrays;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-06
 **/
public class RussianDollEnvelopes354H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * this can use the extact same method with LongestIncreasingSubSeq300M.
     * which is (we make c[i] be the longest x[0,,i] that contains x[i]; how to get c[i]?
     *      * we should find the max{c[j]} of 0<= j < i at the same time only the x[j] < x[i]( to ensure we can include x[i]) ,
     *      * and the final result is the max{c[i]} 0<=i <n.20)
     *
     * just need to sort the start first in this problem
     * then we make c[i] be the max envs[0..i] that contains envs[i]; how to get c[i]?
     *      * we should find the max{c[j]} of 0<= j < i at the same time only the envs[j] < envs[i],
     *      * and the final result is the max{c[i]}
     * </p>
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY:O(n)
     * </p>
     **/
    public int maxEnvelopes(int[][] envs) {
        if (envs == null || envs.length == 0) return 0;
        Arrays.sort(envs, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        int n = envs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envs[j][0] < envs[i][0] && envs[j][1] < envs[i][1]) { //前个判断要,sorted后的start可能相等，相等也不能装，必须是 <
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;

    }

}
