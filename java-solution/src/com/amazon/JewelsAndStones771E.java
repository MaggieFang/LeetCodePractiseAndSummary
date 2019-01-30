package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class JewelsAndStones771E {

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0) {
            return 0;
        }

        char[] cj = new char[64];
        for (int i = 0; i < J.length(); i++) {
            cj[J.charAt(i) - 'A']++;
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (cj[S.charAt(i) - 'A'] - 1 >= 0) {
                ans++;
            }
        }
        return ans;

    }
}
