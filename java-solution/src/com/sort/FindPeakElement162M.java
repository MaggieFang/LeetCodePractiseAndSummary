package com.sort;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/2/19
 * Talk is Cheap,Show me the Code.
 **/
public class FindPeakElement162M {
    /**
     * use the idea and drawing from linear scan.https://leetcode.com/problems/find-peak-element/solution/
     **/
    public int findPeakElementBinarySeach(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * only compare num[i] and num[i+1] since there are only 3 cases . increasing order ,decreasing order, descreaing then increasing.
     * for all ,when we can reach nums[i], it must be num[i-1] < num[i]
     **/
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
