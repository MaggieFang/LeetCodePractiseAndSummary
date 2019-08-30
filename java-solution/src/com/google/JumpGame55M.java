package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-30
 **/
public class JumpGame55M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * we just need to know the maximum reach when in the specific index. and if it could be larger than the last index.
     * it means I could go to the last index within the step. e.g for ith, i+num[i] >= lastIndex, then one try with (lastIndex -i) steps
     * to get to the last .
     * But notice that if last v is smaller than i, than it means it never can reach to ith. so in this case it should be false.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true; //{0}
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            if (v < i) return false; //{3, 2, 1, 0, 4}. if last v < i, it means there is no way to reach ith.
            v = Math.max(v, i + nums[i]);
            if (v >= nums.length - 1) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        JumpGame55M test = new JumpGame55M();
        System.out.println(test.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
