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
     * similar to Q15, the brute force need O(n^3)
     * but sort first and use low and high point to make O(n^2);
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
        int ans = 0;
        Arrays.sort(nums);
        int priorAbs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            //  int sum = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int abs = Math.abs(sum - target);
                if (priorAbs > abs) {
                    ans = sum;
                    priorAbs = abs;
                }
                if (sum == target) return ans;
                else if (sum < target) left++;
                else right--;

            }
        }
        return ans;

    }
}
