package com.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/11/18
 * Talk is Cheap,Show me the Code.
 **/
public class LetterCombination17M {
    //二刷
    String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations2(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return ans;
        }

        combind(digits,0,"",ans);
        return ans;
    }

    public void combind(String digit,int cur,String pre,List<String> ans){
        if(digit.length() == pre.length()){
            ans.add(pre);
            return;
        }
        if(cur < digit.length()){
            String str = map[digit.charAt(cur) - '0'];
            for(int i = 0; i < str.length(); i++){
                combind(digit,cur+1,pre+str.charAt(i),ans);
            }
        }

    }

    //一刷
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
}
