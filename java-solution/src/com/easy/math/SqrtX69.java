package com.easy.math;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class SqrtX69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
        System.out.println(mySqrtBinarySearch(2147395600));

    }

    /**
     * KEYPOINTS:
     * <p>
     * 这里尤其注意数据类型溢出情况. 例如mySqrt中，开始判断用 i*i <= n,对于n = 2147395600，实际答案 i=46340,但
     * 46341*46341就溢出变为负数.
     * 下面二分法实际也是注意了所以用了mid > x / mid
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
    public static int mySqrt(int x) {
        int i = 1;
        while (i <= x / i) { //!!! important,  don not use i * i <= x; i*i may out of range of Int.
            ++i;
        }
        return i - 1;
    }

    public static int mySqrtBinarySearch(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left) / 2;//这里也是trick的，看起来等于(left+right)/2,但不能这么弄 1+MAX_VALUE就溢出了
//            int mid =(left+right)/2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
        }

    }
}