package com.doordash;


import com.basicStructure.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-03
 * Talk is Cheap,Show me the Code.
 **/
public class IntervalListIntersections986M {
    /**
     * KEYPOINTS:
     * 两个闭区间[a,b]和[m,n]如果存在交集，则它们的交集为[max(a,m),min(b,n)],但每次可能只一个,留下那个end比较大的，
     * so use two pointer to determine A or B
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int l = Math.max(A[i].start, B[j].start);
            int h = Math.min(A[i].end, B[j].end);
            if (l <= h) {
                ans.add(new Interval(l, h));
            }
            if (A[i].end < B[j].end) {
                i++;
            } else if (A[i].end > B[j].end) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return ans.toArray(new Interval[ans.size()]);
    }

}
