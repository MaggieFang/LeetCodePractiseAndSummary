package com.dp;

import java.util.HashMap;
import java.util.Map;

import sun.nio.cs.ext.MacHebrew;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/5/19
 * Talk is Cheap,Show me the Code.
 **/
public class TargetSum {
    /**
     * KEYPOINTS:
     * we recursively call targetNum(nums,T,i+1,sum+nums[i]) and targetNum(nums,T,i+1,sum-nums[i])
     * we define our subprblem targetNum(nums,T,i,sum) is the number of possible combination of adding and subtract
     * the number at or after i.
     * Similar to 01 knapsack
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/

    public int targetSumTopDown(int[] nums, int T) {
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return targetSumTopDown(nums, T, 0, 0, cache);

    }

    private int targetSumTopDown(int[] nums, int T, int i, int sum, Map<Integer, Map<Integer, Integer>> cache) {
        if (i == nums.length) {
            return sum == T ? 1 : 0;
        }
        if (!cache.containsKey(i)) {
            cache.put(i, new HashMap<Integer, Integer>());
        }
        Integer result = cache.get(i).get(sum);
        if (result != null) return result;
        int toReturn = targetSumTopDown(nums, T, i + 1, sum + nums[i], cache) + targetSumTopDown(nums, T, i + 1, sum - nums[i], cache);
        cache.get(i).put(sum, toReturn);
        return toReturn;
    }

    /**
     * KEYPOINTS:
     * <p>
     * iterate through the array and recursively add or substract each vaule from the total
     * once reach the end of nums,check whether the total == T if yes,we found one.
     * </p>
     * TIME COMPLEXITY:O(2^n)
     * <p>
     * SPACE COMPLEXITY:the depth of recursion, in this case is the length of input O(n)
     * <p>
     **/
    public int targetSum(int[] nums, int T) {
        return targetSum(nums, T, 0, 0);

    }

    private int targetSum(int[] nums, int T, int i, int sum) {
        if (i == nums.length) {
            return sum == T ? 1 : 0;
        }
        return targetSum(nums, T, i + 1, sum + nums[i]) + targetSum(nums, T, i + 1, sum - nums[i]);
    }
}
