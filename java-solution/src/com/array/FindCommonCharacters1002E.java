package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-26
 * Talk is cheap,show me the Code.
 **/
public class FindCommonCharacters1002E {
    /**
     * Better
     * Clarification:
     *
     * </p>
     * Keypoints:
     * there are 26 lower letter. so we can check each letter(from 'a' to 'z') appear on each word.
     * and update the min count of the letter among the strings
     * </p>
     * TIME COMPLEXITY:  O(26*C) C is the total contnet of the strings 
     * SPACE COMPLEXITY: O(c)
     * </p>
     **/
    public List<String> commonChars1(String[] A) {
        List<String> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int min = Integer.MAX_VALUE;
            for (String s : A) {
                int cnt = 0;
                for (char cur_c : s.toCharArray()) if (cur_c == c) cnt++;
                min = Math.min(min, cnt);
            }

            for (int i = 0; i < min; i++) result.add("" + c);
        }

        return result;
    }

    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<String> commonChars(String[] A) {
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                int[] list = map.getOrDefault(c, new int[A.length]);
                list[i] = list[i] + 1;
                map.put(c, list);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int min = getMin(entry.getValue());
            while (min > 0) {
                res.add(entry.getKey() + "");
                min--;
            }

        }
        return res;
    }

    public int getMin(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i : A) {
            min = Math.min(min, i);
        }
        return min;
    }


}
