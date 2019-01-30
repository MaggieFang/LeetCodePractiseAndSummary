package com.amazon;

import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class SetMatrixZero73M {
    /**
     * KEYPOINTS:
     * <p>
     *     If any cell of the matrix has a zero we can record its row and column number.
     *     All the cells of this recorded row and column can be marked zero in the next iteration
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(M*N)
     * <p>
     * SPACE COMPLEXITY: O(m+n)
     * <p>
    **/
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for(int i = 0; i < m; i ++){
            for(int j=0; j  < n;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int i : row){
            for(int k = 0; k < n; k++){
                matrix[i][k] =0;
            }
        }
        for(int i: col){
            for(int k = 0; k < m;k++){
                matrix[k][i] = 0;
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean doneM[] = new boolean[m];// indicate the row i it has been done 0.for improvement
        boolean doneN[] = new boolean[n];// indicate the column j has been done 0.for improvement
        boolean[][] original = new boolean[m][n]; // indicate M[i][j] 0 is change by others or original 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    original[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = matrix[i][j];
                if (a == 0 && original[i][j]) {
                    if (!doneM[i]) {
                        for (int k = 0; k < n; k++) {
                            matrix[i][k] = 0;
                        }
                        doneM[i] = true;
                    }
                    if (!doneN[j]) {
                        for (int k = 0; k < m; k++) {
                            matrix[k][j] = 0;
                        }
                        doneN[j] = true;
                    }
                }

            }
        }
    }
}
