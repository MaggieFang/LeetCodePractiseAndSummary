package com.doordash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-02
 * Talk is Cheap,Show me the Code.
 **/
public class SortRange {
    // sorted by the value of the number or by frequecy? in decreasing order or increasing? Which one do you like to optimize in terms of complexity
    public int[] sortArrange(int[] A, int range) {
        int[] count = new int[range+1];
        for (int i : A) {
            count[i]++;
        }

        for (int i = 1; i <= range; i++) {// 别忘了=的情况，count[range+1]的
            count[i] = count[i] + count[i - 1];
        }

        int[] ans = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            ans[count[A[i]]-1] = A[i];
            count[A[i]]--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {3,1,1,200,39,3,199,100,22,200};
        int n = 200;
        SortRange t = new SortRange();
        int[] r = t.sortArrange(A, n);
        for(int i:r){
            System.out.print(i+",");
        }
    }

}
