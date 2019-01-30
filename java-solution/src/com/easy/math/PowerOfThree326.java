package com.easy.math;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class PowerOfThree326 {
    // a great trick here.@NKeys from leetCode.
    public boolean isPowerOfThreeTrick(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }

    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        while(n % 3 == 0){
            n/=3;
        }
        return n == 1;

    }
}
