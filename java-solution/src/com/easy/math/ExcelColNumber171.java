package com.easy.math;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class ExcelColNumber171 {
    public int titleToNumber(String s) {
        if(s == null || s == ""){
            return 0;
        }

        int result= 0;
        for(int i =0; i < s.length();i++){
            result+= Math.pow(26,s.length()-1-i)*(s.charAt(i)-'A'+1);
        }
        return result;

    }
}
