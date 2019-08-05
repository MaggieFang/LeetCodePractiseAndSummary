package com.fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-05
 **/
public class AddtoArrayFormofInteger989E {
    /**
     * Clarification:
     * can K be 0? (actually can unify, no extra consideration)
     * can A[0] be 0?  No
     * can number be negative? No
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:O(max(N,logK)) where N is the length of A
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length - 1;
        int carry = 0;
        int sum = 0;
        List<Integer> r = new ArrayList<>();
        while (K > 0) {
            sum = carry + K % 10;
            if (i >= 0) {
                sum += A[i--];
            }
            K = K / 10;
            carry = sum / 10;
            r.add(sum % 10);
        }
        while (i >= 0) { // actually, this can be put in  the last while(K > 0 || i >= 0)
            sum = carry + A[i--]; // Don't forget carry here.
            carry = sum / 10;
            r.add(sum % 10);
        }

        if (carry > 0) { // Don't forget carry here. e.g.[2,1,5],806
            r.add(carry);
        }
        Collections.reverse(r);
        return r;

    }
}
