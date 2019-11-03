package com.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-07
 **/
public class FindMedianfromDataStream295H {
    /**
     * Clarification:
     * Two PriorityQueue,
     * </p>
     * Keypoints:
     * use two priorityQueue, one store the left part of elements. another one store the right part of elements.
     * and when odd number, median get the top from left, if even number, median is the average of the left top and right top
     * so make the left queue as a max priority,the right queue as a min priority.
     * each addNum, we add the number into the left part.and poll the top to right queue since the right queue need to store the large number.
     * after that,we need to balance the size of the left and right keeping left.size() - right.size() == 0 or 1.
     * so if left.size() < right.size(), we poll the right and add it to left.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    class MedianFinder2 {

        /**
         * initialize your data structure here.
         */
        PriorityQueue<Integer> left;// max heap
        PriorityQueue<Integer> right; // min heap

        public MedianFinder2() {
            right = new PriorityQueue<>();
            left = new PriorityQueue<>((o1, o2) -> o2 - o1);

        }

        public void addNum(int num) {
            left.add(num);
            right.add(left.poll());
            if (left.size() < right.size()) {
                left.add(right.poll());
            }

        }

        public double findMedian() {
            return left.size() > right.size() ? left.peek() : (left.peek() + right.peek()) / 2.0;
        }
    }


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
