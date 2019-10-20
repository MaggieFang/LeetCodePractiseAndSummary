package com.google;

import java.util.HashSet;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-06-02
 **/
public class BuddyStrings859E {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * if A.length != B.length , false
     * then count the number difference between A and B; if count > 2 || count == 1 return false;
     * if count == 0, mean A.equals(B), only if A has duplicate charater, it can exchange itself and still the same, of course still same with B
     * for count == 2 find the two indexs they are differ,indicate i,j then must A[i] == B[j] && A[j] == B[i]
     *
     * </p>
     * TIME COMPLEXITY: O(n)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() == 0) return false;
        int n = A.length();
        int count = 0;
        int i = 0;
        while (i < n) { //count the number of difference between A and B. if count > 2 || count == 1 return false
            if (A.charAt(i) != B.charAt(i)) count++;
            i++;
        }

        if (count > 2 || count == 1) return false;

        //for A.equals(B). 只要A存在重复的元素，那他们就可以互换还是自己且等于B,也可以count int[26] count A，只要有count[i]>1
        if (count == 0) { // e.g A=B = ab is false ,  A= B= abab is true.so it must
            HashSet<Character> set = new HashSet<>();
            set.add(A.charAt(0));
            i = 1;
            while (i < n) {
                if (set.contains(A.charAt(i))) return true;
                i++;
            }
            return false;
        }

        i = 0;
        int dif = -1;
        while (i < n && A.charAt(i) == B.charAt(i)) i++;
        dif = i;
        i++;
        while (i < n && A.charAt(i) == B.charAt(i)) i++;
        return A.charAt(i) == B.charAt(dif) && B.charAt(i) == A.charAt(dif);

    }
}
