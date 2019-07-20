package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-20
 **/
public class ValidMountainArray941E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * the array keep going up to peak and then down.
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        int i = 0;
        while (i < A.length && i + 1 < A.length && A[i] < A[i + 1]) {
            i++;
        }
        if (i + 1 >= A.length || i == 0) return false;

        while (i < A.length && i + 1 < A.length && A[i] > A[i + 1]) {
            i++;
        }

        if (i + 1 >= A.length) return true;
        return false;
    }
}
