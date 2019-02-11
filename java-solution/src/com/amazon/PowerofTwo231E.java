package com.amazon;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-11
 * Talk is cheap,show me the Code.
 **/
public class PowerofTwo231E {
    //O(log_b(N)) here b = 2
    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        while(n % 2 == 0){
            n >>= 1;
        }
        return n == 1;
    }
}
