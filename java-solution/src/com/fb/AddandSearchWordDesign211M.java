package com.fb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-07-20
 **/
public class AddandSearchWordDesign211M {
    public static void main(String[] args) {
        WordDictionary test = new WordDictionary();
        test.addWord("bad");
        test.addWord("dad");
        test.addWord("mad");
        test.search("b..");
        System.out.println();
    }

    static class WordDictionary {

        /**
         * Initialize your data structure here.
         */
        Set<String> set;

        public WordDictionary() {
            set = new HashSet<>();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            set.add(word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            if (word.indexOf('.') == -1) {
                return set.contains(word);
            }
            return search(word.toCharArray(), word, 0);

        }

        public boolean search(char[] word, String origin, int start) {
            int index = origin.indexOf('.', start);
            if (index == -1) return set.contains(new String(word));
            for (char c = 'a'; c <= 'z'; c++) {
                word[index] = c;
                if (search(word, origin, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

}
