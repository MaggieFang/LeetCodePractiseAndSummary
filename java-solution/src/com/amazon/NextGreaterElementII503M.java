package com.amazon;

import java.util.Stack;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-02
 **/
public class NextGreaterElementII503M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  use a stack to store the index that are larger than the current num but since this is the circular array.
     *  so we need to traversal two pass. the second pass can correct the first pass that are not look into the prior ones.
     *
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(n)
     * </p>
     **/
    public int[] nextGreaterElements2(int[] nums) {
        int[] r = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]) stack.pop();
            r[i % n] = stack.size() > 0 ? nums[stack.peek()] : -1;
            stack.push(i % n);
        }

        return r;
    }

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * the difference with DailyTemperatures739M is when reached to end, we  need to begin from the 0 the i-1
     *
     * </p>
     * TIME COMPLEXITY: O(n^2)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int[] nextGreaterElements(int[] nums) {
        int[] r = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && nums[j] <= nums[i]) {
                j++;
            }
            if (j == nums.length) {
                j = 0;
                while (j < i && nums[j] <= nums[i]) {
                    j++;
                }
            }
            r[i] = j == i ? -1 : nums[j];
        }

        return r;
    }
}
