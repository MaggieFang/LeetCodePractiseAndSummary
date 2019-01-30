package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/3/18
 * Talk is Cheap,Show me the Code.
 **/
public class StringToInteger8M {
    /**
     * KEYPOINTS:
     * <p>
     *     while loop to the first none ' ',
     *     judge the fist none ' ' whether '+' or '-'
     *     while  s.charAt(i) >='0' && s.charAt(i) <='9'
     *       in the while, judge whether out of range.
     *       if(base >  Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && c > 7)){ //判断
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
    public static int myAtoi(String s) {
        if(s == null ||s.length() == 0){
            return 0;
        }

        int n = s.length();
        int i = 0;
        int sign = 1, base = 0;
        while(i < n && s.charAt(i) == ' '){ i++; }

        if(i < n && (s.charAt(i) == '-' || s.charAt(i) == '+' )){
            if(s.charAt(i) == '-'){
                sign = -1;
            }else{
                sign = 1;
            }
            i++;
        }


        while(i < n && s.charAt(i) >='0' && s.charAt(i) <='9'){
            int c = s.charAt(i) - '0';
            if(base >  Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && c > 7)){ //判断超MAX的方式
                if(sign == 1){
                    return Integer.MAX_VALUE;
                }else{
                    return Integer.MIN_VALUE;
                }
            }else{
                base = base*10 + c;
                i++;
            }
        }
        return sign*base;



    }

    public static void main(String[]a){
        myAtoi("2147483648");
    }
}
