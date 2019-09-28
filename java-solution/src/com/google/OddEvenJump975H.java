package com.google;

import java.util.*;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-28
 **/
public class OddEvenJump975H {
    /**
     * Clarification:
     * Though I know TreeMap is a good option here, map values v = A[i] to indices i.
     * But firstly, I consider it from left to right. when come to a new element in index i.
     * I want use ceiling/floor to find the next selection.(self must be selected and need to eliminate, if the some element only one,
     * then need to find higher/lower, and need to check whether the index is > i and maybe continue this process. it sucks). unless we
     * can designate to find from the latter part,unfortunately, treemap cannot this.
     * </p>
     * Keypoints:
     * The problem discussed above is about the index should be the latter part. so if you handle from right to left?
     * don't store all element into the map firstly, store from right to left when handled. in this case,we can just use
     * lowerKey/higher key to find the next step we want. So iterating from i = N-2 to i = 0, we have some value v = A[i] and
     * we want to know what the next largest or next smallest value is.
     * !!!! And we use dynamic programming to maintain odd[i] and even[i]: whether the state of being at index i on an odd or even numbered
     * jump is possible to reach.
     * <p>
     * lowerKey/highKey
     * </p>
     * TIME COMPLEXITY: O(NLogN)
     * SPACE COMPLEXITY: O(N)
     * </p>
     **/
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] even = new boolean[n]; // is it possible to reach here on even jumps/
        boolean[] odd = new boolean[n];
        even[n - 1] = true; // init
        odd[n - 1] = true;
        map.put(A[n - 1], n - 1);

        for (int i = n - 2; i >= 0; i--) {
            int cur = A[i];
            // maybe there are same element in the latter part. and it should be the next one be selected.有相等的肯定是先选上了
            if (map.containsKey(cur)) {
                even[i] = odd[map.get(cur)]; // note that the even and odd convert here. the even jumps will reach to odd jump next
                odd[i] = even[map.get(cur)];
            } else {
                Integer lower = map.lowerKey(cur);
                Integer high = map.higherKey(cur);
                if (lower != null) {
                    even[i] = odd[map.get(lower)];
                }
                if (high != null) {
                    odd[i] = even[map.get(high)];
                }
            }
            map.put(cur, i); // should be here not in else. even same element latter. and since the description said selected the smallest index first.so update it every time

        }
        int ans = 0;
        for (boolean b : odd) {
            if (b) ans++;
        }
        return ans;

    }

    /** a suck solution discussed in clarify**/
//    public int oddEvenJumps(int[] A) {
//        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//        int ans = 0;
//        for (int i = 0; i < A.length; i++) {
//            List<Integer> list = map.getOrDefault(A[i], new ArrayList<>());
//            list.add(i);
//            map.put(A[i], list);
//        }
//        for (int i = 0; i < A.length; i++) {
//
//            int toJump = 1;
//            int res = i;
//            while (res != A.length - 1) {
//                int cur = A[res];
//                if (toJump % 2 == 1) {
//                    List<Integer> floor = map.floorEntry(cur).getValue();
//                    if (floor.size() == 1) {
//                        Map.Entry<Integer, List<Integer>> tmp = map.higherEntry(cur);
//                        if (tmp == null) break;
//                        floor = tmp.getValue();
//                        if (floor == null) {
//                            break;
//                        }
//                        int index = 0;
//                        while (index < floor.size() && (res = (floor.get(index))) <= i) {
//                            index++;
//                        }
//                        if (res <= i) break;
//                    } else {
//                        int findNext = Collections.binarySearch(floor, i);
//                        if (findNext == floor.size() - 1) {
//                            break;
//                        }
//                        res = floor.get(findNext + 1);
//                    }
//
//                    toJump++;
//                } else {
//                    List<Integer> ceil = map.ceilingEntry(cur).getValue();
//                    if (ceil.size() == 1) {
//                        Map.Entry<Integer, List<Integer>> tmp = map.lowerEntry(cur);
//                        if (tmp == null) break;
//                        ceil = tmp.getValue();
//                        if (ceil == null) {
//                            break;
//                        }
//                        int index = 0;
//                        while (index < ceil.size() && (res = (ceil.get(index))) <= i) {
//                            index++;
//                        }
//                        if (res <= i) break;
//                    } else {
//                        int findNext = Collections.binarySearch(ceil, i);
//                        if (findNext == ceil.size() - 1) {
//                            break;
//                        }
//                        res = ceil.get(findNext + 1);
//                    }
//
//                    toJump++;
//                }
//            }
//            if (res == A.length - 1) {
//                ans++;
//            }
//        }
//        return ans;
//    }
}
