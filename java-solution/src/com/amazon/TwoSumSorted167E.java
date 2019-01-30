package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class TwoSumSorted167E {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length -1;
        while( i < j){
            if(nums[i] + nums[j] == target){
                return new int[]{i+1,j+1};
            }else if(nums[i] + nums[j] < target){
                i++;
            }else{
                j--;
            }
        }
        return new int[2];
    }
}
