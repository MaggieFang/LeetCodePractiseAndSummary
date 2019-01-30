package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class RotateImage48M {
    /**
     * KEYPOINTS:
     * <p>
     *
     * The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
     * 1  2  3
     * 4  5  6
     * 7  8  9
     * after transpose, it will be swap(matrix[i][j], matrix[j][i])
     * 1  4  7
     * 2  5  8
     * 3  6  9
     * Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
     * <p>
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
    public static void rotate(int[][] M) {
        if (M == null || M.length == 0) {
            return;
        }

        int n = M.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) { // the j will larger than i cause A[2,1] has been change when A[1,2]
                int t = M[j][i];
                M[j][i] = M[i][j];
                M[i][j] = t;
            }
        }

        for (int s = 0; s <= n; s++) { //次数
            int i = 0; //first Item in a row
            int j = n; // last item in a row
            while (i < j) {
                int t = M[s][i];
                M[s][i] = M[s][j];
                M[s][j] = t;
                i++;
                j--;
            }

        }
    }

    /**
     * n = length()-1;
     * 即便我们知道结果是 A[i][j]跟 A[j][n-i] swap,如 4X4的，A[0,2] 跟A[2,3]换了，
     * 但下面A[1，0]又会跟A[0,2]换(这个时候A[0,2]已经变过了，他是要跟他原来的，也就是现在的A[2,3]换)
     *
     */

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(A);
    }

}
