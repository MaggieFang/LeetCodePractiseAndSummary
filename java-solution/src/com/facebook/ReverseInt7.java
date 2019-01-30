package com.facebook;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/3/18
 * Talk is Cheap,Show me the Code.
 **/
public class ReverseInt7 {
    public int reverse(int i) {
        int sign = 1;
        if(i < 0){
            sign = -1;
            i *= sign;
        }
        System.out.println(i);

        long ans =0;
        while(i > 0){
            ans = ans*10 + i % 10;
            i /= 10;
        }

        if(ans > Integer.MAX_VALUE){
            return 0;
        }
        return (int)(sign*ans);

    }

    /**
     * KEYPOINTS:
     * <p>
     * corner condition: negative data -123 will return -321,
     * if one digit return itself
     * 120 return 21, we needn;t extra attation to it.
     * we get abs(x),and % 10 every time to get the result ,before handle every digit
     * the save result *10 + cur digit. and the left result is /10
     * But !!!! But please remember that the condition that the reverse number out of range.
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
    public int reverseInt2(int i) {
        int x = Math.abs(i);
        int result = 0;
        while (x > 0) {
            int tmp = result * 10 + x % 10;
            if ((tmp - x% 10)/10 != result) { // 说明超过MAX_VALUE了
                return 0;
            }
            result = tmp;
            x = x / 10;

        }
        if (i < 0) {
            return -result;
        }
        return result;

    }

    public int reverse1(int x) {
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

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE*-1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);

        ReverseInt7 test = new ReverseInt7();
        System.out.println(test.reverse(Integer.MIN_VALUE));
    }
}
