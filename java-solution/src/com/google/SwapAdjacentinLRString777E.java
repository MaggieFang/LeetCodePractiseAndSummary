package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class SwapAdjacentinLRString777E {
    /**
     * KEYPOINTS:
     * <p>
     * the L can be move backward,to the prior position and the R can be move forward,in the feature position.
     * So we use two pointer, to find the non-X letter,when they are not same,return false.
     * (Why? Since when R, L only exchange with X,the relative position of L R cannot change.)
     * So when start[i] == 'L' then end[j] == 'L' and only when i > j, such that the L in start be move back to j position
     * similary, when 'R' only when i < j
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
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        int n = start.length();
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            while (j < n && end.charAt(j) == 'X') {
                j++;
            }
            if ((i < n && j >= n) || (i >= n && j < n)) { // e.g start = "X", end = "R",车辆不匹配情况
                return false;
            }

            if (i < n && j < n) {
                char c1 = start.charAt(i);
                char c2 = end.charAt(j);
                if (c1 != c2 || (c1 == 'L' && i < j) || (c1 == 'R' && i > j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }

        }
        return true;

    }
}
