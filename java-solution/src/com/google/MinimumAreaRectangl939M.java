package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinimumAreaRectangl939M {
    /**
     * KEYPOINTS:
     * <p>
     * Group the points by x coordinates, so that we have columns of points.
     * then for every column, we find the combination of ys in this column and marked have seen it.
     * (how to simply indicate we seen (y1,y2), y1*constant+y2)
     * then when we traversal the x, we try each combination of its ys, and if ys have been seen before, it means
     * they can form a rectangle. we can compute the rect area is (x2-x1)*(distance of the y pairs seen). so in the seen information,
     * we not only need y1,y2 , but also its x axis
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int minAreaRect(int[][] ps) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();// treeMap
        for (int[] p : ps) {
            map.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
//            List<Integer> list = map.getOrDefault(p[0],new ArrayList<Integer>());
//            list.add(p[1]);
//            map.put(p[0],list);
        }

        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int x : map.keySet()) {
            List<Integer> ys = map.get(x);
            Collections.sort(ys); //!! if not,（x,(y1,y2) =（3,(3,4））跟4,(4,3)）就被认为不一样了，y1,y2相互颠倒了
            for (int i = 0; i < ys.size(); i++) {
                for (int j = i + 1; j < ys.size(); j++) {
                    int y1 = ys.get(i);
                    int y2 = ys.get(j);
                    int code = 40001 * y1 + y2; // trick!!
                    if (seen.containsKey(code)) {
                        ans = Math.min((x - seen.get(code)) * (y2 - y1), ans);
                    }
                    seen.put(code, x);
                }
            }
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }

}
