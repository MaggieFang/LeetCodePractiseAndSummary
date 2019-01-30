package com.easy.bit;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/25/18
 * Talk is Cheap,Show me the Code.
 **/
public class SumTwoInt371 {
    public static void main(String[] args){
        int a = 5;
        int b = 7;
        System.out.println(sum(a,b));
    }

    /**
     * KEYPOINTS:
     * <p>
     *     How do we check if only one bit is 1? Use ^.
     *     How do we check if both bits are 1? Use &.
     *     this two below explain well.
     *     https://leetcode.com/problems/sum-of-two-integers/discuss/167931/Solution-with-ACTUAL-explanation-(how-you-would-work-this-out)
     *     https://stackoverflow.com/questions/9070937/adding-two-numbers-without-operator-clarification/9071437#9071437?newreg=7d4e79dcfbf74bdda80352adff210fe7
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
    public static int sum(int a,int b){
        if(a == 0) {
            return b;
        }

        if(b == 0) {
            return a;
        }

        String s;

        int carry = 0;

        while(b != 0) {

            // If both bits are 1, we set the bit to the left (<<1) to 1 -- this is the carry step
            carry = (a & b) << 1;

            // If both bits are 1, this will give us 0 (we will have a carry from the step above)
            // If only 1 bit is 1, this will give us 1 (there is nothing to carry)
            a = a ^ b;

            b = carry;
        }

        return a;

    }
}
