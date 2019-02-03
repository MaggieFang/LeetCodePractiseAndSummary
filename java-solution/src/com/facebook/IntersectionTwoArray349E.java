package com.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class IntersectionTwoArray349E {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                ans.add(i);
            }
        }

        int[] r = new int[ans.size()];
        int i = 0;
        for (int n : ans) {
            r[i++] = n;
        }
        return r;
    }

}
