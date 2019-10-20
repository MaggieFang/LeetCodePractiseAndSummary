package com.google;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class BullsandCows299M {
    /**
     * Clarification:
     * iterate over the numbers in secret and in guess and count all bulls right away.
     * for cows, we count the numbers of each character in s and g respectively, the min of the count is the cows for this character.
     * since all them are '0'~'9',we can use int[10] to count them.
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public String getHint(String s, String g) {
        int bull = 0;
        int cow = 0;
        int[] n1 = new int[10];
        int[] n2 = new int[10];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = g.charAt(i);
            if (c1 == c2) {
                bull++;
            } else {
                n1[c1 - '0']++;
                n2[c2 - '0']++;
            }
        }

        for (int i = 0; i < n1.length; i++) {
            cow += Math.min(n1[i], n2[i]);
        }
        return bull + "A" + cow + "B";
    }

    /**
     * The idea is to iterate over the numbers in secret and in guess and count all bulls right away.
     * For cows maintain an array that stores count of the number appearances in secret and in guess.
     * Increment cows when either number from secret was already seen in guest or vice versa.
     **/
    public String getHint2(String s, String g) {
        int bull = 0;
        int cow = 0;
        int[] n = new int[10];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = g.charAt(i);
            if (c1 == c2) {
                bull++;
            } else {
                if (++n[c1 - '0'] <= 0) {
                    cow++;
                }
                if (--n[c2 - '0'] >= 0) {
                    cow++;
                }

            }
        }


        return bull + "A" + cow + "B";
    }

}
