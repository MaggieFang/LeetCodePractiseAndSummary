package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-05
 **/
public class CountofSmallerNumbersAfterSelf315H {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Integer[] ans = new Integer[nums.length];
        ans[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int cur = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) cur++;
            }
            ans[i] = cur;
        }

        return Arrays.asList(ans);
    }
}
