package com.easy.twopointer;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class ReverseSgtring344 {
    public String reverseString(String s) {
        if(s == null || s == ""){
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for(int i = s.length() -1; i >=0;i--){
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public String reversStringDirect(String s){
        if(s == null || s == ""){
            return s;
        }
        return new StringBuilder(s).reverse().toString();
    }
}
