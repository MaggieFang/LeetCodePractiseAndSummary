package com.bb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-23
 **/
public class MergeIntervals56M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  sort the interview with the start time.
     *  from the second element, if the start time <= last end time. they should be combined. so update the end time.
     *  else add a new interview to the result
     *
     * </p>
     * TIME COMPLEXITY: O(NLogN)
     * SPACE COMPLEXITY: O(1) or O(N)
     * </p>
     **/
    public int[][] merge(int[][] ins) {
        if (ins == null || ins.length == 0) return new int[][]{};
        Arrays.sort(ins, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{ins[0][0], ins[0][1]});
        for (int i = 1; i < ins.length; i++) {
            int[] cur = ins[i];
            int[] last = list.get(list.size() - 1);
            if (cur[0] <= last[1]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                list.add(new int[]{cur[0], cur[1]});
            }
        }
        int[][] res = new int[list.size()][2];
        res = list.toArray(res);
        return res;


    }
}
