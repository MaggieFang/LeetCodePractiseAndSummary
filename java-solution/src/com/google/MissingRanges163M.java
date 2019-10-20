package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-04
 **/
public class MissingRanges163M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * don't forget the cases such as nums = [], lower = 1,upper = 1, what expect is ['1']
     * and nums = [Integer.MAX_VALUE] , lower = 0, upper=MAX_VALUE
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(formRange(lower, upper));
            return result;
        }

        // 1st step
        if (nums[0] > lower) {
            result.add(formRange(lower, nums[0] - 1));
        }

        // 2nd step
        for (int i = 0; i < nums.length - 1; i++) {
            //考虑nums[0] MIN_VALUE情况
          //  [-2147483648,-2147483648,0,2147483647,2147483647], -2147483648, 2147483647
            if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1) {
                result.add(formRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // 3rd step, 一定不会
        if (nums[nums.length - 1] < upper) {
            //一定不会nums[lastIndex]是MAX_VALUE情况了
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        return result;

    }

    public String formRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}
