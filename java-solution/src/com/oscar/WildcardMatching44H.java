package com.oscar;

import java.util.regex.Pattern;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class WildcardMatching44H {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int iSave = 0; //!!!
        int starSave = -1; //!!!
        int slen = s.length();
        int plen = p.length();
        while (i < slen) {
            char c = s.charAt(i);
            if (j < plen && (p.charAt(j) == c || p.charAt(j) == '?')) { // equas or ?, move forward both
                i++;
                j++;
            } else if (j < plen && p.charAt(j) == '*') {
                // ignore jth i.e "*" , but we need to save this position, we may need to do the not-ignore latter.
                starSave = j;
                iSave = i;
                j++;
            } else if (starSave != -1) {
                // restore the non-ignore "*",so match the iSave with the "*" and pick up from iSave+1;
                i = iSave + 1;
                j = starSave;
            } else {
                return false;
            }
        }

        while (j < plen) { // don't forget.
            if (p.charAt(j++) != '*') return false;
        }
        return true;

    }

    //exceed time limit
//    public boolean isMatch(String s, String p) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < p.length(); i++){
//            char c = p.charAt(i);
//            if(c == '?'){
//                sb.append(".");
//            }else if(c =='*'){
//                if(i!=0 && p.charAt(i-1) == '*') continue;
//                sb.append("[a-z]*");
//            }else{
//                sb.append(c);
//            }
//        }
//        Pattern pattern = Pattern.compile(sb.toString());
//        return pattern.matcher(s).matches();
//    }

    public static void main(String[] args) {
        WildcardMatching44H t = new WildcardMatching44H();
        System.out.println(t.isMatch("acdcb",
                "a*c?b"));
    }
}
