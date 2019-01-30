package com.backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class Permutation {

    // Java program to print all permutations of a
// given string.

    public static void main(String[] args) {
        String str = "ABC";
        String str2 = "ABB";
        Permutation permutation = new Permutation();
//        permutation.permute(str);
        permutation.permuteDuplicate(str2);

    }

    private void permute(String s) {
        List<String> ans = new ArrayList<>();
        permuteHelper(s, new StringBuilder(), ans);
        System.out.println(ans.size());
    }

    /**
     * KEYPOINTS:
     * <p>
     * this works for all char are unique.
     * but if there are some duplcate. it fails
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:O(n*n!) Note that there are n! permutations and it requires O(n) time to print
     * a permutation.
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    private void permuteHelper(String s, StringBuilder chosen, List<String> ans) {
        if (s.length() == 0) {
            ans.add(chosen.toString());
            System.out.println(chosen.toString());
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                chosen.append(c);
                String sub = s.substring(0, i) + s.substring(i + 1);
                permuteHelper(sub, chosen, ans);
                chosen.deleteCharAt(chosen.length() - 1);
            }
        }
    }


    private void permuteDuplicate(String s) {
        List<String> ans = new ArrayList<>();
        char[] cs = s.toCharArray();
        Arrays.sort(cs);

        permuteHelperDuplicate(String.valueOf(cs), new StringBuilder(), ans);
        System.out.println(ans.size());
    }

    private void permuteHelperDuplicate(String s, StringBuilder chosen, List<String> ans) {
        if (s.length() == 0) {
            ans.add(chosen.toString());
            System.out.println(chosen.toString());
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (chosen.length() - 1 >= 0 && (chosen.charAt(chosen.length() - 1) == c)) {
                    continue;
                }
                chosen.append(c);
                String sub = s.substring(0, i) + s.substring(i + 1);
                permuteHelper(sub, chosen, ans);
                chosen.deleteCharAt(chosen.length() - 1);
            }
        }
    }


}
