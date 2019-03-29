package com.array;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-29
 * Talk is cheap,show me the Code.
 **/
public class MinimumSizeSubarraySum209M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  two pointers:
     *   fix left ,init 0,  then loop the numbers. add it to sum; and judge if >= s,then minus nums[left++],
     *   it may still >= s,so use a while loop for this step
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int left = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) { // 巧妙，学习!
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res; // 可能 3,[1,1]
    }
}
