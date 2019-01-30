package com.unionfind;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/1/19
 * Talk is Cheap,Show me the Code.
 **/
public class NumberofConnectedComponentinUndirectedGraph323M {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        Arrays.fill(root, -1);

        for (int i = 0; i < edges.length; i++) {
            int x = findRoot(edges[i][0], root);
            int y = findRoot(edges[i][1], root);
            if (x != y) {
                root[y] = x;
            }
        }
        int ans = 0;
        for (int r : root) {
            if (r == -1) {
                ans++;
            }
        }
        return ans;
    }

    public int findRoot(int i, int[] root) {
        if (root[i] == -1) return i;
        return findRoot(root[i], root);
    }
}
