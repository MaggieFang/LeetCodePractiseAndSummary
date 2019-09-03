package com.mianjing.gou;

import com.basicStructure.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/16/19
 * Talk is Cheap,Show me the Code.
 **/
public class InsertInterval57H {
    /**
     * Clarification:
     *  test cases:
     *  new int is less than all, e.g newIn = [0,0], int={[5,7]}
     *  new int is larger than all
     *  new int cross some
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY:O(n)
     * </p>
     **/
    public int[][] insert(int[][] in, int[] newIn) {
        if (in == null || in.length == 0) return new int[][]{newIn};

        List<int[]> list = new ArrayList<>();
        int i = 0;
        /// add all the intervals ending before newInterval starts
        while (i < in.length && in[i][1] < newIn[0]) {
            list.add(in[i++]);
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < in.length && in[i][0] <= newIn[1]) {
            // do the update here. e.g [5,7], newIn [0,0]
            newIn[0] = Math.min(newIn[0], in[i][0]);
            newIn[1] = Math.max(newIn[1], in[i][1]);
            i++;
        }

        list.add(newIn);
        while (i < in.length) {
            list.add(in[i++]);
        }
        return list.toArray(new int[list.size()][2]);


    }

    //don't use new structure to return.
    public List<Interval> insert(List<Interval> list, Interval newIn) {
        int n = list.size();
        int i = 0;
        /// add all the intervals ending before newInterval starts
        while (i < n && list.get(i).end < newIn.start) {
            i++;
        }
        int begin = i;
        // merge all overlapping intervals to one considering newInterval
        while (i < n && newIn.end >= list.get(i).start) {
            newIn.start = Math.min(newIn.start, list.get(i).start);
            newIn.end = Math.max(newIn.end, list.get(i).end);
            i++;
        }

        int end = i - 1;
        for (int x = end; x >= begin; x--) {
            list.remove(x);
        }
        // add the union of intervals we got
        list.add(begin, newIn);
        return list;

    }
}
