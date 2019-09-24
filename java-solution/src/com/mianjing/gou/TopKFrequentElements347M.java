package com.mianjing.gou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/9/19
 * Talk is Cheap,Show me the Code.
 **/
public class TopKFrequentElements347M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  similar method in LC692
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((Integer o1, Integer o2) -> map.get(o1) - map.get(o2));
        for (Integer key : map.keySet()) {
            q.add(key);
            if (q.size() > k) {
                q.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            list.add(q.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
