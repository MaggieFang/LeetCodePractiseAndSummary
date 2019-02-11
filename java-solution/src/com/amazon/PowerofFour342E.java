package com.amazon;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-11
 * Talk is cheap,show me the Code.
 **/
public class PowerofFour342E {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 4 == 0) {
            num >>= 2;
        }
        return num == 1;
    }
}
