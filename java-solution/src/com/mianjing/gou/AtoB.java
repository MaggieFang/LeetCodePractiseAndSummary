package com.mianjing.gou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/11/19
 * Talk is Cheap,Show me the Code.
 **/
public class AtoB {
    /**
     * KEYPOINTS:
     * <p>
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public boolean canChange(char[] A, char[] B) {
        if (A.length != B.length) {
            return false;
        }
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = map.getOrDefault(A[i], new ArrayList<Integer>());
            list.add(i);
            map.put(A[i], list);
        }

        for (int i = 0; i < B.length; i++) {
            char target = B[i];
            char ori = A[i];
            if (target == ori) {
                List<Integer> idxs = map.get(ori);
                for (Integer o : idxs) { // e.g A aba, B abd,we need't replace at 0th,but when to 2,it require A change a to d
                    if (B[o] != A[o]) {
                        return false;
                    }
                }
            } else {
                List<Integer> idxs = map.get(ori);
                for (Integer o : idxs) { // e.g A aba,B dbc,when replace A[0] to d,but when to 2nd. B will require c
                    if (B[o] != target) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
