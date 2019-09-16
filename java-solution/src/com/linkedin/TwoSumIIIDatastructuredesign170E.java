package com.linkedin;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-13
 **/
public class TwoSumIIIDatastructuredesign170E {
    class TwoSum {
        Map<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            this.map = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            Integer count = map.get(number);
            if (count == null) {
                map.put(number, 1);
            } else {
                map.put(number, count + 1);
            }

        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                int dif = value - k;
                if (dif == k && v > 1) {
                    return true;
                } else if (map.containsKey(dif)) {
                    return true;
                }
            }
            return false;
        }
    }

}
