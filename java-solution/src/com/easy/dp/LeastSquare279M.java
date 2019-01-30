package com.easy.dp;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class LeastSquare279M {
    /**
     * let T[n] is the reslut of taget n;
     * T(n) can be divided into n 个 1^2,
     * also can be divided T[n-4] +1(,T[n-9]+1,
     * T(n) = min{T[n-i^2]+1}, n-i^2 >=0;
     **/

    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] T = new int[n + 1];
        T[0] = 0;
        T[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = i; // default,the worst case. it divides by i numbers of 1;
            for (int j = 2; j * j <= i; j++) {
                min = Math.min(min, T[i - j * j] + 1);
            }
            T[i] = min;
        }
        return T[n];

    }

}
