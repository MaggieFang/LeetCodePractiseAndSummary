package com.mianjing.google;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-06
 * Talk is cheap,show me the Code.
 **/
public class DeleteDuplicateChar {
    // 把一个单词里有可能打出重复的letter删掉看dictionary里有没有match的 ex. whaaaaat -> what
    /*** what if abbbcac? is it abcac **/
    public String deleteDuplicate(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i == n -1 || s.charAt(i) != s.charAt(i+1)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        DeleteDuplicateChar d = new DeleteDuplicateChar();
        System.out.println(d.deleteDuplicate("aaa"));
        System.out.println(d.deleteDuplicate("a"));
        System.out.println(d.deleteDuplicate("aabbb"));
        System.out.println(d.deleteDuplicate("abbbb"));
        System.out.println(d.deleteDuplicate("abbbbccacc"));
    }
}
