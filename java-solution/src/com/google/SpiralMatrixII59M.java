package com.google;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-03
 * Talk is Cheap,Show me the Code.
 **/
public class SpiralMatrixII59M {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int sr = 0, sc = 0, er = n - 1, ec = n - 1;
        int num = 1;
        while (sr <= er && sc <= ec) {
            //start row : l to r
            if (sr <= er) {
                int i = sc;
                while (i <= ec) {
                    ans[sr][i++] = num++;
                }
                sr++;
            }

            // end colum:top-down
            if (sc <= ec) {
                int i = sr;
                while (i <= er) {
                    ans[i++][ec] = num++;
                }
                ec--;
            }
            // end row: right to left
            if (sr <= er) {
                int i = ec;
                while (i >= sc) {
                    ans[er][i--] = num++;
                }
                er--;
            }
            // start column : down-top
            if (sc <= ec) {
                int i = er;
                while (i >= sr) {
                    ans[i--][sc] = num++;
                }
                sc++;
            }
        }
        return ans;

    }
}
