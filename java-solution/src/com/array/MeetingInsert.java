package com.array;

import com.basicStructure.Interval;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-05
 * Talk is cheap,show me the Code.
 **/
public class MeetingInsert {
    /**
     * KEYPOINTS:
     *  how to check two intervals overlap or not? e.g Interval A,B
     * i0 = max(a0, b0); // lower bound of intersection interval
     * i1 = min(a1, b1); // upper bound of intersection interval
     * return i0 <= i1;  // interval non-empty?
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public boolean canInsert(Interval[] intervals, Interval cur) {
        for (Interval in : intervals) {
            int start = Math.max(cur.start, in.start);
            int end = Math.min(cur.end, in.end);
            if (start <= end) return false;
        }
        return true;
    }
}
