package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-19
 **/
public class CampusBikesII1066M {
    /**
     * Clarification:
     * 这个题跟1057不同，如 b0 到 w0, w1居然分别是1，2，b1 到w0,w1 是2,8,如果按照1057，(b0,w0)+(b1,w1)= 9,但更好的是(b0,w1)+(b1,w0)=4
     *
     * This one ask for the min total distance. use dfs. we can store the curDist for early stop( pruning)
     * Try to assign every bike, to all the workers and find the min.
     * Take every path possible to find the shortest combined distance for all pairs of bikes and workers
     * 也就是对每个worker，试试吧bike[i]分给他，并吧bike[i]标志为已经被signed，继续下个worker，不断dfs
     *
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY: O(n*m!)the solution runs a for-loop (numBikes) at each recursion layer of DFS. Since each recursion will take one
     * bike then drip down to the next recursion layer, leading to the next recursion layer having less-one bike available to choose from.
     * With that said, the first recursion has numBikes branches, the next recursion has numBikes - 1 branches.... thus,
     * so it would be m * (m-1) * .. 1. and we compute the n workers. so it is (n*m!)
     * SPACE COMPLEXITY:
     * </p>
     **/
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        dfs(workers, bikes, 0, 0, new boolean[m]);
        return min;
    }

    private void dfs(int[][] workers, int[][] bikes, int i, int curDis, boolean[] visited) {
        if (i >= workers.length) {
            min = Math.min(min, curDis);
            return;
        }
        if (curDis > min) return;  // early stop

        for (int j = 0; j < bikes.length; j++) {
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            dfs(workers, bikes, i + 1, curDis + dist(workers[i], bikes[j]), visited);
            visited[j] = false;
        }
    }

    private int dist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
