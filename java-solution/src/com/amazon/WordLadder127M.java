package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/4/18
 * Talk is Cheap,Show me the Code.
 **/
public class WordLadder127M {
 /**
  * KEYPOINTS:
  * <p>
  *    use a set reached to handle the current level.
  *    to iterate the reached set. for every string,to change every bit from 'a' to 'z' and
  *    if it is in the wordList,(use wordSet.remove(newS) ). then add it to the nextSet.
  *    after the loop. reached = nextSet;
  *
  *    hit - pot -
  *        - dot - dog
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
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        Set<String> reached=new HashSet<>();

        reached.add(beginWord);
        wordSet.remove(beginWord);

        int level=1;
        while(!reached.isEmpty()) {
            Set<String> reachedNext=new HashSet<>(); // to save the next layer set.
            for(String s: reached) {
                for(int i=0;i<s.length();i++) {
                    char[] c=s.toCharArray();
                    for(char j='a';j<='z';j++) {
                        c[i]=j;
                        String newS=new String(c);
                        if(wordSet.remove(newS)) {
                            reachedNext.add(newS);
                            if(endWord.equals(newS)) return level+1;
                        }
                    }
                }
            }
            reached=reachedNext;
            level++;
        }
        return 0;
    }

    /**
     * KEYPOINTS:
     * <p>
     *    my backtrace soultion to find all the solutions transform for it but time exceed.
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
    int ans = Integer.MAX_VALUE;
    String begin;
    String end;
    List<String> wordList;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> com = new ArrayList<>(); //这个其实不用，只让我们求最小，不需要保存各种转化
        List<String> chosen = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for (String s : wordList) {
            if (s.equals(beginWord) || s.equals(endWord)) {
                visited.add(s);
            }
        }
        if (!visited.contains(endWord)) {
            return 0;
        }
        this.begin = beginWord;
        this.end = endWord;
        this.wordList = wordList;
        chosen.add(beginWord);
        utils(beginWord, chosen, visited, com);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public void utils(String word, List<String> chosen, HashSet<String> visited, List<List<String>> com) {
        if (getResult(word)) {
            List<String> item = new ArrayList<>(chosen);
            item.add(end);
            com.add(item);
            ans = Math.min(ans, item.size());
            return;
        }

        ArrayList<String> tmp = similar(word, visited);
        if (tmp.size() == 0) {
            return;
        }

        for (String s : tmp) {
            if (!visited.contains(s)) {
                chosen.add(s);
                visited.add(s);
                utils(s, chosen, visited, com);
                chosen.remove(chosen.size() - 1);
                visited.remove(s);
            }

        }


    }

    public ArrayList<String> similar(String word, HashSet<String> visited) {
        ArrayList<String> r = new ArrayList<>();
        for (String s : wordList) {
            if (!visited.contains(s)) {
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == word.charAt(i)) {
                        count++;
                    }
                }
                if (count == s.length() - 1) {
                    r.add(s);
                }
            }
        }
        return r;
    }

    public boolean getResult(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == end.charAt(i)) {
                count++;
            }
        }
        if (count == end.length() - 1) {
            return true;
        }
        return false;

    }


    public static void main(String[] ag) {
        WordLadder127M test = new WordLadder127M();

        test.ladderLength("hit", "cog",
                Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log"}));

    }
}
