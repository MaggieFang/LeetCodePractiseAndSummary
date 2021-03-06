package com.google;

import java.util.*;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-19
 **/
public class BraceExpansion1087M {
    /**
     * Clarification:
     * backtracking
     * <p>
     * case 1: "abcd", so need to S.indexOf('{')
     * case 2: {a,b}
     * case 3: ..
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public String[] expand(String S) {
        if (S == null) return new String[]{};
        if (S.indexOf('{') < 0) return new String[]{S}; //!!! take care. e.g abacd

        //also can use S.split("\\{|\\}"); to split. but need the eliminate the empty "" result and the "," in each string
        List<char[]> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '}' || c == '{') {
                if (sb.length() != 0) {
                    list.add(toSortedChar(sb));
                    sb.setLength(0);
                }
            } else if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
            list.add(toSortedChar(sb));
        }

        List<String> ans = new ArrayList<>();
        dfs(list, 0, new StringBuilder(), ans);
        String[] res = new String[ans.size()];
        return ans.toArray(res);
    }

    private char[] toSortedChar(StringBuilder sb) {
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return cs;
    }

    private void dfs(List<char[]> ori, int i, StringBuilder cur, List<String> ans) {
        if (i >= ori.size()) {
            ans.add(cur.toString());
            return;
        }
        for (char c : ori.get(i)) {
            cur.append(c);
            dfs(ori, i + 1, cur, ans);
            cur.deleteCharAt(cur.length() - 1);
        }

    }
}
