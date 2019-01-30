package com.easy.math;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class ReverseInt6 {
    public static void main(String[] args) {
        System.out.println(reverse(120));
    }

    /**
     * KEYPOINTS:
     * <p>
     * we must consider the condition of int overflow, e.g. input 1534236469,when s = "1534236469"
     * will throw NumberFormatException.
     * So we should ensure when x = 0 ,and when overflow, how to return(here return 0);
     * <p>
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
    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }
        int tmp = Math.abs(x);
        StringBuilder builder = new StringBuilder();
        while (tmp != 0) {
            builder.append(tmp % 10);
            tmp /= 10;
        }

        try {
            int r = Integer.parseInt(builder.toString());
            if (x < 0) {
                r = 0 - r;
            }
            return r;
        } catch (NumberFormatException e) {
            return 0;
        }


    }
}
