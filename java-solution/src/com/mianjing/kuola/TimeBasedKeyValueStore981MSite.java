package com.mianjing.kuola;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-20
 * Talk is cheap,show me the Code.
 **/
public class TimeBasedKeyValueStore981MSite {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * TreeMap, floorKey
     * </p>
     * TIME COMPLEXITY:O(1) for each set operation, and O(logN) for each get operation, where N is the number of entries in the TimeMap.
     * SPACE COMPLEXITY:O(N)
     * </p>
     **/

    class TimeMap {
        HashMap<String, TreeMap<Integer, String>> map;
        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int time) {
            TreeMap<Integer, String> v = map.getOrDefault(key, new TreeMap<>());
            v.put(time, value);
            map.put(key, v);
        }

        public String get(String key, int time) {
            if (!map.containsKey(key)) return "";
            TreeMap<Integer, String> v = map.get(key);
            Integer k = v.floorKey(time);
            return k == null ? "" : v.get(k);
        }
    }
}
