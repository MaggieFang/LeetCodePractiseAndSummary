package com.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-02
 * Talk is cheap,show me the Code.
 **/
public class FourSum18M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * extend to ThreeSum15M,add one more looop
     *
     * </p>
     * TIME COMPLEXITY: O(N^3)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    //
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        boolean inner = false;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                //we skip same neighbouring  when the i is fix.so it is inner loop condition. otherwise we cannot,
                // e.g -4 -1 -1  0 1 2, target = -1, when i to to 1th, j = 2th, if we dont have inner indictor, we will miss the [-1,-1,0,1]
                if (inner && j != 1 && nums[j] == nums[j - 1]) continue;
                inner = true;
                int compensate = target - nums[i] - nums[j];
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == compensate) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1]) low++;
                        while (low < high && nums[high] == nums[high + 1]) high--;
                    } else if (nums[low] + nums[high] < compensate) {
                        low++;
                    } else {
                        high--;
                    }

                }
            }
            inner = false;
        }
        return ans;

    }

}

