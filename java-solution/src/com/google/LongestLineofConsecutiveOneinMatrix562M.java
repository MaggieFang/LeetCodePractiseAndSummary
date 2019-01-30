package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class LongestLineofConsecutiveOneinMatrix562M {
    /**
     * KEYPOINTS:
     * <p>
     *  memo[i][j] means when come to pos(i,j),the area from (0,0) to (i,j),the max of four direction
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public int longestLineDP(int[][] M) {
        if(M.length == 0 || M[0].length == 0){
            return 0;
        }
        int n = M.length;
        int m = M[0].length;
        int max = 0;
        int[][][] memo = new int[n][m][4];// k = 0,1,2,3 horizon, vertical,diagonal,anti-dial
        for(int i = 0; i < n;i++){
            for(int j = 0; j < m; j++){
                if(M[i][j] ==0 ){
                    continue;
                }

                for(int k = 0; k < 4;k++){
                    memo[i][j][k]= 1;
                }

                if(j > 0){
                    memo[i][j][0] += memo[i][j-1][0];
                }

                if(i > 0){
                    memo[i][j][1] += memo[i-1][j][1];
                }

                if(i >0 && j > 0){
                    memo[i][j][2] += memo[i-1][j-1][2];
                }

                if(i > 0 && j < m-1){
                    memo[i][j][3] += memo[i-1][j+1][3];
                }
                max = Math.max(max,memo[i][j][0]);
                max = Math.max(max,memo[i][j][1]);
                max = Math.max(max,memo[i][j][2]);
                max = Math.max(max,memo[i][j][3]);

            }
        }

        return max;
    }
    /**http://www.cnblogs.com/grandyang/p/6900866.html
     * 对于一个mxn的矩阵，对角线和逆对角线的排数都是m+n-1个，难点在于我们要确定每一排上的数字的坐标，如果i是从0到m+n-1之间遍历，
     * j是在i到0之间遍历，那么对角线的数字的坐标就为(i-j, j)，逆对角线的坐标就为(m-1-i+j, j)，
     * 这是博主千辛万苦试出来的T.T，如果能直接记住，效果肯定棒
     * **/
    public int longestLine(int[][] M) {
        if(M.length == 0 || M[0].length == 0){
            return 0;
        }
        int n = M.length;
        int m = M[0].length;
        int max = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < m; j++){
                if(M[i][j] == 1){
                    count++;
                    max = Math.max(max,count);
                }else{
                    count = 0;
                }
            }
        }
        for(int j = 0; j < m; j++){
            int count = 0;
            for(int i = 0; i < n; i++){
                if(M[i][j] == 1){
                    count++;
                    max = Math.max(max,count);
                }else{
                    count = 0;
                }
            }
        }

        for(int i = 0; i < m+n-1;i++){
            int cnt1= 0,cnt2 = 0;
            for(int j = i; j >= 0; j--){
                if(i - j >= 0 &&i - j< n && j < m){
                    if(M[i-j][j] == 1){
                        cnt1++;
                        max = Math.max(max,cnt1);
                    }else{
                        cnt1 = 0;
                    }
                }
                int t = m-1-i+j;
                if(t >= 0 && t < n & j < m ){
                    if(M[t][j] == 1){
                        cnt2++;
                        max = Math.max(max,cnt2);
                    }else{
                        cnt2 = 0;
                    }
                }
            }
        }
        return max;
    }

}
