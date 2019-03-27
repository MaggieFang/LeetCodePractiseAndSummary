package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-03-26
 * Talk is cheap,show me the Code.
 **/
public class ImplementMagicDictionary676M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * Map<Integer,List<String>> the key is the length of String, and v is the word with the length();
     * when search, check the length of the search word and just retrive the v of the same length
     * </p>
     * TIME COMPLEXITY: O(N) to buildDict, N is the cnt of dict.and O(NK) to search at worst case, K is the length of search word
     * SPACE COMPLEXITY: O(N) 
     * </p>
     **/
    static class MagicDictionary {
        HashMap<Integer, List<String>> map;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            map = new HashMap<>();
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String s : dict) {
                map.computeIfAbsent(s.length(), v -> new ArrayList<>()).add(s);
            }
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            if (word == null) return false;
            if (!map.containsKey(word.length())) return false;
            List<String> list = map.get(word.length());
            for (String s : list) {
                int diffCnt = 0;
                for (int i = 0; i < word.length(); ++i) {
                    if (word.charAt(i) == s.charAt(i)) continue;
                    diffCnt++;
                    if (diffCnt > 1) break;
                }
                if (diffCnt == 1) return true;
            }
            return false;
        }
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
}
