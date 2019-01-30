package com.mianjing.fb;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class AddRemoveRandom380 {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;

    java.util.Random rand = new java.util.Random();

    public AddRemoveRandom380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }


    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int i = map.get(val);
        if (i < list.size() - 1) { // not the last one
            int last = list.get(list.size() - 1);
            list.set(i, last);
            map.put(last, i);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;


    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

        return list.get(rand.nextInt(list.size()));


    }

}
