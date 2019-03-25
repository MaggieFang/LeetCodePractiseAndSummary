package com.fb;

import java.util.LinkedList;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/8/18
 * Talk is Cheap,Show me the Code.
 **/
public class AddAndSearchWord211M {
    //Q : is there any limitation of the count of addwords?
    //duplicate words? for add("va"), add("va") will be two words or just 1?
    // if the string to add is null or ""? will be added?
    /**
     * Initialize your data structure here.
     */
    LinkedList<String> list;

    public AddAndSearchWord211M() {
        list = new LinkedList<>();

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word != null && !list.contains(word)) {
            list.add(word);
        }
    }



    public boolean searchTimeLimitedExceed(String word) {
        if (word == null) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() != word.length()) {
                continue;
            }

            int j = 0;
            for (; j < s.length(); j++) {
                char c1 = s.charAt(j);
                char c2 = word.charAt(j);
                if (c2 != '.' && c1 != c2) {
                    break;
                }
            }
            if (j == s.length()) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] ars){
        AddAndSearchWord211M test = new AddAndSearchWord211M();
        test.addWord("a");
        test.addWord("ab");
//        System.out.println(test.search("a"));
//        System.out.println(test.search("a."));
    }
}
