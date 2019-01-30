package com.easy.dp;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/22/18
 * Talk is Cheap,Show me the Code.
 **/
public class HouseRobber198 {
    /**
     * KEYPOINTS:
     * <p>
     * 1. read two great article for tabulation and memoizatation solution of dp.
     * https://www.geeksforgeeks.org/tabulation-vs-memoizatation/
     * https://programming.guide/dynamic-programming-vs-memoization-vs-tabulation.html
     * 2. This is how i think about this problem  below:
     * if we know dp[x],how to calculate dp[x+1], easily to come to max{dp[x],dp[x-1]+A[x+1]}
     * so we need two result to calculate the third one.
     * and we can easily get dp[0] = A[0];dp[1] = Max{A[0],A[1]}
     * so we can use tabulation to calculate dp[3],dp[4]...dp[n]
     * it is similar to fib problem.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n)
     * <p>
     * SPACE COMPLEXITY:O(n)
     * <p>
     **/
    public int robBottomToTop(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }

    /**
     * KEYPOINTS:
     * <p>
     * from the robBottomToTop,we can easily know that it is enough to just store two pre result.
     * So we can reduce the space O(n) to O(1)
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int robSimple(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int pre0 = nums[0];
        int pre1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int result = Math.max(pre0 + nums[i], pre1);
            pre0 = pre1;
            pre1 = result;

        }
        return pre1;
    }
}
