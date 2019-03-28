package com.twopointer;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-27
 * Talk is cheap,show me the Code.
 **/
public class LongPressedName925E {
    /**
     * example : Input: name = "saeed", typed = "ssaaedd"  => false since e must be repeat
     * Clarification:
     *
     * </p>
     * Keypoints:
     * use 2 pointers for the two words. for a char in name C. try to move forward until the char != C.
     * but there maybe continous duplicate char in name. so each time. we not move just one char but one type of char. for the above example.
     * so we can count the continous same char of name (cnt), and when move the typed. we subdivide the cnt.
     * when break the move of typed. check whether cnt <= 0. if yes, we can check the new type of char, otherwise return false.
     *
     * </p>
     * TIME COMPLEXITY: O(N+M)
     * SPACE COMPLEXITY: O(1)
     * </p>
     **/
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        int len1 = name.length();
        int len2 = typed.length();
        while (i < len1) {
            int cnt = 1;
            char c = name.charAt(i);
            while (i + 1 < len1 && name.charAt(i) == name.charAt(i + 1)) {
                i++;
                cnt++;
            }

            while (j < len2 && c == typed.charAt(j)) {
                cnt--;
                j++;
            }

            if (cnt <= 0) {
                ++i;
            } else {
                return false;
            }
        }
        return true;
    }
}
