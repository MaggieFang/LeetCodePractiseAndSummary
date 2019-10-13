package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-03
 * Talk is Cheap,Show me the Code.
 **/
public class SpiralMatrix54M {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int sm = 0, sn = 0; // first row and column index unused
        int m = matrix.length - 1; // last row index unused
        int n = matrix[0].length - 1; //last column index unsed
        List<Integer> ans = new ArrayList<>();
        while (sm <= m && sn <= n) {
            // row: left to right;
            if (sm <= m) { // if there are rows left to print
                int i = sn;
                while (i <= n) {
                    ans.add(matrix[sm][i++]);
                }
                sm++;
            }

            //column: top-down
            if (sn <= n) {
                int i = sm;
                while (i <= m) {
                    ans.add(matrix[i++][n]);
                }
                n--;
            }

            //row: right to left;
            if (sm <= m) {// if there are rows left to print
                int i = n;
                while (i >= sn) {
                    ans.add(matrix[m][i--]);
                }
                m--;
            }

            //column: down - top
            if (sn <= n) {
                int i = m;
                while (i >= sm) {
                    ans.add(matrix[i--][sn]);
                }
                sn++;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix54M s = new SpiralMatrix54M();
        s.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });
    }
}
