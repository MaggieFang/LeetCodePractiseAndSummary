package com.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-01
 * Talk is Cheap,Show me the Code.
 **/
public class ExpressiveWords809M {
    /**
     * KEYPOINTS:
     *  find the key of S and the count of each character.
     *  e.g. "abbcccddddaaaaa", "key" is "abcda", and the "count" [1,2,3,4,5].
     *  and for each query in the words. we similarily find the "key" and count
     *  if key not the same, skip.
     *   assume c1 = S.count[i] and c2 = query.count[i]
     *   if c2 > c1,we need to delete char in query, so skip
     *   if c1 < 3 ,c1 must equals to c2
     * </p>
     * TIME COMPLEXITY: O(QK), where Q is the length of words (at least 1), and K is the maximum length of a word.
     * <p>
     * SPACE COMPLEXITY:O(K)
     * <p>
     **/
    public int expressiveWords(String S, String[] words) {
        int ans = 0;
        RLE r1 = new RLE(S);
        for (String w : words) {
            RLE r2 = new RLE(w);
            if (!r2.key.equals(r1.key)) continue;
            int i = 0;
            for (; i < r2.count.size(); i++) {
                int c1 = r1.count.get(i);
                int c2 = r2.count.get(i);
                if (c2 > c1) break;
                if (c1 < 3 && c1 != c2) break;
            }
            if (i >= r2.count.size()) ans++;

        }
        return ans;
    }
}

class RLE {
    String key;
    List<Integer> count;

    public RLE(String s) {//!!! 按顺序找出每个char的计数
        StringBuilder sb = new StringBuilder();
        count = new ArrayList<>();
        int n = s.length();
        int id = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                count.add(i - pre + 1);
                pre = i + 1;
            }
        }
        key = sb.toString();
    }

    public static void main(String[] args) {
        ExpressiveWords809M t = new ExpressiveWords809M();
        t.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
    }


}