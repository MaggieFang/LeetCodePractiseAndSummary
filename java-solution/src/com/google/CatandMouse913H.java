package com.google;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-30
 **/
public class CatandMouse913H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * a graph traversal problems, but there are two objects. there a n nodes here, no mater for cat or mouse,when they finished their traversal(n nodes)
     * if there is no one reach its goal. then 0. so at most 2n steps we can get results.
     * for each state. there are three factors here, current step（to decide whose turn）, the node mouse in , the node cat in. so we can use a 3-d dp for this
     * dp[step][x][y], store the result(0,1,2) for the the current step, mouse in node x, cat in node y.
     * what we want is dp[0][1][2].
     * we init dp[step][x][y] with -1.
     * we can know dp[i][0][j] will be 1, dp[i][x][x] will be 2, and when step == 2n, it will be 0.
     * if it is -1,we need to compute. since each turn, every one want to get the optimal result. so when we try the next step.
     * if for mouse turn,if the next try return 1, we can just return, otherwise,we need to try some other result. we prefer 1 >  0 > 2
     * for cat turn, we prefer 2 > 0 > 1
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    int n = 0;

    public int catMouseGame(int[][] graph) {
        n = graph.length;
        int[][][] dp = new int[2 * n][n][n];
        for (int i = 0; i < dp.length; i++) { //init with -1
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(dp, graph, 1, 2, 0);

    }

    private int helper(int[][][] dp, int[][] graph, int x, int y, int step) {
        if (step == (n << 1)) return 0; // finished 2n steps runs
        if (dp[step][x][y] != -1) return dp[step][x][y]; // have computed.
        if (x == y) { //cat win
            dp[step][x][y] = 2;
            return 2;
        } else if (x == 0) { // mourse win
            dp[step][x][y] = 1;
            return 1;
        }

        boolean mouse = (step % 2 == 0);
        HashSet<Integer> result = new HashSet<>();
        if (mouse) {
            for (int i = 0; i < graph[x].length; i++) {
                int next = helper(dp, graph, graph[x][i], y, step + 1); // try next step to seek optimal result
                if (next == 1) {
                    dp[step][x][y] = 1; // don't forget set value
                    return 1;
                }
                result.add(next);
            }

        } else {
            for (int i = 0; i < graph[y].length; i++) {
                if (graph[y][i] == 0) continue;
                int next = helper(dp, graph, x, graph[y][i], step + 1);
                if (next == 2) {
                    dp[step][x][y] = 2;
                    return 2;
                }
                result.add(next);
            }
        }
        
        if (result.contains(0)) {
            dp[step][x][y] = 0;
            return 0;
        }
        dp[step][x][y] = mouse ? 2 : 1;
        return dp[step][x][y];
    }
}
