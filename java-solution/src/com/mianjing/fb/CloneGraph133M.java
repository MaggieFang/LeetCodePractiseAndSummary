package com.mianjing.fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class CloneGraph133M {

    //BFS
    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }


    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return  null;
        }

//        Set<UndirectedGraphNode> visited = new HashSet<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map  = new HashMap<>();
        UndirectedGraphNode head  = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        map.put(node,head);
//        visited.add(node);
        while (!q.isEmpty()){
            UndirectedGraphNode n = q.poll();
            for(int i= 0; i < n.neighbors.size();i++){
                UndirectedGraphNode neibor = n.neighbors.get(i);
                if(!map.containsKey(neibor)){
                    UndirectedGraphNode newNeibor = new UndirectedGraphNode(neibor.label);
                    map.put(neibor,newNeibor);
                    q.add(neibor);
                }
                map.get(n).neighbors.add(map.get(neibor));
            }
        }
        return head;


    }


}
