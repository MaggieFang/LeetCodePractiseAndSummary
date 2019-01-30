package com.easy.hashtable;

import java.util.LinkedList;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/18/18
 * Talk is Cheap,Show me the Code.
 **/
public class CountPrimeNumber204 {
    /**
     * KEYPOINTS:
     * <p>
     * will exceed time limit
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

    public int countPrimes(int n) {
        LinkedList<String> m;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }

        }
        return count;
    }

    public boolean isPrime(int i) {
        if (i <= 1) {
            return false;
        }

        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * KEYPOINTS:
     * <p>
     * 我们从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，
     * 然后到下一个质数3，标记其所有倍数，类推，直到根号n，此时数组中未被标记的数字就是质数。
     * 之所以不用考虑比自己小的倍数,是因为自己已经被作为小的数的倍数考虑过，如i=5时候，5*2，5*3这些在i =2,3时候已经被算了，
     * 因此每一个数都从自身倍数开始直到n。
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

    public int countPrimesOpts(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;

        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ++count;
            }
        }
        return count;


    }

}
