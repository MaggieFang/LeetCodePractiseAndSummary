package com.mianjing.gou;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
public class TwitchWords {
    //https://www.lintcode.com/problem/twitch-words/description
    public int[][] twitchWords(String str) {
        //aaw
        int i = 0, j = 0;
        List<int[]> ans = new ArrayList<>();
        int n = str.length();
        while (j < n) {
            while (j < n && str.charAt(j) == str.charAt(i)) {
                j++;
            }
            if (j - i > 2) {
                ans.add(new int[]{i, j - 1});
            }
            i = j;
        }
        int[][] a = new int[ans.size()][2];
        for (int k = 0; k < ans.size(); k++) {
            a[k] = ans.get(k);
        }
        return a;
    }
}
