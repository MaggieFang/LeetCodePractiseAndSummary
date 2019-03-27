package com.amazon;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/28/18
 * Talk is Cheap,Show me the Code.
 **/
public class ImplementTriePrefixTree208M {
    class TrieNode {
        private static final int SIZE = 26;
        private TrieNode[] children = new TrieNode[SIZE];
        private boolean endOfWord;
        public TrieNode() {
        }
    }

    class Trie {
        private TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode tmp = root;
            for (int level = 0; level < word.length(); level++) {
                int idx = word.charAt(level) - 'a';
                if (tmp.children[idx] == null) {
                    tmp.children[idx] = new TrieNode();
                    // break; don't break,you are insert.you need to insert it into the chain
                }
                tmp = tmp.children[idx]; // not else,.you need to insert it into the chain
            }
            tmp.endOfWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            int n = word.length();
            TrieNode tmp = root;
            for (int level = 0; level < n; level++) {
                int idx = word.charAt(level) - 'a';
                if (tmp.children[idx] == null) {
                    return false;
                }
                tmp = tmp.children[idx];
            }
            return tmp != null && tmp.endOfWord;
        }


        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            int n = prefix.length();
            TrieNode tmp = root;
            for (int i = 0; i < n; i++) {
                int idx = prefix.charAt(i) - 'a';
                if (tmp.children[idx] == null) {
                    return false;
                }
                tmp = tmp.children[idx];
            }
            return true;

        }
    }
}
