package com.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class TopKFrenquentWords692M {
    /**
     * KEYPOINTS:
     * <p>
     * count the frequcies.
     * init arrayList with all keySet for candicate.
     * use Collection.sort and define the comparator. Sort by frequency. if same. sort by string natural order.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(Nlog{N}), where N is the length of words. We count the frequency of each word in O(N) time,
     * then we sort the given words in O(NlogN) time.
     * <p>
     * SPACE COMPLEXITY:O(N)
     * <p>
     **/
    public List<String> topKFrequent(String[] words, int k) {
        final HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();

        for (String s : words) {
            int v = map.getOrDefault(s, 0) + 1;
            map.put(s, v);
        }

        ArrayList<String> candidates = new ArrayList<>(map.keySet());
        Collections.sort(candidates, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int v1 = map.get(o1);
                int v2 = map.get(o2);
                return v2 - v1 != 0 ? v2 - v1 : o1.compareTo(o2); // good. Sort by frequency. if same. sort by string natural order.
            }
        });
        return candidates.subList(0, k);
    }

    /**
     * KEYPOINTS:
     * <p>
     *  use PriorityQueue instead of the above the compare. But we need to build the min(oppsite above.)
     *  because we need to delete the min one  when q size > k,
     *  so the ans finally should be reverse.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(Nlogk), where N is the length of words. We count the frequency of each word in O(N)time,
     * then we add N words to the heap, each in O(logk) time.
     * Finally, we pop from the heap up to k times.
     * <p>
     * SPACE COMPLEXITY: O(N)
     * <p>
    **/
    public List<String> topKFrequent2(String[] words, int k) {
        final HashMap<String,Integer> map = new HashMap<>();


        for(String s: words){
            int v = map.getOrDefault(s,0)+1;
            map.put(s,v);
        }

        PriorityQueue<String> q = new PriorityQueue<>(new Comparator<String>(){ // build the minheap, because we need to delete the min one when size > k
            @Override
            public int compare(String s1,String s2){
                int v1 = map.get(s1);
                int v2 = map.get(s2);
                return v1 - v2 != 0 ? v1 -v2:s2.compareTo(s1);
            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            q.add(entry.getKey());
            if(q.size() > k){
                q.poll();
            }
        }
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}


