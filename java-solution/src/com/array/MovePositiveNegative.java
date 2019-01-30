package com.array;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/24/18
 * Talk is Cheap,Show me the Code.
 **/
//fb code interview
    // an array contains numbers positive and negative, please put the negative left side. and positive right side.
    /**
     * KEYPOINTS:
     * <p>
     *     We can learn idea from quicksort, to pick the 0 as pivot. so in the patitation. we can achieve it.
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
public class MovePositiveNegative {
    public static void main(String[] args){
        int[] A = {-1,-2,6,-4,-6,-3,-3,-8};
        move(A);
        for (int i:A
             ) {
            System.out.print(i+"\t");

        }
    }
    public static void move(int[] A){
        if(A == null || A.length == 0){
            return;
        }
        int pivot = 0;
        int pos = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] < pivot){
                int tmp = A[pos];
                A[pos++] = A[i];
                A[i] = tmp;
            }
        }
        // the pos is the zero location;
    }

}
