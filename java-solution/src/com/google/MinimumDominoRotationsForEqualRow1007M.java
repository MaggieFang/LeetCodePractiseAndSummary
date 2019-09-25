package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-24
 **/
public class MinimumDominoRotationsForEqualRow1007M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  if there are solution, no matter how we convert position, it must be A[0] or B[0],
     *  so we suppose it is A[0] as the target, so A[i] or B[i] should be same as A[0]. And
     *  if A[i] != A[0], we increase the rotateA, i.e rotateA++;
     *  if B[i] != A[0] we increase rotateB,i.e rotateB++;
     *  when finishing travelling, if A[0] works, no need to check B[0], just return Min(rotateA,rotateB);
     *  this is because if both A[0] and B[0] exists in all dominoes. let's say it is A[0]=2 and B[0]= 5,
     *  so elements in all index i is 2 and 5, when we travel the A[0], we has record the position of the position
     *  convert between 2 with 5. now when for target 5, we will record the position convert with 2,
     *  so the result will be the same
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        for (int a = 0, b = 0, i = 0; i < n && (A[i] == A[0] || B[i] == A[0]); i++) {
            if (A[i] != A[0]) a++;
            if (B[i] != A[0]) b++;
            if (i == n - 1) return Math.min(a, b);
        }

        for (int a = 0, b = 0, i = 0; i < n && (A[i] == B[0] || B[i] == B[0]); i++) {
            if (B[i] != B[0]) b++;
            if (A[i] != B[0]) a++;
            if (i == n - 1) return Math.min(a, b);
        }
        return -1;

    }
}

