package com.easy.math;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class FactorialZeros172 {
    /**
     * KEYPOINTS:
     * <p>
     * all trailing 0 is from factors 5 * 2.so we need to find how many 5*5,In the n! operation, factors 2 is always ample.
     * So we just count how many 5 factors in all number from 1 to n.
     * but notice that sometimes one number has more than one 5.e.g 25,50,125...
     * So first we add n/5.
     * Wait, we are missing 5X5, 2X5X5..., so we add n/25.
     * Wait, we are missing 5X5X5, 2X5X5X5..., so we add n/125.
     * Thus, count = n/5 + n/25 + n/125 + ... + 0
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
    public int zeros(int n) {
        if(n < 5){
            return 0;
        }
        int count = 0;
        while(n > 0){
            count += n/5;
            n /= 5;
        }

        return count;
    }
}
