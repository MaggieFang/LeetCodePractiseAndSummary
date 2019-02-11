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
    public List<Integer> topKFrequent(int[] nums, int k) {
        final HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for(Integer key : map.keySet()){
            q.add(key);
            if(q.size() > k) {
                q.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()){
            ans.add(q.poll());
        }
        Collections.reverse(ans);
        return ans;

    }
}
