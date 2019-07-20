package com.fb;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-20
 **/
public class FriendsOfAppropriateAges825M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * Given 1 <= ages.length <= 20000 and 1 <= ages[i] <= 120.
     * Instead of processing all 20000 people, we can process pairs of (age, count) representing how many people are that age.
     * For each pair (ageA, countA), (ageB, countB), if the conditions are satisfied with respect to age,
     * then countA * countB pairs of people made friend requests.
     * if ageA == ageB we need deduct the cases request themselves.
     * </p>
     * TIME COMPLEXITY: O(A^2) A is the distinct elements of age
     * SPACE COMPLEXITY: O(A)
     * </p>
     **/
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length < 2) return 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : ages) {
            int v = map.getOrDefault(e, 0);
            map.put(e, v + 1);
        }
        for (Map.Entry<Integer, Integer> A : map.entrySet()) {
            int ageA = A.getKey();
            for (Map.Entry<Integer, Integer> B : map.entrySet()) {
                int ageB = B.getKey();
                if (ageB <= (ageA >> 1) + 7) continue;
                if (ageB > ageA) continue;
                if (ageB > 100 && ageA < 100) continue;
                r += A.getValue() * B.getValue();
                if (ageB == ageA)
                    r -= A.getValue(); // important, for the same age, deduct the cases the request themselves.
            }
        }
        return r;

    }
}
