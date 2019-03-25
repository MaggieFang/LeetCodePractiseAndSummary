package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class DivideTwoInt29M {
    /**
     * problem consider:
     * 1. +/-  use sign indicate it.
     * 2. overrange. change it to long
     * 3. result =0, abs(a)< abs(b); notice a = -1, b =1;
     * 4. b == 1  result is a;
     * 5. normal. e.g 17 /3
     *  3              multi =1
     *  3+3 = 6 < 17   multi = 2
     *  6 + 6 = 12 < 17     multi = 3 + 3
     *  12 + 12 = 32 > 17  so use left 17 -12 to do the same loop;
     * **/
    public int divideComculative(int a,int b){
        if( b == 1){
            return a;
        }

        boolean negative = (a > 0 && b < 0) || (a < 0 && b > 0);
        long la = Math.abs((long)a);
        long lb = Math.abs((long)b);
        long lr = divideLong(la,lb);
        if(lr > Integer.MAX_VALUE){
            return negative? Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
        return (int) (negative? -lr:lr);
    }

    public long divideLong(long a, long b){
        if( a < b ){
            return 0;
        }

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = b;
        long multiple = 1;
        while (sum + sum <= a){
            sum = sum + sum;
            multiple += multiple;

        }
        return multiple  +divideLong(a - sum,b);
    }


    //divide by minus. 除法就是找出有几个减法 e.g 7/3 = 2. 7-3 = 4, 4-3= 1 两个
    public int divide(int a, int b) {
        int result = 0;
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        }
        if (b == 1) {
            return a;
        }

        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        if (a != Integer.MIN_VALUE && b != Integer.MIN_VALUE) {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            while (absA >= absB) {
                result++;
                absA = absA - absB;
            }
            if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
                result = 0 - result;
            }
            return result;
        }

        if (a == Integer.MIN_VALUE) {
            int newA = Math.abs(a + 1);
            int newB = Math.abs(b);
            while (newA >= newB) {
                result++;
                newA = newA - newB;
            }
            if (newA + 1 - newB >= 0) {
                result++;
            }

            if (b > 0) {
                result = 0 - result;
            }
            return result;
        }
        return result;
    }

    public static void main(String[] s) {
        // a = -2147483648,b = -1 overflow
        // a = -1,b = 1;
        // a = 10,3
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE)); //居然还是他

        DivideTwoInt29M test = new DivideTwoInt29M();
        System.out.println(test.divideComculative(10, 3));
        System.out.println(test.divide(1, -1));
    }

}
