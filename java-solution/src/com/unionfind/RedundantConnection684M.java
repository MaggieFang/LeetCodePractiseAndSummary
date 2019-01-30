package com.unionfind;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/1/19
 * Talk is Cheap,Show me the Code.
 **/

public class RedundantConnection684M {
    /**
     * KEYPOINTS:
     * <p>
     * connected components of a graph,when a pair connected, we union it into a group,
     * when new pair found.we try to find their group,if they already in the same group,it is the redundant edge
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] root = new int[n + 1];
        int[] ans = new int[2];
        Arrays.fill(root, -1);
        for (int i = 0; i < n; i++) {
            int x = findRoot(root, edges[i][0]);
            int y = findRoot(root, edges[i][1]);
            if (x != y) {
                root[y] = x;
            } else {
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
            }
        }
        return ans;
    }

    public int findRoot(int[] root, int i) {
        if (root[i] == -1) return i;
        return findRoot(root, root[i]);  // {{1,5},{3,4},{3,5},{4,5},{2,4}}
    }

    public static void main(String[] args) {
        int[][] a = {{1,5},{3,4},{3,5},{4,5},{2,4}};
        RedundantConnection684M test = new RedundantConnection684M();
        test.findRedundantConnection(a);

    }
}
