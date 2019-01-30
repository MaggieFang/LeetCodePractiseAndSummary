package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class RomanToInt13 {
    /**
     * KEYPOINTS:
     * <p>
     *  we can traverse the string from from 0 to length-1,
     *  when the cur char vaule is greater than the pre one, it should divides.
     *  otherwise to add.
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
    public int romanToInt(String s) {
        if(s == null){
            return 0;
        }
        int lastV = 0;
        int result = 0;
        for(int i = s.length()-1;i>= 0;i--){
            int tmp = getValue(s.charAt(i));
            if(lastV > tmp){
                result-=tmp;
            }else{
                result+=tmp;

            }
            lastV = tmp;
        }
        return result;

    }

    public int getValue(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 1;
        }
    }
}
