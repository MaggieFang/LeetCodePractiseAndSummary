package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/21/18
 * Talk is Cheap,Show me the Code.
 **/
public class EnglishToNew {
    /**
     * KEYPOINTS:
     * <p>
     * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=451101&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
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
    public static String toNew(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = 0; i < ss.length; i++) {
            StringBuilder sb = new StringBuilder(ss[i]);
            if(i > 0){
                sb.append(' ');
            }
            char first = sb.charAt(0);
            if (!isVowel(first)){
                sb.setCharAt(0,sb.charAt(sb.length()-1));
                sb.setCharAt(sb.length()-1,first);
                sb.append("ma");

            }else {
                sb.append("ma");
            }
            for(int j = 0; j <= i; j++){
                sb.append('a');
            }
            res.append(sb);
        }

        return res.toString();
    }
    public static void main(String[] a){
        System.out.println(toNew("I speak Goat Latin"));
    }

    public static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'A':
            case 'E':
            case 'e':
            case 'I':
            case 'i':
            case 'o':
            case 'O':
            case 'U':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
