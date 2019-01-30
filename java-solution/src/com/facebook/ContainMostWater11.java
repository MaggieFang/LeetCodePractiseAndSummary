package com.facebook;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/2/18
 * Talk is Cheap,Show me the Code.
 **/
public class ContainMostWater11 {
    /**
     * KEYPOINTS:
     * <p>
     *    We make T(i) means that end in i;
     *    so T(i) = Max{(i - j)*min{A[i],A[j]}}, j from 0 to i-1;
     *    T(1) = 0
     *    T(2) = 1 * min{A[0],A[1]}
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
    public int maxArea(int[] A) {
        if(A == null || A.length <=1){
            return 0;
        }

        int max = 0;
        for(int i = 0; i< A.length; i++){
            int cur = 0;
            for(int j = 0; j < i; j++){
                cur = Math.max(cur,(i-j)*Math.min(A[i],A[j]));

            }
            max = Math.max(max,cur);
        }
        return max;
    }


}
