package com.wish;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-24
 **/
public class LongestMountaininArray845M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *  Without loss of generality, a mountain can only start after the previous one ends.
     *  so For a starting index base, let's calculate the length of the longest mountain A[base], A[base+1], ..., A[end].
     * If such a mountain existed, the next possible mountain will start at base = end;
     * if it didn't, then either we reached the end, or we have A[base] > A[base+1] and we can start at base + 1.
     * </p>
     * TIME COMPLEXITY: O(N)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public int longestMountain(int[] A) {
        int N = A.length;
        int ans = 0;
        int base = 0;
        while (base < N) {
            int end = base;
            // if base is a left-boundary
            if (end + 1 < N && A[end] < A[end + 1]) {
                while (end + 1 < N && A[end] < A[end + 1]) {
                    end++;
                }
                // if end is really a peak
                if (end + 1 < N && A[end] > A[end + 1]) {
                    // set end to the righ-boundary of mountain
                    while (end + 1 < N && A[end] > A[end + 1]) {
                        end++;
                    }
                    //candidate
                    ans = Math.max(ans, end - base + 1);
                }

            }
            base = Math.max(base + 1, end); // maybe end not move in the outer iteration,so just ++base in this case;

        }
        return ans;
    }
}
