package com.string;

import com.fb.ReverseWordsinaString151M;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-28
 * Talk is cheap,show me the Code.
 **/
public class ReverseWordsinStringIII55E {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = 0;
        int n = s.length();
        while(j < n){
            while(j < n && array[j] != ' ') j++;
            reverse(array,i, j-1);
            ++j;
            i = j;
        }
        return new String(array);


    }
    public void reverse(char[] A,int i,int j){
        while( i < j){
            char tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
    }
    public static void main(String[] args){
        ReverseWordsinStringIII55E t = new ReverseWordsinStringIII55E() ;
        t.reverseWords("Let's take LeetCode contest");
    }
}
