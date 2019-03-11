package com.mianjing.fb;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class AddRemoveRandom380 {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * if I use a set, it seem get and remove can meet O(1)
     * but in random. since I cannot say a index to get a element from the set.unless set toArray().
     *
     * if I use a map and the value store the index.But when I remove one of them. I need to re compute their value.so I cannot achieve O(1)
     *
     * maybe use a map + arrayList. map is the val -> index. the arrayList is the actual number.
     * when remove. if it is not the last index.e.g index i, we and set the vaule of list[i] with list[list.size()-1] and remove the last element of it.
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
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
