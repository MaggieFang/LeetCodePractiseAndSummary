package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/31/18
 * Talk is Cheap,Show me the Code.
 **/
public class MostStonesRemovedwithSameRoworColumn947M {

    /**
     * Clarification:
     * Disjoint Set (Or Union-Find)
     * https://blog.csdn.net/fuxuemingzhu/article/details/84500642
     * 这个题翻译一下就是，横或者纵坐标相等的坐标点会互相链接构成一个区域，问总的有多少个独立的区域。
     * 结果是总的石头数减去独立区域数。
     * 所以，只需要统计有多少区域即可。这个方法最简单的就是并查集。
     * </p>
     * Keypoints:
     * if stones has same x axis or y, it means they are connected. so this problem can be solved by
     * how many connected areas? the result we want is total number of stones - number of connected areas.
     * Union-Find
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int removeStones(int[][] stones) {
        int[] root = new int[stones.length];
        int n = stones.length;
        for(int i = 0; i < n; i++){
            root[i] = i;
        }
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    join(i, j, root);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(root[i] == i) cnt++;
        }
        return n - cnt;
    }

    private int find(int i, int[] root) {
        int r = i;
        while (root[r] != r){
            r = root[r];
        }
        return r;
    }

    private void join(int x, int y, int[] root) {
        int rx = find(x, root);
        int ry = find(y, root);
        if (rx != ry) {
            root[rx] = ry;
        }
    }

//    public int removeStones(int[][] stones) {
//        int[] root = new int[stones.length];
//        int n = stones.length;
//        Arrays.fill(root, -1);
//        for (int i = 0; i < stones.length; i++) {
//            for (int j = i + 1; j < stones.length; j++) {
//                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
//                    join(i, j, root);
//                }
//            }
//        }
//        int cnt = 0;
//        for (int r : root) {
//            if (r == -1) cnt++;
//        }
//        return n - cnt;
//    }
//
//    private int find(int i, int[] root) {
//        if (root[i] == -1) return i;
//        return find(root[i], root);
//    }
//
//    private void join(int x, int y, int[] root) {
//        int rx = find(x, root);
//        int ry = find(y, root);
//        if (rx != ry) {
//            root[rx] = ry;
//        }
//    }

//    public int removeStones(int[][] stones) {
//        int[] root = new int[stones.length];
//        int n = stones.length;
//        Arrays.fill(root,-1);
//        for(int i = 0; i < stones.length;i++){
//            int x = findRoot(i,root);
//            for(int j = i+1; j < stones.length; j++){
//                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
//                    int y = findRoot(j,root);
//                    if(x!= y) root[y] = x;
//                }
//            }
//        }
//        for(int r: root){
//            if(r == -1)
//                n--;
//        }
//        return n;
//    }
//
//    public int findRoot(int i,int [] root){
//        if(root[i] == -1) return i;
//        return findRoot(root[i],root);
//    }


//
//    /**This is to return the longest one turn dfs, but not the problem want***/
//    int max = 0;
//    int count;
//    public int removeStonesWrong(int[][] stones) {
//        HashMap<Integer, ArrayList<Integer>> graph = buildGraph(stones);
//        for (Integer key : graph.keySet()) {
//            dfs(graph, key, new HashSet<Integer>());
//        }
//        return max;
//
//    }
//
//    public void dfs(HashMap<Integer, ArrayList<Integer>> graph, int key, HashSet<Integer> visited) {
//        visited.add(key);
//        count++;
//        List<Integer> adj = graph.get(key);
//        for (Integer neibor : adj) {
//            if (!visited.contains(neibor)) {
//                dfs(graph, neibor, visited);
//            }
//        }
//        visited.remove(key);
//        max = Math.max(count - 1, max);
//        count--;
//    }
//
//
//    public HashMap<Integer, ArrayList<Integer>> buildGraph(int[][] stones) {
//        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
//
//        for (int i = 0; i < stones.length; i++) {
//            ArrayList<Integer> list = graph.getOrDefault(i, new ArrayList<Integer>());
//            for (int k = 0; k < stones.length; k++) {
//                if (k == i) continue;
//                if (stones[k][0] == stones[i][0] || stones[k][1] == stones[i][1]) {
//                    list.add(k);
//                }
//            }
//            graph.put(i, list);
//        }
//        return graph;
//    }
}

