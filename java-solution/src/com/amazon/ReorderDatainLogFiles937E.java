package com.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-10-28
 **/
public class ReorderDatainLogFiles937E {
    /**
     * Clarification:
     *1. string.split(" ", 2); will divided into 2 parts with the first regex found.
     *
     * </p>
     * Keypoints:
     * A good example to write a cusomtomized sort compare for Arrays.
     * But if we split the list into digitList and letter list, we could only sort the letter list part. performance better.
     * </p>
     * TIME COMPLEXITY: O(AlogA) A is the total content of the string
     * SPACE COMPLEXITY:O(A)
     * </p>
     **/
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] sp1 = log1.split(" ", 2);
            String[] sp2 = log2.split(" ", 2);
            boolean d1 = Character.isDigit(sp1[1].charAt(0));
            boolean d2 = Character.isDigit(sp2[1].charAt(0));
            if (d1 && d2) return 0;
            if (d1 && !d2) return 1;
            if (!d1 && d2) return -1;
            int c = sp1[1].compareTo(sp2[1]);
            if (c != 0) return c;
            return sp1[0].compareTo(sp2[0]);
        });
        return logs;
    }

    public String[] reorderLogFiles2(String[] logs) {
        if(logs == null || logs.length == 0) return logs;
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();
        for(String s: logs){
            if(Character.isDigit(s.split(" ",2)[1].charAt(0))){
                digitList.add(s);
            }else{
                letterList.add(s);
            }
        }
        Collections.sort(letterList,(log1, log2) ->{
            String[] sp1 = log1.split(" ",2);
            String[] sp2 = log2.split(" ",2);
            int c = sp1[1].compareTo(sp2[1]);
            if(c != 0) return c;
            return sp1[0].compareTo(sp2[0]);
        });
        int i = 0;
        while(i < letterList.size()){
            logs[i] = letterList.get(i);
            i++;
        }

        for(int j = 0; j < digitList.size(); j++){
            logs[i+j] = digitList.get(j);
        }

        return logs;
    }
}
