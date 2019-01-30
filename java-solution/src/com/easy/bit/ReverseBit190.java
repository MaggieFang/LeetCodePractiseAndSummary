package com.easy.bit;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/25/18
 * Talk is Cheap,Show me the Code.
 **/
public class ReverseBit190 {

    public int reverseBit(int n){
        if(n == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++){
            if((n & 1) == 1){
                result++;
            }
            n = n >> 1;
            if(i < 31){
                result = result << 1;
            }
        }
        return result;
    }

}
