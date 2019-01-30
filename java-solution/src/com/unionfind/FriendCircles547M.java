package com.unionfind;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/1/19
 * Talk is Cheap,Show me the Code.
 **/
public class FriendCircles547M {
    /**
     * KEYPOINTS:
     * <p>
     * find the number of connected components in an undirected graph,
     * To undergo DFS, we pick up a node and visit all its directly connected nodes.
     * But, as soon as we visit any of those nodes, we recursively apply the same process to them as well.
     * Thus, we try to go as deeper into the levels of the graph as possible starting from a current node first,
     * leaving the other direct neighbour nodes to be visited later on.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n^2)
     * <p>
     * SPACE COMPLEXITY: O(n)
     * <p>
     **/
    public int findCircleNumDFS(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int n = M.length;
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                ans++;
                dfs(M, i, visited);
            }
        }
        return ans;
    }

    public void dfs(int[][] M, int i, HashSet<Integer> visited) {
        if (i < 0 || i >= M.length) {
            return;
        }
        visited.add(i);
        for (int j = 0; j < M.length; j++) { //!! start with 0,not i+1, [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
            if (M[i][j] == 1 && !visited.contains(j)) {
                dfs(M, j, visited);
            }
        }
    }

    /**
     * KEYPOINTS:
     * <p>
     * union all people that are friends. when we see a pair,we try to put it in a union.
     * we can use a root[] to put indicate which group their are in. if it is single one, root[i] = -1;
     * For every new pair of nodes found, we look for the parents of both the nodes.
     * If the parents nodes are the same, it indicates that they have already been united into the same group.
     * If the parent nodes differ, it means they are yet to be united.
     * Thus, for the pair of nodes parent x,y,we assign root[y] = x,forming the union,
     * which ultimately combines them into the same group.
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:: O(n^3)We traverse over the complete matrix once.
     * Union and find operations take O(n) time in the worst case.
     * <p>
     * SPACE COMPLEXITY:O(n)
     * <p>
     **/
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int n = M.length;
        int[] root = new int[n];
        Arrays.fill(root, -1);

        for (int i = 0; i < n; i++) {
            int x = findRoot(root, i);
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    int y = findRoot(root, j);
                    if (x != y) root[y] = x;
                }
            }
        }
        for (int i : root) {
            if (i == -1) {
                ans++;
            }
        }
        return ans;
    }

    public int findRoot(int[] root, int i) {
        if (root[i] == -1) return i;
        return findRoot(root, root[i]);
    }
}
