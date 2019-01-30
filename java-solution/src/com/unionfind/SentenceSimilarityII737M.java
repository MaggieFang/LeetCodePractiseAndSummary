package com.unionfind;

import java.util.HashMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/1/19
 * Talk is Cheap,Show me the Code.
 **/
public class SentenceSimilarityII737M {
    /**
     * KEYPOINTS:
     * <p>
     * [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
     * union-find 依旧是int的，但是string数组时候，其实就是第i个string数组跟第j个这样的比较,例如root[1] = 0,
     * 是表示 ["fine", "good"]跟["great", "good"]是一个group的，而用map<String,Index>是为了辅助记住某个string是否处理过
     * 如果没处理过，那我们认为他就是map向自己的index，如果有，那我们就通过map来找他之前的index是什么，这样来建立root关系
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
    public boolean areSentencesSimilarTwo(String[] w1, String[] w2, String[][] pairs) {
        if (w1.length != w2.length) {
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int[] root = new int[pairs.length];
        for (int i = 0; i < root.length; i++) {
            root[i] = i;
        }

        for (int i = 0; i < pairs.length; i++) {
            for (String s : pairs[i]) {
                if (!map.containsKey(s)) {
                    map.put(s, i);
                }
                int x = findRoot(map.get(pairs[i][0]), root);
                int y = findRoot(map.get(s), root);
                if (x != y) {
                    root[y] = x;
                }
            }
        }

        for (int i = 0; i < w1.length; i++) {
            if (w1[i].equals(w2[i])) continue;
            if (!map.containsKey(w1[i]) || !map.containsKey(w2[i])) return false;
            int x = findRoot(map.get(w1[i]), root);
            int y = findRoot(map.get(w2[i]), root);
            if (x != y) {
                return false;
            }
        }
        return true;
    }

    public int findRoot(int i, int[] root) {
        if (root[i] != i) { //path compression的做法
            root[i] = findRoot(root[i], root);
        }
        return root[i];
    }
}
