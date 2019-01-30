package com.easy.dp;

import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class WordBreak139M {
    // catag {cat,tag}
    // catadvance {cat ad, advance}
    // if the list or string null. false ?
    // boolean[] t.length of s.length: t[i] means that s[0..i] can be seprate by dict. t[n];
    /**
     * KEYPOINTS:
     * <p>
     *    Question: 1) the char in s can be used duplicate? catag {cat,tag}?
     *   some test: catadvance {cat, ad, advance};
     *
     * boolean[] t of length s.length;  t[i] means that s[0..i] can be seprate by dict.
     * what we want is t[n-1];
     *  for i from 0 to n -1:
     *      for j from 0 to io:
     *
     *      if(s.substring[j,i+1] can be found in dict && (j == 0 ||t[j-1]))
     *          t[i] = true;
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
    **/
    public boolean wordBreak(String s, List<String> dict) {
        if(dict == null || dict.size() == 0 || s == null || s.length() == 0){
            return false;
        }

        int n = s.length();
        boolean[] t = new boolean[n];
        for(int i = 0; i< n; i++){
            for(int j = 0; j <= i; j++){
                if((j ==0|| t[j-1] ) && dict.contains(s.substring(j,i+1))){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n-1];

    }
}
