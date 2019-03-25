package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class FirstBadVersion278E {


    /**
     * KEYPOINTS:
     * <p>
     *  binary search,if mid = false. so the bad must be the latter half. so left = mid +1 ,
     *  if mid =  true,so mid may not be the first bad. we can search it right = mid -1;
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
    public int firstBad(int n, int s, int e) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int a) {
        double d = Math.random();
        if (d > 0.5) {
            return true;
        }
        return false;
    }
}
