package com.array;

public class ToeplitzMatri766E {
    /***
     for each diagonal elements a1,a2... ak, if a1= a2, a2 = a3= a4...= ak then we can return true
     how to find them? we can select a1 when row = 0 ||  col == 0
     and if A[i-1][j-1] == A[i][j]

     **/
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
