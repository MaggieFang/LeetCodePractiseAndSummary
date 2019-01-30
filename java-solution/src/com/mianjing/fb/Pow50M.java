package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/14/18
 * Talk is Cheap,Show me the Code.
 **/
public class Pow50M {
    /**
     * KEYPOINTS:
     * <p>
     * this is my solution,but it says times exceed given x  = 0.0000001 n = MAX_VALUE
     * 1. x == 0 or x == 1
     * 2. n = 0;
     * 3. n may be < 0; overturn
     * 4. n may be MIN_VALUE to long or precessed it.
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
    public double myPowTimeExceed(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }

        if (n == 0) {
            return 1;
        }

        int N = Math.abs(n);

        double ans = x;
        int count = 1;
        while (count + count <= N) {
            ans = ans * ans;
            count = count + count;
        }

        int left = N - count;
        while (left > 0) {
            ans = ans * x;
            left--;
        }
        if (n < 0) {
            return 1 / ans;
        }

        return ans;

    }


    /**
     * Solution 2
     * KEYPOINTS:
     * <p>
     *     1 n negtive,change x to 1/x;
     *     2. n my be MIN_VALUE so 2^MIN_VALUE when we change it to -n will overflow.so change N to long
     *     compute half = heler(x,n/2) and judge n odd or even.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:logN
     * <p>
     * SPACE COMPLEXITY:logN
     * <p>
     **/

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n; //可能n = MIN_VALUE;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }


    /**
     * KEYPOINTS: Soluton 3 Good Good GOOD
     * <p>
     * solution 3:
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
    public double myPowHalf(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }

        if (x == -1 && n % 2 == 0) {
            return 1;
        }
        if (x == -1 && n % 2 == 1) {
            return -1;
        }

        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            return 0;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n % 2 == 0 ? myPowHalf(x * x, n / 2) : x * myPowHalf(x * x, n / 2);
    }

}
