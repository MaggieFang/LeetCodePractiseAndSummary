package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class FindFirstAndLastPositionOfElementSort34M {

    public static int[] searchRange1(int[] A, int target) {
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
    }

    //find the first number that is greater than or equal to target.
    //could return A.length if target is greater than A[A.length-1].
    private static int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            //low <= mid < high
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                //should not be mid-1 when A[mid]==target.
                //could be mid even if A[mid]>target because mid<high.
                high = mid;
            }
        }
        return low;
    }
    //do linear scan, from left.,find the first,and then from right find last
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        if(nums == null || nums.length == 0){
            return ans;
        }
        int n = nums.length;
        int low = 0;
        while(low < n && nums[low] < target){
            low++;
        }
        if(low < n && nums[low] == target){
            ans[0] = low;
        }else{
            return ans;
        }

        int high = nums.length -1;
        while(high > low && nums[high] > target){
            high--;
        }

        ans[1] = high;
        return ans;
    }

    public static void main(String[] args){
        System.out.println(searchRange1(new int[]{2,5,7,7,8,8,10},8));
    }
}
