package com.fb;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-02
 * Talk is cheap,show me the Code.
 **/
public class MaximumSizeSubarraySumEqualsk325M {
    /**
     * Clarification:
     * [-2,-1,2,1]
     * 1
     *
     * </p>
     * Keypoints:
     * HashMap stores  sum of all elements before index i ,sum as key, and i as value.
     * For each i, check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k.
     * so when sum up a elenment, check whether the sum  == k, if yes, update max; else check whether map contains key (sum - k),
     * if yes and value is j,then it means from index j~i, it sums up k.
     * and update max length.
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = Math.max(max, i + 1);
            // 其实这里也可以用if,而不用else,因为可能之前的有和为0的，只是问题求最长，如果sum == k成立，那么任何 j~i 和 == k也没有sum== k长
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            //if the current sum have been stored,we needn't update or store all the index of it. just store the earliest index since we find the longest length.
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
