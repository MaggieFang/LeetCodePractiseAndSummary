package com.string;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-02
 **/
public class ToLowerCase709E {
    public String toLowerCase(String str) {

        char[] a = str.toCharArray();
        for(int i = 0; i < a.length;i++){
            char c = a[i];
            if(c >= 'A' && c <= 'Z'){
                a[i] += 32;
            }
        }
        return new String(a); // 不能用toString，他会返回地址

    }
}
