package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/5/18
 * Talk is Cheap,Show me the Code.
 **/
public class WordLadder126H {


    /**
     * KEYPOINTS:
     * <p>
     *    time exceed.
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
    String begin;
    String end;
    List<String> wordList;
    int size = Integer.MAX_VALUE;
    //Time exceed
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> com = new LinkedList<>(); //这个其实不用，只让我们求最小，不需要保存各种转化
        List<String> chosen = new ArrayList<>();
        HashSet<String> visited = new HashSet<>();
        for (String s : wordList) {
            if (s.equals(beginWord) || s.equals(endWord)) {
                visited.add(s);
            }
        }
        if (!visited.contains(endWord)) {
            return com;
        }
        this.begin = beginWord;
        this.end = endWord;
        this.wordList = wordList;
        chosen.add(beginWord);
        utils(beginWord, chosen, visited, com);

        List<List<String>> ans = new ArrayList<>();
        for(int i = com.size()- 1 ; i >= 0; i--){
            List<String> item = com.get(i);
            if(item.size() > size){
                break;
            }
            ans.add(item);
        }
        return ans;
    }

    public void utils(String word, List<String> chosen, HashSet<String> visited, List<List<String>> com) {
        if (getResult(word)) {
            List<String> item = new ArrayList<>(chosen);
            item.add(end);
            if(size >= item.size()){
                com.add(item);
                size = item.size();
            }
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


    public static void main(String[] rags){
        WordLadder126H test = new WordLadder126H();
        test.findLadders("hot", "dog",new ArrayList<String>(Arrays.asList(new String[]{"hot","cog","dog","tot","hog","hop","pot","dot"})));

    }
}
