package com;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-06
 **/
public class EventCounter {
    private int n;
    private Queue<Long> queue;

    public EventCounter(int n) {
        this.queue = new LinkedList<>();
        this.n = n;
    }

    public void eventOccur() {
        long cur = System.currentTimeMillis();
        queue.add(cur);
    }

    public int getEventCount() {
        long cur = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            if ((cur - queue.peek()) / 1000 > n) {
                queue.poll();
            }
        }
        return queue.size();
    }
}
