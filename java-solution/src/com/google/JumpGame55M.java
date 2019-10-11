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
     * but if ith can jump to last index, we need to know ith can be reached by the prior ones. how?
     * when traversalfrom left. we keep and update a param v to store the max index can reached so far.
     * if v < i it means it can never reach ith. return false.
     ** </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true; //{0}
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            // means it can never reach here. don't concern about if there are some other solution latter.even if we use "continue" here. but
            // v didn't change, and i increase, in v < i, it also holds when i increase
            if(v < i) return false;
            if (nums.length - 1 - i <= nums[i]) return true;
            v = Math.max(v, i + nums[i]); // the max index can be reach so far.
        }
        return false;

    }

    //Time limite exceed
//    boolean ans = false;
//    public boolean canJump(int[] nums) {
//        if(nums.length == 1) return true;
//        helper(nums,0);
//        return ans;
//    }
//    private void helper(int[] nums,int idx){
//        if(ans || idx >= nums.length) return;
//        if(nums.length - 1 - idx <= nums[idx]){
//            ans = true;
//            return;
//        }
//        for(int i = 1; i <= nums[idx]; i++){
//            helper(nums,idx+i);
//        }
//    }
}
