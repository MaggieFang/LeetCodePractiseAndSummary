package com.facebook;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/11/18
 * Talk is Cheap,Show me the Code.
 **/
public class LRUCache146HLinkedMap {
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
        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        map.put(key,value);


    }

}
