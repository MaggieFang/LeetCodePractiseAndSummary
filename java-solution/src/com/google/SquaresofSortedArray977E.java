package com.google;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-01
 * Talk is Cheap,Show me the Code.
 **/
public class SquaresofSortedArray977E {

    //We can use two pointers to read the positive and negative parts of the array
    // one pointer i in the positive direction,i++, and another j in the negative direction.j-- .
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int i = 0;
        while (i < n && A[i] < 0) {
            i++;
        }
        int j = i - 1;
        int[] ans = new int[n];
        int id = 0;
        while (i < n && j >= 0) {
            if (Math.abs(A[i]) < Math.abs(A[j])) {
                ans[id++] = A[i] * A[i];
                i++;
            } else {
                ans[id++] = A[j] * A[j];
                j--;
            }
        }
        while (i < n) {
            ans[id++] = A[i] * A[i];
            i++;
        }

        while (j >= 0) {
            ans[id++] = A[j] * A[j];
            j--;
        }
        return ans;
    }
}
