package com.amazon;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/11/18
 * Talk is Cheap,Show me the Code.
 **/
public class LRUCache146HLinkedMap {
    /**
     * Clarification:
     * At first, I think HashMap + Queue are easy for this problem, but don't forget when get(key) calls, this "key" element became newer.
     * I need to get it to the end of the queue. so cannot meet the O(1) requirement. so need a double linked for O(1) update when get.
     * seen in LRUCache146H
     * In fact, LinkedHashMap using hash table + double linkedList
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCache146HLinkedMap(final int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);

    }

}
