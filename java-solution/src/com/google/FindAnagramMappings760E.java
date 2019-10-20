package com.google;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-01
 * Talk is Cheap,Show me the Code.
 **/
public class FindAnagramMappings760E {
    //  can reuse the element or not use each of them. don't forget to check this with interviewer.
    // A: [12,12,13]  B: [13,12,13]
    public int[] anagramMappings(int[] A, int[] B) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < B.length; i++){
            map.put(B[i],i);
        }

        int[] ans = new int[B.length];
        int i = 0;
        for(int x:A){
            ans[i++] = map.get(x);
        }
        return ans;
    }

}
