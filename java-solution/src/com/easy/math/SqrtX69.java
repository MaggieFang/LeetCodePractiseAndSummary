package com.easy.math;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class SqrtX69 {
    public static int mySqrtBinarySearch(int x) {
        if (x == 0) return 0;
        int low = 1, high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            if (mid > x / mid) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
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



}
