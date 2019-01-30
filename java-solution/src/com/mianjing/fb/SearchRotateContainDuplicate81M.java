package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class SearchRotateContainDuplicate81M {
    public static boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid - 1;
                else start = mid + 1; // start = mid  is also ok
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1; // end = mid is also ok
            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1};
        search(A, 1);
    }
}
