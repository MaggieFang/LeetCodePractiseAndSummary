package com.easy.dp;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class MaximumProductSubarray152M {
    public int maxProductBruteForce(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curMax = Integer.MIN_VALUE;
            int tmp = 1;
            for (int j = i; j < nums.length; j++) {
                tmp = tmp * nums[j];
                if (tmp > curMax) {
                    curMax = tmp;
                }
            }
            max = Math.max(max, curMax);
        }
        return max;
    }

    public int maxProductDp(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] max = new int[nums.length]; // max[i] of nums[0,...i] that contains nums[i];
        int[] min= new int[nums.length];  //min[i] of nums[0..i] that contains nums[i];
        max[0] = nums[0];
        min[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(max[i-1]*nums[i],min[i-1]*nums[i]),nums[i]);
            min[i] = Math.min(Math.min(max[i-1]*nums[i],min[i-1]*nums[i]),nums[i]);
            result = Math.max(max[i],result);
        }
        return result;
    }
}
