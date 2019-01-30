package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 8/31/18
 * Talk is Cheap,Show me the Code.
 **/
public class HasMapTest {
    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 1);
        map.put("Bad", 2);
        map.put("Cat", 3);
        map.put("Dog", 4);
        map.put("Egg", 5);
        map.put("Fox", 6);
        map.put("Go", 7);
        map.put("Hat", 8);
        map.put(null,null);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
