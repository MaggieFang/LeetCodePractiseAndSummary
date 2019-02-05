package com.mock;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/29/19
 * Talk is Cheap,Show me the Code.
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * intuit o  a
 **/
public class GenerationRelation {
    static boolean shareAncestor(String[] idPair, String[][] dataset) {
        if (idPair == null || idPair.length != 2) return false;

        // map child to its direct parents. for easy access later
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] data : dataset) {
            List<String> parent = map.getOrDefault(data[1], new ArrayList<>());
            parent.add(data[0]);
            map.put(data[1], parent);
        }

        // if either id to query has no direct parents. they cannot share ancestor
        if (map.get(idPair[0]) == null || map.get(idPair[1]) == null) return false;

        Queue<String> q = new LinkedList<>();  //for doing bfs to find undirect-parents.
        HashSet<String> visitedParent = new HashSet<>();//mark visited parents of id[0]

        q.addAll(map.get(idPair[0]));
        visitedParent.addAll(map.get(idPair[0])); //mark directed parents visited.

        while (!q.isEmpty()) {
            List<String> directParent = map.get(q.poll());
            if (directParent != null) {
                q.addAll(directParent);
                visitedParent.addAll(directParent);
            }
        }

        /** do bfs for id[1] to find parents and check parent whether have been visited. if yes,have found shared parent and return true **/
        q.addAll(map.get(idPair[1]));
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (visitedParent.contains(cur)) return true;
            List<String> directParent = map.get(cur);
            if (directParent != null) {
                q.addAll(directParent);
            }
        }

        return false;
    }

    public static void main(String[] args) {
    }
}
