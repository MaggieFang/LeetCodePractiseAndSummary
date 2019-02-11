package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/11/19
 * Talk is Cheap,Show me the Code.
 **/
public class PrintMatrixSpiral {
    private void spiralPrint(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int startRow = 0;
        int startCol = 0;
        while (startCol < n && startRow < m) {
            //print the first row
            for (int i = startCol; i < n; i++) {
                System.out.println(A[startRow][i]);
            }
            startRow++;
            //print the last col
            for (int i = startRow; i < m; i++) {
                System.out.println(A[i][n - 1]);
            }
            n--;

            //print the last row
            if (startRow < m) {
                for (int i = n - 1; i >= startCol; i--) {
                    System.out.println(A[m - 1][i]);
                }
                m--;
            }

            //print the first col
            if (startCol < n) {
                for (int i = m - 1; i >= startRow; i--) {
                    System.out.println(A[i][startCol]);
                }
                startCol++;
            }
        }
    }

    public static void main(String[] args) {

        int mat[][] =
                {
                        {1,  2,  3,  4,  5},
                        {6,  7,  8,  9,  10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20}
                };
        new PrintMatrixSpiral().spiralPrint(mat);
    }
}
