package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/6/19
 * Talk is Cheap,Show me the Code.
 **/
public class StrobogrammaticNumberII248H {
    /**
     * KEYPOINTS:
     * <p>
     *     idea from 247
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    private int ans;

    public int strobogrammaticInRange(String low, String high) {
        for (int i = low.length(); i <= high.length(); i++) {
            help(0, i - 1, new char[i], low, high);
        }
        return ans;
    }

    public void help(int l, int r, char[] tmp, String low, String high) {
        if (l > r) {
            if (valid(low, high, tmp)) {
                ans++;
            }
            return;
        }
        if (l == r) {
            tmp[l] = '8';
            if (valid(low, high, tmp)) {
                ans++;
            }

            tmp[l] = '1';
            if (valid(low, high, tmp)) {
                ans++;
            }

            tmp[l] = '0';
            if (valid(low, high, tmp)) {
                ans++;
            }
            return;

        }

        if (l != 0) {
            tmp[l] = tmp[r] = '0';
            help(l + 1, r - 1, tmp, low, high);
        }

        tmp[l] = tmp[r] = '1';
        help(l + 1, r - 1, tmp, low, high);

        tmp[l] = tmp[r] = '8';
        help(l + 1, r - 1, tmp, low, high);

        tmp[l] = '6';
        tmp[r] = '9';
        help(l + 1, r - 1, tmp, low, high);

        tmp[l] = '9';
        tmp[r] = '6';
        help(l + 1, r - 1, tmp, low, high);


    }

    public boolean valid(String low, String high, char[] tmp) {
        String s = new String(tmp);
        return compare(s, low) && compare(high, s);
    }

    public boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() > s2.length();
        }

        return s1.compareTo(s2) >= 0;
    }



}
