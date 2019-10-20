package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class LicenseKeyFormatting482E {
    /**
     5F3Z-2e9-wh, k =2
     Can it start with '-', Yes, "--a-b-a"
     it also can be "-----"
     **/
    public String licenseKeyFormatting(String S, int K) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = S.length() -1; i >= 0; i--){
            char c = Character.toUpperCase(S.charAt(i));
            if(c != '-'){
                if(sb.length() % (K+1) == K){//!!! insert "-" before insert new character.
                    sb.insert(0,'-');
                }
                // take care, it is not else here.
                sb.insert(0,  c);
            }
        }
        return sb.toString();
    }
}
