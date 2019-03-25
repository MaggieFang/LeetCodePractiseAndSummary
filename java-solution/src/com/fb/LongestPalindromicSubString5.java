package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class LongestPalindromicSubString5 {
    public String longestPalindrome(String str) {
        //T[][]: boolean, T[i][j] check [i...j] is palindrome or not
        //basecase T[i][i] = true;
        //T[i][j]= T[i+1][j-1] && A[i] == A[j]
        int n = str.length();
        boolean[][] T = new boolean[n][n];
        for(int i =0;i < n;i++){
            T[i][i] = true;
        }

        int max = 1;
        int start = 0;
        for(int len = 2; len <= n;len++){
            for(int s = 0; s <= n -len; s++){
                int e = s +len -1;
                if(str.charAt(s) == str.charAt(e) && (( s+1 == e) || T[s+1][e -1])){
                    T[s][e] = true;
                    if(len > max){
                        max = len;
                        start = s;
                    }
                }
            }
        }
        return str.substring(start,max+start);

    }


    public static void main(String[] args){
        LongestPalindromicSubString5 test = new LongestPalindromicSubString5();
        System.out.println(test.longestPalindrome("abcba"));
    }
}
