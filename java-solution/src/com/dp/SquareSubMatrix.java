package com.dp;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/5/19
 * Talk is Cheap,Show me the Code.
 **/
public class SquareSubMatrix {
    /**
     * KEYPOINTS:
     *
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    /**
     * KEYPOINTS:
     * <p>
     * </p>
     * TIME COMPLEXITY: O(n*m)
     * <p>
     * SPACE COMPLEXITY: O(n*m)
     * <p>
     **/
    public int squareSubBottomUp(boolean[][] arr) {
        int max = 0;
        int[][] cache = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = arr[i][j] ? 1 : 0;
                } else if (arr[i][j]) {
                    cache[i][j] = Math.min(Math.min(cache[i][j - 1], cache[i - 1][j]), cache[i - 1][j - 1]) + 1;
                }
                max = Math.max(max, cache[i][j]);
            }

        }
        return max;
    }


    public int squareSubTopDown(boolean[][] arr) {
        int max = 0;
        int[][] cache = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]) {
                    max = Math.max(max, squareSubTopDown(arr, i, j, cache));
                }
            }
        }
        return max;
    }

    private int squareSubTopDown(boolean[][] arr, int i, int j, int[][] cache) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[i].length || !arr[i][j]) {
            return 0;
        }
        if (cache[i][j] > 0) return cache[i][j];
        cache[i][j] = 1 + Math.min(Math.min(squareSubTopDown(arr, i, j + 1, cache),
                squareSubTopDown(arr, i + 1, j, cache)), squareSubTopDown(arr, i + 1, j + 1, cache));
        return cache[i][j];

    }

    /**
     * KEYPOINTS:
     * <p>
     * at each turn, we make 3 recursive calls. so,we branch by 3 each time and get a runtime 3*3*3= 3^x
     * x is the depth of our recursion. since in each turn,we either go down or left in our matrix.
     * we can find the max depth of our recursion is n+m for n*m matrix,
     * so runtime O(n*m*3^(n+m))
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int squareSub(boolean[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]) {
                    max = Math.max(max, squareSub(arr, i, j));
                }
            }
        }
        return max;
    }

    private int squareSub(boolean[][] arr, int i, int j) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[i].length || !arr[i][j]) {
            return 0;
        }
        return 1 + Math.min(Math.min(squareSub(arr, i, j + 1), squareSub(arr, i + 1, j)), squareSub(arr, i + 1, j + 1));
    }

}
