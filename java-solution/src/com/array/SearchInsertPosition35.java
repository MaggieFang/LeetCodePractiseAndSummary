package com.array;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int hi = nums.length - 1;

        while (low <= hi) {
            int mid = (low + hi) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return low;

    }
}
