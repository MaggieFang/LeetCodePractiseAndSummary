package com.trie;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-27
 * Talk is cheap,show me the Code.
 **/
public class LongestWordinDictionary720 {
    /**
     * Clarification:
     *  refer to ImplementTriePrefixTree208M
     * </p>
     * Keypoints:
     *Trie(refer to ImplementTriePrefixTree208M) + DFS(I have a litte stuck here)
     * </p>
     * TIME COMPLEXITY: creating a trie is O(W*L), where W is the number of words, and L is an average length of the word,
     * when finding the longest, you have to retrive each letter .so it is alos O(W*L)
     * SPACE COMPLEXITY: O(W*L)
     * </p>
     **/
    public static final int SIZE = 26;
    public String res = "";

    public String longestWord(String[] words) {
        Trie trie = buildRelation(words);
        for (int i = 0; i < SIZE; i++) {
            if (trie.root.children[i] != null) {
                dfs(trie.root.children[i], 1);
            }
        }
        return res;
    }

    public Trie buildRelation(String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        return trie;
    }


    public void dfs(TrieNode trie, int depth) {
        if (trie.word == null) return;
        if (depth > res.length()) {
            res = trie.word;
        }

        for (int i = 0; i < SIZE; i++) {
            if (trie.children[i] != null) {
                dfs(trie.children[i], depth + 1);
            }
        }

    }


    class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode tmp = root;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                int idx = s.charAt(i) - 'a';
                if (tmp.children[idx] == null) {
                    tmp.children[idx] = new TrieNode();
                }
                tmp = tmp.children[idx];
            }
            //tmp.endOfWord = true;
            tmp.word = s;
        }

    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[SIZE];
        // public boolean endOfWord;
        public String word;
    }
}
