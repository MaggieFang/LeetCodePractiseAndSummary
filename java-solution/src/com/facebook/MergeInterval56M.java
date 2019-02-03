package com.facebook;

import com.basicStructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class MergeInterval56M {
    /**
     * KEYPOINTS:
     * <p>
     * we find some example for us to understand
     * [[1,3],[2,6],[8,10],[15,18]],we will find the min of startTime and find all elements
     * which startTime >= endtime of the min.(How to find at most? sort with start Time)
     * and we will construct the item with min start Time and the max end Time of the elements selected.
     * However, when we start combining the first two we found, the end we can update with the max.
     * e.g [[1,7],[2,8],[8,15]] when we find [2,8] that can be merge into [1,7] to become [1,8],
     * so the next start time we compare is the existing max endtime 8
     * so we can sort the array of the start time
     * <p>
     * e.g.  start  1 2 5 8  15
     * end    7 8 6 10  20
     * find the min start Time, and point to the end time 7
     * and travels from start +1 to find all the startTime <= ndTime.
     * Meanwhile, we update endTime keep it largest. e.g when [2,8] the end will be 8 for the next comparator.
     * so we can put [1,7] [2,8] [5,6][8,10] together [1,8]
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n) if we donnot consider the sort.
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
     **/
    public List<Interval> merge(List<Interval> in) {
        List<Interval> result = new ArrayList<>();
        if (in == null || in.size() == 0) {
            return result;
        }
        Collections.sort(in, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        result.add(in.get(0));
        Interval maxEnd = in.get(0);

        for(int i = 1; i < in.size();i++){
            Interval item = in.get(i);
            if(item.start < maxEnd.end){
                   maxEnd.end = Math.max(maxEnd.end,item.end);
            }else {
                result.add(item);
                maxEnd = item;
            }
        }
        return  result;
//        while (start < in.size()) {
//            Interval pivot = in.get(start);
//            int maxEndtime = pivot.end;
//
//            Interval item = new Interval(pivot.start, maxEndtime);
//            /* we first and the result here and just update the endTime at last
//            * instead of in the for loop find the last one satisfy because we can cover the situation that
//            * only last Interval left because  i  = start + 1 will not go into the for loop*/
//            result.add(item);
//            int i = start + 1;
//            for (; i < in.size(); i++) {
//                Interval cur = in.get(i);
//                if (cur.start <= maxEndtime) {
//                    maxEndtime = Math.max(maxEndtime, cur.end);
//                    continue;
//                } else {
//                    break;
//                }
//            }
//            start = i;
//            item.end = maxEndtime;
//        }
//        return result;

    }



}
