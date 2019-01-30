package com.mianjing.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/13/19
 * Talk is Cheap,Show me the Code.
 **/
public class CopyConcatenate {
    //https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=460956&_dsign=ca707c21
    public int subSuquence(String t, String s) {
        int i = 0, j = 0;
        int n = s.length();
        int m = t.length();
        int ans = 1;
        while (i < m) {
            while (i < m && j < n && t.charAt(i) != s.charAt(j)) {
                j++;
            }
            if (j >= n) {
                j = 0;
                ans++;
            }
            i++;
            j++;
        }

        return ans;
    }


}
