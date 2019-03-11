package com.google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class MovingAveragefromDataStream346E {
    class MovingAverage {

        /**
         * Initialize your data structure here.
         */
        private Queue<Integer> queue;
        private int maxSize;
        private double sum;

        public MovingAverage(int size) {
            maxSize = size;
            this.queue = new LinkedList<>();
            sum = 0.0;
        }

        public double next(int val) {
            if (queue.size() == maxSize) {
                sum -= queue.remove();
            }
            sum += val;
            queue.add(val);
            return sum / queue.size();

        }
    }
}
