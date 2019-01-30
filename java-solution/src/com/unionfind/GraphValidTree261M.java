package com.unionfind;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/1/19
 * Talk is Cheap,Show me the Code.
 **/
public class GraphValidTree261M {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length < n - 1) { // e.g n = 5,{{0,1},{1,2}}
            return false; // if connected,n nodes needs at least n-1 edges
        }
        int[] root = new int[n];
        Arrays.fill(root, -1);
        for (int[] edge : edges) {
            int x = findRoot(edge[0], root);
            int y = findRoot(edge[1], root);
            if (x == y) {
                return false;
            } else {
                root[y] = x;
            }
        }
        return true;
    }

    public int findRoot(int i, int[] root) {
        if (root[i] == -1) return i;
        return findRoot(root[i], root);
    }

}
