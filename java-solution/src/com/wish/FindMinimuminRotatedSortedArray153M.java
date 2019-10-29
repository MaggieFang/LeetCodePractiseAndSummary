package com.wish;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-24
 **/
public class FindMinimuminRotatedSortedArray153M {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        if(nums[0] < nums[right]){
            return nums[0];
        }

        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[mid -1] > nums[mid]){
                return nums[mid];
            }

            if(nums[mid] > nums[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
