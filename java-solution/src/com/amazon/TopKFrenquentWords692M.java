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
     *  use PriorityQueue. override the compare method, use count first and use string.compareTo()
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *   TopKFrequentElements347M
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(NlogN), where N is the length of words. We count the frequency of each word in O(N)time,
     * then we add N words to the heap, each in O(logM) time.
     * Finally, we pop from the heap up to k times.
     * <p>
     * SPACE COMPLEXITY: O(N)
     * <p>
     **/
    public List<String> topKFrequentQ(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap();
        for(String w : words){
            Integer count = map.getOrDefault(w,0);
            map.put(w,count+1);
        }

        PriorityQueue<String> q = new PriorityQueue<>((String o1, String o2) -> {
            int c1 = map.get(o1);
            int c2 = map.get(o2);
            int dif = c2 - c1;
            if(dif !=0) return dif;
            return o1.compareTo(o2);
        });
        for(Map.Entry<String,Integer> entry: map.entrySet()){ // get the element from the map here. don't need from words[]
            q.add(entry.getKey());
        }
        List<String> res = new ArrayList<>();
        while(!q.isEmpty() && k-- > 0){
            res.add(q.poll());
        }
        return res;
    }

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


}



