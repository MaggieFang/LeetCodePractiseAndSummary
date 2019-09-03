package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-02
 **/
public class TrappingRainWater42H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints: divide and conquer https://www.youtube.com/watch?v=HmBbcDiJapY
     *  for each index element, compute its maxLeft(highest) and maxRight, then we can know how much water this unit can hold.
     *
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(n)
     * </p>
     **/
    public int trap(int[] h) {
        if (h == null || h.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = h.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = h[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], h[i]);
        }

        rightMax[n - 1] = h[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], h[i]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(rightMax[i], leftMax[i]) - h[i];
        }
        return ans;
    }
}
