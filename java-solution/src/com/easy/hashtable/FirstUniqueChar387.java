package com.easy.hashtable;

import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class FirstUniqueChar387 {
    public static void main(String[] args) {
        firstUniqChar("loveleetcode");
    }

    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
