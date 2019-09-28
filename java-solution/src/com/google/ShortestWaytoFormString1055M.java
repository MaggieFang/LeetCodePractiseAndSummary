package com.google;

import java.util.*;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-28
 **/
public class ShortestWaytoFormString1055M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * we can use two pointer , one iterate src, another iterate tar.
     * for each tar char, we move j until src[j] == tar[i], if j == src.length, ans++, j = 0 and recheck the cur target char
     * in this solution, we greedy match as many chars from src to tar as possible which can lead mininum use of src.
     * and we can build a set to save all the char in src, if there exists a char from tar which not exists in set, return -1.
     * </p>
     * TIME COMPLEXITY: O(len(source)*len(target))
     * SPACE COMPLEXITY: O(len(source))
     * </p>
     **/
    public int shortestWay(String source, String target) {
        int ans = 1;
        int slen = source.length();
        int tlen = target.length();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < slen; i++) {
            set.add(source.charAt(i));
        }
        int j = 0;
        int i = 0;
        while (i < tlen) {
            char c = target.charAt(i);
            if (!set.contains(c)) return -1;
            while (j < slen && c != source.charAt(j)) {
                j++;
            }
            if (j == slen) { // if to end. redo this char
                j = 0;
                ans++;
            } else {
                i++;
                j++;
            }
        }
        return ans;
    }

    /**
     * Clarification:
     * O(log(len(source))* len(target))
     * </p>
     * Keypoints:
     * we can see we look the source each time. so we consider use map to make it quicker for looking
     * to find a logM way, it is easy to think of binary search. for each char in tar, we need loop from j to end, to find a char same as tar[i].
     * we can build a map which key is from 'a' -> 'z', the value is idx for this char in src. because idx is add from small to big.
     * when we iterate tar[i], we can easily to find the tar[i]'s idx list. to search is there a idx is larger or equal than j+1.
     * it is logM. and we have N char in tar, so the time complexity is N * logM
     * the time is to build the map is O(M);
     * </p>
     * TIME COMPLEXITY: O(Log(M)*N)
     * SPACE COMPLEXITY: O(M)
     * </p>
     **/
    public int shortestWay2(String source, String target) {
        int slen = source.length();
        int tlen = target.length();
        List<Integer>[] sr = new List[26];
        for (int i = 0; i < 26; i++) {
            sr[i] = new ArrayList<>();
        }
        for (int i = 0; i < slen; i++) {
            sr[source.charAt(i) - 'a'].add(i);
        }
        int ans = 1;
        int i = 0;
        int j = 0;
        while (i < tlen) {
            char c = target.charAt(i);
            List<Integer> candidate = sr[c - 'a']; // candidate position for c, >= j+1
            if (candidate.size() == 0) return -1;
            int k = Collections.binarySearch(candidate, j);
            // when it not found. the (-k-1) is the right index we want.e.g if 'a' is in [0,5,7],and now if we have loop j = 2 for a prior char(assume an 'x'), and j++,
            // now in this interate, we try to look j which is whether in candidate. it will return -2, mean -k -1 = 1 is the position to match it.
            if (k < 0) k = -k - 1;
            if (k == candidate.size()) { // means the right position is the last one.
                j = 0;
                ans++;
            } else {
                j = candidate.get(k) + 1;
                i++;
            }
        }
        return ans;
    }
}
