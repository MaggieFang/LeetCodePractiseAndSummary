package com.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/11/18
 * Talk is Cheap,Show me the Code.
 **/
public class LetterCombination17M {
    public List<String> letterCombinations(String digits) {
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int total = 1;
        for (int i = 0; i < digits.length(); i++) {
            total *= map[digits.charAt(i) - '0'].length();

        }

        StringBuilder[] res = new StringBuilder[total];
        for(int i = 0; i< total;i++){
            res[i] = new StringBuilder();
        }

        for (int i = 0; i < digits.length(); i++) {
            String letters = map[digits.charAt(i) - '0'];
            int size = letters.length();
            int count = 0;
            for (int j = 0; j < total; j++) {
                StringBuilder builder = res[j];
                builder.insert(i, letters.charAt(count % size));
                count++;

            }
        }
        List<String> list = new ArrayList<>();
        for (StringBuilder s : res) {
            list.add(s.toString());
        }
        return list;

    }

    public static void main(String[] args) {
        LetterCombination17M t = new LetterCombination17M();
        System.out.println(t.letterCombinations("23"));
    }
}
