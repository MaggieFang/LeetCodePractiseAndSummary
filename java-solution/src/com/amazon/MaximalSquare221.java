package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/7/18
 * Talk is Cheap,Show me the Code.
 **/
public class MaximalSquare221 {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;

        int[][] sum =new int[m+1][n+1];
        for(int i = 1; i< m+1; i++){
            for(int j = 1; j < n+1; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }

        int ans = 0;
        for(int i = 1; i < m+1;i++){
            for(int j = 1; j < n+1; j++){
                for(int size = Math.min(m + 1 -i,n + 1 -i); size > 0; size--){
                    int tmp = sum[i +size -1][j + size -1] - sum[i-1][j + size -1 ] - sum[i + size -1][j-1] + sum[i-1][j-1];
                    if(tmp == size*size){
                        ans = Math.max(ans,tmp);
                        break;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] ra){
        char[][] A = new char[][]{
                {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}
        };
        maximalSquare(A);
    }
}
