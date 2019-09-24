package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class SearchRotateSortedArray33M {
    /**
     * KEYPOINTS:
     * <p>
     * find the offset it rotate
     * and when use binary method,when get mid, we use (mid+offset) % n to get the real index it is.
     * and compare the target with the realMid.
     * </p>
     * TIME COMPLEXITY: O(LogN)
     * <p>
     * SPACE COMPLEXITY:O(C)
     * <p>
     **/
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int hi = nums.length -1;
        //find the index smallest number that rotate.
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if(nums[mid] < nums[hi]){ //说明从mid到hi是升序的。所以至少rotate点在左边或者就是mid，不能比较left跟mid来移动left到右边，[1,3]
                hi = mid;
            }else {
                low = mid+1;
            }
        }

        int rot = low;
        low = 0;
        hi = nums.length;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            int realMid = (mid + rot) % nums.length;
            if (nums[realMid] == target) {
                return realMid;
            }

            if (nums[realMid] < target) {
                low = mid + 1;
            } else {
                hi = mid;
            }
        }
        return -1;
    }

    /**
     * KEYPOINTS:
     * <p>
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public int search2(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low =0;
        int hi = nums.length -1;
        while(low <= hi){
            int mid = low + (hi - low)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[low]){ // nums[low,..mid] is sorted.
                if(nums[mid] > target && nums[low] <= target){
                    hi = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] < nums[low]){ //num[mid] < nums[low], so nums[mid..end] sorted
                if(nums[mid] < target && nums[hi] >= target){
                    low = mid +1;
                }else{
                    hi = mid - 1;
                }

            }else{ // nums[mid] == nums[low] such as mid = low.  [3,1] to find 1
                low++;
            }
        }
        return -1;
    }
    /**
     * KEYPOINTS:
     * <p>
     *    same with Q 81
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/

    public int search3(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low =0;
        int hi = nums.length -1;
        while(low <= hi){
            int mid = low + (hi - low)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[low] < nums[mid]){//[start,mid] are sorted
                if(nums[low] <= target && nums[mid] > target){
                    hi = mid - 1;
                }else {
                    low = mid + 1;
                }
            }else if(nums[low] > nums[mid]){ //[mid,end] are sorted
                if(nums[mid] < target && nums[hi] >= target){
                    low = mid +1;
                }else {
                    hi = mid - 1;
                }
            }else{
                low = low +1;
            }
        }
        return -1;
    }

}
