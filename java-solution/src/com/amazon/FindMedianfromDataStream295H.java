package com.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-07
 **/
public class FindMedianfromDataStream295H {
    static class MedianFinder {

        /**
         * initialize your data structure here.
         */
        TreeMap<Integer, Integer> map;
        int total;
        public MedianFinder() {
            map = new TreeMap<>();
        }

        public void addNum(int num) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
            total++;
        }

        public double findMedian() {
            int index = -1;
            int pri = 0;
            int begin = (total - 1) >> 1;// target count
            int end = total >> 1;
            boolean done = false;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                index += entry.getValue();
                if (index >= begin && !done) {
                    pri = entry.getKey();
                    done = true;
                }
                if (index >= end) {
                    return (pri + entry.getKey()) / 2.0;
                }
            }
            return 0;
        }
    }
}
