package com.google;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-11
 * Talk is cheap,show me the Code.
 **/
public class ContainsDuplicateII219E {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
