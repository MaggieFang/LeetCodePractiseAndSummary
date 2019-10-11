package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

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

    // treeset only works for unique elements.
//    public List<Integer> countSmaller2(int[] nums) {
//        if (nums == null || nums.length == 0) return new ArrayList<>();
//        Integer[] ans = new Integer[nums.length];
//        ans[nums.length - 1] = 0;
//        TreeSet<Integer> t = new TreeSet<>();
//        t.add(nums[nums.length - 1]);
//        for (int i = nums.length - 2; i >= 0; i--) {
//            int cur = nums[i];
//            ans[i]=t.headSet(cur,false).size();
//        }
//        return Arrays.asList(ans);
//    }
}
