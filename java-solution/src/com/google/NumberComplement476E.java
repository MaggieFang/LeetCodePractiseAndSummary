package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-30
 **/
public class NumberComplement476E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * XOR: i ^ 1 will flip the value of i, i.e 1 will be 0 and 0 will be 1
     * power 2^n : can use 1 << n
     * </p>
     * TIME COMPLEXITY: 
     * SPACE COMPLEXITY:
     * </p>
     **/
    public int findComplement(int num) {
        int r = 0;
        int cnt = 0;
        while (num != 0) {
            r += ((num % 2) ^ 1) * (1 << cnt);
            cnt++;
            num = num >> 1;
        }
        return r;
    }
}
