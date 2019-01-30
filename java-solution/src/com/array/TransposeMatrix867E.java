package com.array;

public class TransposeMatrix867E {
      /** KEYPOINTS:
           * <p>
           *  we just copy it vertically. That is ans[j][i] = A[i][j]
           * </p>
           * PSEUDOCODE:
           * <pre>
           *  <code>
           * </code>
           * </pre>
           * TIME COMPLEXITY:
           * <p>
           * SPACE COMPLEXITY:
           * <p>
         **/
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int[][] B = new int[n][m];
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                B[j][i] = A[i][j];
            }
        }
        return B;

    }
}
