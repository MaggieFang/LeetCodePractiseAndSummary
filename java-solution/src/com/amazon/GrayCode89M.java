package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class GrayCode89M {
    /**
     * KEYPOINTS:
     * <p>
     * A easy solution, no bit operation:
     *  n = 0 as (0)
     *  n = 1 as (0 ,1)
        n = 2 as (00, 01, 11, 10), how you can get the answer for n = 3?
     * (1) you need all the answer in n = 2, copy them (000, 001, 011, 010);
     * (2) add pow(2,2) = 4 to all the answer in n = 2.BUT! start from the last one, that is (110, 111, 101, 100)!!!
     *  Since n,the result size is 2^n, and we use the n - 1 result size 2^(n-1),
     *  so there are 2^(n-1) results we need to find. How?
     *  we just increase a bit in the highest and set it  0(such that is the result when  n -1).
     *  so now the left 2^(n-1) results are the highest bit is 1.  so just add pow(2, n-1) to the the elements of when n -1
     *  but how. now the current element is the lastest element when (n-1)
     *  so we need to start from it.
     * <p>
     * <p>
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
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }

        List<Integer> pre = grayCode(n - 1);
        List<Integer> cur = new ArrayList<>(pre);

        int add = (int) (Math.pow(2, n - 1));
        for (int i = pre.size() - 1; i >= 0; i--) {
            cur.add(pre.get(i) + add);
        }
        return cur;
    }
}
