package com.google;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-14
 **/
public class ValidPerfectSquare367E {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int end = num/2;
        for(int i = 2; i <= end; i++){
            if(i*i == num) return true;
        }
        return false;
    }
}
