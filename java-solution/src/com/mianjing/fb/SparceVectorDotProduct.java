package com.mianjing.fb;


import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class SparceVectorDotProduct {
    /**
     * KEYPOINTS:
     * <p>
     *  the key for this problem is not to compute the sum. but to design the data structure for sparce Vector storage.
     *  We can use two HashMap, the key is the index of non-zero item. the value is the item value
     *  But List of pair is more efficient.
     * I think two-dimentional array is also good. A[][2].
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
//    List<Pair<Integer, Integer>> list = new ArrayList<>();
//
//    public int dotProduct(int[] A, int[] B) {
//        if (A == null || B == null || A.length != B.length || A.length == 0 || B.length == 0) {
//            return 0;
//        }
//        int sum = 0;
//
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] != 0 && B[i] != 0) {
//                Pair<Integer, Integer> pair = new Pair<>(A[i], B[i]);
//                list.add(pair);
//                sum+=A[i]*B[i];
//            }
//        }
//
//        return sum;
//    }
//    public int dotProduct(int[] A,int[] B){
//        if (A == null || B == null || A.length != B.length || A.length == 0 || B.length == 0) {
//            return 0;
//        }
//        List<int[]> list = new ArrayList<>();
//        Integer[] item = new int[2];
//
//
//
//    }
}
