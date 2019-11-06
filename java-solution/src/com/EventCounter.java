package com;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-06
 **/
public class EventCounter {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * Actually, I don't need to care about the count in 1 sec!!! so don't use the queue for count!!!
     * just push the timestamp into queue when the evertOccur called.
     * for getCount, look from the beginning. remove the elements that out of the range of in the last n secs.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    private long intervalMillis ;
    private Queue<Long> queue;

    public EventCounter(int n) {
        this.queue = new LinkedList<>();
        this.intervalMillis = n*1000;
    }

    public void eventOccur() {
        long cur = System.currentTimeMillis();
        queue.add(cur);
    }

    public int getEventCount() {
        long cur = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            if ((cur - queue.peek())  > intervalMillis) {
                queue.poll();
            }
        }
        return queue.size();
    }
}
