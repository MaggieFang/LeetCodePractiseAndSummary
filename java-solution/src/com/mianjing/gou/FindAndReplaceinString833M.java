package com.mianjing.gou;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class FindAndReplaceinString833M {
    /**
     * Time Complexity: O(NQ), where N is the length of S, and we have Qreplacement operations.
     * (Our complexity could be faster with a more accurate implementation, but it isn't necessary.)
     * <p>    * Space Complexity: O(N), if we consider targets[i].length <= 100 as a constant bound
     **/
    public String findReplaceString(String S, int[] idxs, String[] sources, String[] target) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);
        for (int i = 0; i < idxs.length; i++) {
            int id = idxs[i];
            if (S.substring(id, id + sources[i].length()).equals(sources[i])) {
                match[id] = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < N) {
            if (match[i] != -1) {
                ans.append(target[match[i]]);
                i += sources[match[i]].length();
            } else {
                ans.append(S.charAt(i++));
            }
        }
        return ans.toString();
    }

    public String findReplaceString2(String S, int[] idxs, String[] sources, String[] target) {
        StringBuilder sb = new StringBuilder(S);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < idxs.length; i++) {
            map.put(idxs[i],i);
        }

        for(Integer key: map.descendingKeySet()){ // from end, we needn't compute the new index in the sb
            int id = map.get(key);
            if(S.substring(key).startsWith(sources[id])){//保证从开始的index去找source,即使有重复也不怕了
                sb.replace(key,key+sources[id].length(),target[id]);
            }
        }
        return sb.toString();
    }


    //It is wrong, when begin replace from the begining. after you replace, it may consist some prefix that fit for latter ones.
    public String findReplaceStringWrong(String S, int[] idxs, String[] sources, String[] target) {
        StringBuilder sb = new StringBuilder(S);
        String s;
        for (int i = 0; i < sources.length; i++) {
            s = sources[i];
            int start = idxs[i];
            String sub = S.substring(start, s.length() + start);
            if (sub.equals(sources[i])) {
                int r = sb.indexOf(sub);
                System.out.println(r + ", " + sb);
                sb.replace(r, r + sub.length(), target[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FindAndReplaceinString833M test = new FindAndReplaceinString833M();
        test.findReplaceStringWrong(
                "ejvzndtzncrelhedwlwiqgdbdgctgubzczgtovufncicjlwsmfdcrqeaghuevyexqdhffikvecuazrelofjmyjjznnjdkimbklrh"
                , new int[]{25, 35, 60, 77, 69, 79, 15, 19, 58, 92, 27, 64, 4, 11, 51, 7, 72, 67, 30, 0, 74, 98, 17, 85, 48, 32, 38, 62, 43, 2, 9, 55, 87}
                , new String[]{"gc", "tov", "vy", "re", "ikv", "lo", "dw", "iqgdbd", "ue", "kimbk", "tgu", "qd", "ndt", "elhe", "crq", "zn", "ec", "ff", "bz", "ej", "ua", "rh", "lw", "jj", "mfd", "cz", "ufn", "ex", "cjl", "vz", "cr", "agh", "znnj"}
                , new String[]{"dxs", "hn", "vfc", "wnr", "tira", "rko", "oob", "mlitiwj", "zrj", "onpp", "ot", "c", "lm", "hbsje", "dgc", "ruf", "qi", "h", "vzn", "ja", "ow", "te", "km", "imq", "pia", "ixp", "xsod", "m", "eat", "yf", "lzu", "dgy", "dyrsc"}
        );
    }
}
