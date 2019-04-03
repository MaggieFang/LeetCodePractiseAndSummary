package com.twopointer;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-04-02
 * Talk is cheap,show me the Code.
 **/
public class ThreeSumSmaller259M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * refer to ThreeSumClosestTarget16M
     * * get all the triplets of the array and check it meet the requirment
     * * improve: if the array is sorted. then it can be reduced to O(n^2)
     * *         because we can do a loop  for i = 0 to n-3 and
     * *         and use two pointer low,hi to calculate sum = num[i]+num[low]+num[high],
     *           if sum < target, then ith,lowth and index from low to high (call opt) ,there exists num[i]+num[low]+num[opt] < target
     *           else, the high is too large, so move left for high
     * </p>
     * TIME COMPLEXITY:O(n^2)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < target) { // if here, then all index that lower than high (we cal it opt ) till to low index, nums[i]+nums[low]+ nums[opt] can meet the requirement
                    ans += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return ans;
    }
}
