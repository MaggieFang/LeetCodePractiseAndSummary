package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/9/18
 * Talk is Cheap,Show me the Code.
 **/
public class FindCelebrity277M {
    /**
     * KEYPOINTS:
     * <p>
     * we set an candidate 0,and then if candidate knows i, so we change the candidate to i ,to find the final candidate
     * the secord loop is to verify this candidate.
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
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i))
                candidate = i;
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

    public boolean knows(int a, int b) {

        double d = Math.random();
        if (d > 0.5) {
            return true;
        }
        return false;
    }
}
