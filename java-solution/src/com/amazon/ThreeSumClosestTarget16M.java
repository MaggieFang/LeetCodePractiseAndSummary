package com.amazon;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class ThreeSumClosestTarget16M {
    /**
     * KEYPOINTS:
     * <p>
     *    similar to Q15, the brute force need O(n^3)
     *    but sort first and use low and high point to make O(n^2);
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n^2)
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int sum = 0;
        int dif = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int tmp = nums[i] + nums[low] + nums[high];
                if (Math.abs(tmp - target) < dif) {
                    sum = tmp;
                    dif = Math.abs(tmp - target);
                }
                if (tmp == target) {
                    return sum;
                } else if (tmp < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return sum;
    }
}
