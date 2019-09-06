package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-05
 **/
public class IncreasingTripletSubsequence334M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * for each nums[i], if we can know there is one element on left < nums[i] and one element on right > nums[i]
     * the result should be true.
     * we can use two array small[n] and large[n] to indicate nums[i]'s  smallest element on the left and the largest element on the right.
     * and small[i] = min(small[i-1],nums[i])
     * and large[i] = max(large[i+1],nums[i])
     * then we check if there are small[i] < num[i] < large
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(n)
     * </p>
     **/
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int[] small = new int[nums.length];
        int[] large = new int[nums.length];
        small[0] = nums[0];
        large[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            small[i] = Math.min(small[i - 1], nums[i]);
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            large[i] = Math.max(nums[i], large[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (small[i] < nums[i] && nums[i] < large[i]) return true;
        }
        return false;
    }
}
