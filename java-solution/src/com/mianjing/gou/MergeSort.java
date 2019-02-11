package com.mianjing.gou;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javafx.util.Pair;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/14/19
 * Talk is Cheap,Show me the Code.
 **/
public class MergeSort {
    //https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=470853&extra=&page=1
    public List<Map.Entry<String,Integer>> merger(List<Pair<String, Integer>> l1, List<Pair<String, Integer>> l2) {
        final HashMap<String, Integer> map = new HashMap<>();
        for (Pair<String, Integer> pair : l1) {
            String k = pair.getKey();
            int v = pair.getValue();
            map.put(k, map.getOrDefault(k, 0) + v);
        }

        for (Pair<String, Integer> pair : l2) {
            String k = pair.getKey();
            int v = pair.getValue();
            map.put(k, map.getOrDefault(k, 0) + v);
        }
        List<Map.Entry<String,Integer>> ans = new LinkedList<>(map.entrySet());

        Collections.sort(ans, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i = o1.getValue().compareTo(o2.getValue());
                if(i != 0) return i;
                return  o1.getKey().compareTo(o2.getKey());
            }
        });
        

        return ans;
    }

    public List<Pair<String, Integer>> mergerByCharacter(List<Pair<String, Integer>> l1, List<Pair<String, Integer>> l2) {
        if (l1 == null || l1.size() == 0) return l2;
        if (l2 == null || l2.size() == 0) return l1;

        TreeMap<String, Integer> map = new TreeMap<>();
        for (Pair<String, Integer> pair : l1) {
            String k = pair.getKey();
            int v = pair.getValue();
            map.put(k, map.getOrDefault(k, 0) + v);
        }

        for (Pair<String, Integer> pair : l2) {
            String k = pair.getKey();
            int v = pair.getValue();
            map.put(k, map.getOrDefault(k, 0) + v);
        }

        List<Pair<String, Integer>> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(new Pair<String, Integer>(entry.getKey(), entry.getValue()));
        }
        return ans;
    }

    public static void main(String[] args) {
        //，List 1 :  ["ab", 3], ["cd", 2],["fg", 4]   List 2: ["ab", 2], ["fg", 3]
        MergeSort t = new MergeSort();
        List<Pair<String, Integer>> l1 = new ArrayList<>();
        l1.add(new Pair<String, Integer>("af", 3));
        l1.add(new Pair<String, Integer>("ad", 5));
        l1.add(new Pair<String, Integer>("fg", 4));

        List<Pair<String, Integer>> l2 = new ArrayList<>();
        l2.add(new Pair<String, Integer>("af", 2));
        l2.add(new Pair<String, Integer>("fg", 3));


        System.out.println(t.merger(l1, l2));
    }
}
