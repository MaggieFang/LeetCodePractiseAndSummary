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
     *     Group the points by x coordinates, so that we have columns of points.
     *     Then, for every pair of points in a column (with coordinates (x,y1) and (x,y2)),
     *     check for the smallest rectangle with this pair of points as the rightmost edge.
     *     We can do this by keeping memory of what pairs of points we've seen before.
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
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();// treeMap
        for(int[] p : ps){
            List<Integer> list = map.getOrDefault(p[0],new ArrayList<Integer>());
            list.add(p[1]);
            map.put(p[0],list);
        }

        int ans = Integer.MAX_VALUE;
        Map<Integer,Integer> seen = new HashMap<>();
        for(int x : map.keySet()){
            List<Integer> ys = map.get(x);
            Collections.sort(ys); //!! if not （3,(3,4））， （4,(4,3)）就被认为不一样了，y1,y2相互颠倒
            for(int i = 0; i < ys.size(); i++){
                for(int j = i+1; j < ys.size();j++){
                    int y1 = ys.get(i);
                    int y2 = ys.get(j);
                    int code = 40001*y1+y2; // trick, how to how two array with same element!!
                    if(seen.containsKey(code)){
                        ans = Math.min((x- seen.get(code))*(y2-y1),ans);
                    }
                    seen.put(code,x);
                }
            }
        }
        return ans < Integer.MAX_VALUE? ans:0;
    }

}
