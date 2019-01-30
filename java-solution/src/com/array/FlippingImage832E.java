package com.array;

public class FlippingImage832E {
      /** KEYPOINTS:
           * <p>
           *  for each one-dimensional array, when we swap them, we do the invert ops at the same time.
           *   how to change 1 to 0 and 0 to 1, just XOR 1
           * </p>
           * PSEUDOCODE:
           * <pre>
           *  <code>
           * </code>
           * </pre>
           * TIME COMPLEXITY:
           * <p>
           * SPACE COMPLEXITY:
           * <p>
         **/
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int low = 0;
            int hi = A[i].length - 1;
            while (low <= hi) {
                int tmp = A[i][hi];
                A[i][hi] = A[i][low] ^ 1;
                A[i][low] = tmp ^ 1;
                low++;
                hi--;
            }
        }
        return A;
    }

}
