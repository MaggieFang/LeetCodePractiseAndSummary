package com.easy.string;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 9/22/18
 * Talk is Cheap,Show me the Code.
 **/
public class LongestCommonPrefix28 {
    //二刷，simple idea,define a method to find the pre of two string,so find it use str[0]and str[1] to be the new string name ans,
    // and make a traversal from str[2] with asn
    //O(n) n is the total character of all strings
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String ans = commonPre(strs[0],strs[1]);
        int i = 2;
        while(i < strs.length && !"".equals(ans)){
            ans = commonPre(ans,strs[i++]);
        }
        return ans;
    }

    public String commonPre(String s1,String s2){
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j++)){
                sb.append(s1.charAt(i));
                i++;
            }else{
                break;
            }
        }
        return sb.length() == 0? "":sb.toString();
    }

    /**
     * KEYPOINTS:
     * <p>
     * common prefix, it must the the 0 index of every string.
     * So we can compare vertically. the same index of every string.
     * <p>
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY: O(n) n is the total character of all strings
     * <p>
     * SPACE COMPLEXITY: O(1)
     * <p>
     **/
    public String longestCommonPrefixVerticalCompare(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int i = 0;
        for (; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || c != strs[j].charAt(i)) { //do not forget i >= strs[j].length() judgement
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }

    public String longestCommonPrefixHorizonCompare(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            if (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                i = 1;
            }else {
                ++i;
            }
            if(prefix.isEmpty()){
                return "";
            }
        }
        return prefix;
    }
}
