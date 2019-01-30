package com.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class MostCommonWord819E {
    /**
     * KEYPOINTS:
     * <p>
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(P + B) where P is the size of paragraph and B is the size of banned.
     * <p>
     * SPACE COMPLEXITY: O(M) the words in the paragraph
     * <p>
    **/
    public static String mostCommonWord(String p, String[] banned) {
        HashMap<String,Integer> map = new HashMap<>(); //count
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length();i++){
            char c = p.charAt(i);
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }else if(sb.length() != 0){ //后者
                String s = new String(sb);
                map.put(s,map.getOrDefault(s,0) + 1);
                sb = new StringBuilder();
            }
        }

        if(sb.length() != 0){ // "bob",[] 情况
            String s = new String(sb);
            map.put(s,map.getOrDefault(s,0) + 1);
        }

        for(String s: banned){
            s = s.toLowerCase();
            if(map.containsKey(s)){
                map.remove(s);
            }
        }

        int max = Integer.MIN_VALUE;
        String ans = null;
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue() > max){
                max = entry.getValue();
                ans = entry.getKey();
            }
        }
        return ans;


    }

    public static void main(String[] args){
        System.out.println(mostCommonWord("Bob",
                new String[]{}));
    }
}
