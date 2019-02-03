package com.doordash;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-02
 * Talk is Cheap,Show me the Code.
 **/
public class SqrtWithPrecison {
    //https://www.geeksforgeeks.org/find-square-root-number-upto-given-precision-using-binary-search/
    public static float sqrt(int x, int precision) {
        int low = 0, high = x;
        double ans = 0.0f;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                ans = mid;
                break;
            }
            if (mid < x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        double fraction = 0.1;
        for (int i = 0; i < precision; i++) {
            while (ans <= x / ans) {
                ans += fraction;
            }
            ans -= fraction;
            fraction = fraction / 10;
        }
        return (float) ans;
    }
}
