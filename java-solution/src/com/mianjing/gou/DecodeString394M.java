package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
public class DecodeString394M {
    /**
     * KEYPOINTS:
     * <p>
     * every time when you meet a number,indicate num, it must be followed by [...],
     * we just need to recursively call our method to decode "..." and gets sub result,
     * then repeat the sub result "num" times.
     * so we beging from i = 0, there are some characters here, 1)'[' must  after number, so what we met first must be letter or number.
     * if it is letter, we append to the result, if it is number, we loop the read the number, then after the number, it must be a '[',
     * we skip it and call recur. and the end  condition is we go to the end of the string or meet ']'
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    private int i = 0;
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return "";
        return decode(s).toString();
    }
    private StringBuilder decode(String s){
        StringBuilder ans = new StringBuilder();
        int n = s.length();
        char c;
        while(i < n &&  (c = s.charAt(i++)) != ']'){ // end condition
            if(Character.isDigit(c)){ // meet digital
                int num = c - '0';
                while(Character.isDigit(c = s.charAt(i))){
                    num = num *10 + c - '0';
                    i++;
                }
                ++i;//after digital, it must be a '['
                StringBuilder sub = decode(s); //
                while(num--> 0){
                    ans.append(sub);
                }

            }else{ // meet direct letter
                ans.append(c);
            }
        }
        return ans;
    }

}
