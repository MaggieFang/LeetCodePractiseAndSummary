package com.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-13
 **/
public class ShortestWordDistanceII244M {
    class WordDistance {
        Map<String,List<Integer>> map;
        public WordDistance(String[] words) {
            this.map = new HashMap<>();
            for(int i = 0; i <words.length; i++){
                List<Integer> list = map.getOrDefault(words[i],new ArrayList<>());
                list.add(i);
                map.put(words[i],list);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < l1.size(); i++){
                for(int j = 0; j < l2.size(); j++){
                    ans = Math.min(Math.abs(l1.get(i) - l2.get(j)),ans);
                }
            }
            return ans;
        }
    }
}
