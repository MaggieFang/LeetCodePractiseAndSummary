package com.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/6/19
 * Talk is Cheap,Show me the Code.
 **/
public class StrobogrammaticNumber246E {


    public boolean isStrobogrammatic1(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('9', '6');
        map.put('6', '9');

        int i = 0, j = num.length() - 1;
        while (i <= j) {
            char l = num.charAt(i);
            char r = num.charAt(j);
            if (!map.containsKey(l)) return false;
            if (map.get(l) != r) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isStrobogrammatic(String num) {
        final HashSet<String> SET = new HashSet<>(Arrays.asList("0", "1", "8", "00", "11", "88", "96", "69"));
        if (num == null || num.length() == 0) {
            return true;
        }

        int i = 0, j = num.length() - 1;
        while (i <= j) {
            if (!SET.contains(num.charAt(i) + "" + num.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    private static final HashSet<Character> SET = new HashSet<>(Arrays.asList('0', '1', '8', '9', '6'));

    public boolean isStrobogrammatic2(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }

        int i = 0, j = num.length() - 1;
        while (i <= j) {
            char l = num.charAt(i);
            char r = num.charAt(j);
            if (!SET.contains(l) || !SET.contains(r)) {
                return false;
            }

            if (l != r && (l != '6' && r != '6')) {
                return false;
            }
            if (l == r && (l == '6' || r == '6' || l == '9' || r == '9')) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
