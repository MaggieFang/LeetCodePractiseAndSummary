package com.easy.dp;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/22/18
 * Talk is Cheap,Show me the Code.
 **/
public class ClaimStairs70 {
    /**
     * KEYPOINTS:
     * <p>
     *    when n = x, assuming it has dp[x] ways to climb.so dp[x+1] = dp[x]+dp[x-1]
     *    because we can climb the pre x阶 as dp[x] and the last 1 step
     *    we also can climb the pre  x-1 as dp[x-1] and the last 2 steps one time.
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
    **/
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i <= n; i++) {
            int result = pre1 + pre2;
            pre1 = pre2;
            pre2 = result;
        }
        return pre2;

    }

}
