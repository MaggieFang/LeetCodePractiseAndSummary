package com.array;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-26
 * Talk is cheap,show me the Code.
 **/
public class ShortestUnsortedContinuousSubarray581 {
    /**
     * Clarification:
     * </p>
     * Keypoints:
     *  try to find the min element that are not in correct position(!!! not find the min of the array) ,mark min
     *  similarly, we also need the max elemenemt that are not in correct position. mark max.
     *  then, we try to find their correct position. so we can find the result
     * </p>
     * TIME COMPLEXITY: O(N)
     * SPACE COMPLEXITY:O(1)
     * </p>
     **/
    public int findUnsortedSubarray1(int[] nums) {
        if (nums.length <= 1) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                min = Math.min(nums[i], min);
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                max = Math.max(nums[i], max);
            }
        }

        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }

        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;

    }

    /**
     * Clarification:
     * This kind of question please draw 折线图
     * It is troublesome  of this problem. You need to consider many conditions of it
     * e.g sorted ：{1,2,3,4},{4,3,2,1},
     * gerenal :{2,6,4,8,10,9,15}
     * {1,2,3,3}
     * {2,3,3,2,4}
     * </p>
     * Keypoints:
     * we try to find the left and right elements where they are not in the correct position.
     * if we sort nums,then we can compare each elem of the same position with the original one to check whether same.
     * if not, the currenct position is what we find. find left from left and find right from right
     *
     * </p>
     * TIME COMPLEXITY: O(NlogN)
     * SPACE COMPLEXITY: O(N)
     * </p>
     **/
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = nums.clone();
        Arrays.sort(copy);
        int left;
        int right;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != copy[i]) {
                break;
            }
        }
        left = i;
        if (left == nums.length) return 0;

        i = nums.length - 1;
        for (; i >= 0; i--) {
            if (nums[i] != copy[i]) {
                break;
            }
        }

        right = i;
        return right - left + 1;

    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray581 t = new ShortestUnsortedContinuousSubarray581();
        t.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
}
