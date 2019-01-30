package com.mianjing.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class LongestIncreasingSub674E {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = 1;
        int ans = 0;
        // int index = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] >= nums[right-1]) {
                right++;
            }

            int length = right - left;
            ans = Math.max(length, ans);
            left = right;
            right = right + 1;


        }
        return ans;

    }
    public static void main(String[] args){
        int[] A = new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(A));
    }
}
