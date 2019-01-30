package com.facebook;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class RangeSumQuery304M {

    private int[][] matrix;

    public RangeSumQuery304M(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int r1, int c1, int r2, int c2) {
        if (matrix == null || matrix.length < r1 || matrix[0].length < c1) {
            return 0;
        }

        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
