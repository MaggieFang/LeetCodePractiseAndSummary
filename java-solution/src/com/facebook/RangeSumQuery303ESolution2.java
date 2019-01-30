package com.facebook;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class RangeSumQuery303ESolution2 {

    /**
     * KEYPOINTS:
     * <p>
     * what if the  sumRange call many times? or there are many duplicate call?
     * we can make some improvement.
     * if we have sum[] ,sum[i] are the sum from 0 to i;
     * so sum[i,j] = sum[j]-s[i-1];
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(1) for call sumRange()
     * <p>
     * SPACE COMPLEXITY:O(n)
     * <p>
     **/

    int[] sum;

    public RangeSumQuery303ESolution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

    }

    public int sumRange(int i, int j) {
        if(i - 1 <0){
            return sum[j];
        }else {
            return sum[j] - sum[i-1];
        }

    }

}
