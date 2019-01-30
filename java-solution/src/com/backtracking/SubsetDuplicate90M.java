package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class SubsetDuplicate90M {
    /**
     * KEYPOINTS:
     * <p>
     * difference from 46 is sort the nums first.
     * and in the for loop.if cur is equals to the pre, skip it.
     * e.g [1,2,3,2]
     * <p>
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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        return ans;

    }

    public void helper(int[] nums, int s, List<List<Integer>> ans, List<Integer> chosen) {
        ans.add(new ArrayList<>(chosen));
        for (int i = s; i < nums.length; i++) {
            if (i > s && nums[i] == nums[i - 1]) {
                continue;
            }
            chosen.add(nums[i]);
            helper(nums, i + 1, ans, chosen);
            chosen.remove(chosen.size() - 1);
        }
    }

}
