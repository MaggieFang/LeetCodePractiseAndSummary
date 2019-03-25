package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class DecodeWays91M {
    //memo[i]: start with i
    public int numDecodingsSimpler(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            int cur = s.charAt(i) - '0';
            int latter = s.charAt(i + 1) - '0';
            if (cur == 0) { // 即以0开头了，所以这个就不算了，0
                continue;
            }
            if (cur != 0) {
                if (cur * 10 + latter <= 26) {
                    memo[i] = memo[i + 1] + memo[i + 2];
                } else {
                    memo[i] = memo[i + 1];
                }
            }
        }
        return memo[0];

    }

    /**
     * KEYPOINTS:
     * <p>
     * we define the function decode(String s);
     * we do some example: "3": 1    decode("3") = 1;
     * "" : 1 ?? decode("")= 1;
     * "12345": 'a'+decode("2345") or 'l'+decode("345")
     * "27123": '2'+decode("7123")
     * "011": 0
     * so it is a recurrence question
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

    public int decodeRecurrence(String s) {
        return decodeHelper(s, s.length());
    }

    public int decodeHelper(String s, int k) {
        //base case;
        if (k == 0) {
            return 1;
        }
        int start = s.length() - k;
        if (s.charAt(start) == '0') {
            return 0;
        }

        //normal case
        int result = decodeHelper(s, k - 1);
        if (k >= 2 && (s.charAt(start) - '0') * 10 + s.charAt(start + 1) - '0' > 26) {
            result += decodeHelper(s, k - 2);
        }
        // but this is not effienct  F(6) will divide  into f[5] and f[4], f[5]will be divide into f[4] and f[3] and so on.
        // the complexcity is O(2^n)
        // so we can use dp and memorization.
        return result;
    }

    /**
     * KEYPOINTS:
     * <p>
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public int decodeHelperMemo(String s, int k, int[] memo) {
        //base case;
        if (k == 0) {
            return 1;
        }
        int start = s.length() - k;
        if (s.charAt(start) == '0') {
            return 0;
        }

        if (memo[k] != -1) {
            return memo[k];
        }

        int result = decodeHelperMemo(s, k - 1, memo);
        if (k >= 2 && (s.charAt(start) - '0') * 10 + s.charAt(start + 1) - '0' <= 26) {
            result += decodeHelperMemo(s, k - 2, memo);
        }

        memo[k] = result;
        return result;
    }

    public int decodeDP(String s) {
        int[] memo = new int[s.length() + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        return decodeHelperMemo(s, s.length(), memo);
    }

}
