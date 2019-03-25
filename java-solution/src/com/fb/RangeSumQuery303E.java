package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class RangeSumQuery303E {

    private int[] nums;

    public RangeSumQuery303E(int[] nums) {
        this.nums = nums;

    }
    public int sumRange(int i, int j) {
        if (nums == null || nums.length == 0 || i < 0) {
            return 0;
        }

        int ans = 0;
        for (int s = i; s <= j && s < nums.length; s++) {
            ans += nums[s];
        }
        return ans;
    }

}
