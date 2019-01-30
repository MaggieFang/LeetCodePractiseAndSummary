package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/30/18
 * Talk is Cheap,Show me the Code.
 **/
public class CombinationPhoneNumber17M {
    /**
     * KEYPOINTS:
     * <p>
     *     backtrace.
     *
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
    String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        combindUtils("", digits, 0, ans);
        return ans;

    }

    public void combindUtils(String prefix, String digits, int offset, List<String> ans) {
        if (offset >= digits.length()) {
            ans.add(prefix);
            return;
        }
        String keys = map[digits.charAt(offset) - '0'];
        for (int i = 0; i < keys.length(); i++) {
            combindUtils(prefix + keys.charAt(i), digits, offset + 1, ans);//prefix not use stringBuilder and append ,otherwise had to remove the append part after that.
        }


    }
}
