package com.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class IsSubsequence392M {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int m = s.length();
        int n = t.length();
        while (i < m && j < n) {
            while (i < m && j < n && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            i++;
            j++;
        }
        return i == m && j <= n;

    }

    /**
     * KEYPOINTS:
     * <p> for followup, If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see
     * if T has its subsequence. In this scenario, how would you change your code?
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public boolean isSubsequenceFollowUp(String s, String t) {
        HashMap<Character,List<Integer>> map = new HashMap<>();
        for(int i =0; i < t.length();i++){
            List<Integer> list = map.getOrDefault(t.charAt(i),new ArrayList<Integer>());
            list.add(i);
            map.put(t.charAt(i),list);
        }

        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) return false;
            List<Integer> list = map.get(c);
            prev = binarySearch(prev,list);
            if(prev == -1){
                return false;
            }

        }
        return true;
    }

    private int binarySearch(int prev, List<Integer> list) {
        int low = 0;
        int high = list.size()-1;
        while (low < high){
            int mid = low + (high - low)/2;
            if(list.get(mid) > prev){
                high = mid;
            }else {
                low = mid+1;
            }
        }
        return list.get(low) > prev? list.get(low) : -1;
    }


}
