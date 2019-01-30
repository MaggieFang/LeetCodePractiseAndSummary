package com.array;

public class CanPlaceFlowers605E {
    /**
     * KEYPOINTS:
     * <p>
     * We can find out the extra maximum number of flowers, that can be planted for the given array,
     *  so traversal the array, when meet a number 0, we check its (left or i= 0) and (right or i = lenght-1)
     *  is 0 , then add 1 , and set the A[i] =1 indicate it is used.
     *
     *  Besides, we can optimize to return true and break the loop when count >= n( needn't to check again).
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
    public boolean canPlaceFlowers(int[] bed, int n) {
        int i = 0;
        int count = 0;
        while (i < bed.length) {
            if (bed[i] == 0 && (i == 0 || bed[i - 1] == 0) && (i == bed.length - 1 || bed[i + 1] == 0)) {
                count++;
                bed[i] = 1;
            }
           /*  a improvement
             if(count >= n){
                return true;
            }*/

            i++;
        }
        return count >= n;
    }
}
