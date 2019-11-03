package kongqichuang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-03
 **/
public class PalindromePairs336H {
    /**
     * Clarification:
     *["a",""], output [[0,1],[1,0]]
     * </p>
     * Keypoints:
     * the brute force is traverasal for each pair of word, and check both w1+w2 and w2+w1 is palindrome or not.
     * There are case (1) "abc","cba" when reverse(w1)  equals to w2. (2) "abcd","cba" to combine w1+w2
     * (3) "abcd","dcb" to combind w2+w1
     * firstly, we map the word to their index. and then for each word w. we split at each position into two words s1 and s2,
     * if s1 is palindrome, then if reverse s2 exist in the map, we said w2. then it means w2+w is a result for us.
     * if s2 is palindrome, the if reverse s1 exists in the map, we said w2, then it mean w+w2 is a result.
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int len = s.length();
            for (int j = 0; j <= len; j++) { // noticed need to check j<= len for all cases/
                String s1 = s.substring(0, j);
                String s2 = s.substring(j);
                if (isPalindrome(s1)) {
                    int idx = map.getOrDefault(reverse(s2), -1);
                    if (idx != -1 && idx != i) { // it means w2+w
                        res.add(Arrays.asList(idx, i));
                    }
                }

                if (isPalindrome(s2)) {
                    int idx = map.getOrDefault(reverse(s1), -1);
                    // check "str.length() != 0" to avoid duplicates,
                    if (idx != -1 && idx != i && s2.length() != 0) { // it means w + w2
                        res.add(Arrays.asList(i, idx));
                    }
                }
            }
        }
        return res;
    }

    private String reverse(String s) {
        if (s == null || s.length() == 0) return s;
        return new StringBuilder(s).reverse().toString();
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
