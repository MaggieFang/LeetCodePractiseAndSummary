package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class RemoveElement27M {
    /**
     * KEYPOINTS:
     * <p>
     *     use two pointer cur and hi, the cur is to find the first elm == val from low to high,
     *     and high is to find the first non val, and exchange them.
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
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int i = 0;
        int high = nums.length - 1;
        int result = 0;
        while(i < high){
            while(i < n && nums[i] != val){
                i++;
                result = i; // e.g [3,3] 5 case
            }
            while(high > i && nums[high] == val){
                high--;
            }

            if(i < high & i < n){
                int tmp = nums[i];
                nums[i] = nums[high];
                nums[high] = tmp;
                i++;
                high--;
                result = i;
            }

        }

        if(i < n && nums[i] != val){ //when i and high meet, we know 0 ~ i-1 are not val. but the current one may be val ro not.
            return result+1;
        }
        return result;
    }

    public static void main(String[] ars) {
        removeElement(new int[]{3, 2, 2, 3}, 3);
    }
}
