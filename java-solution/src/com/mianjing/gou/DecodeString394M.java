package com.mianjing.gou;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/15/19
 * Talk is Cheap,Show me the Code.
 **/
public class DecodeString394M {
    /**
     * KEYPOINTS:
     * <p>
     * every time when you meet a number,indicate num, it must be followed by [...],
     * we just need to recursively call our method to decode "..." and gets sub result,
     * then repeat the sub result "num" times.
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                i++;
                while (i < n && s.charAt(i) != '[') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i++;
                int start = i;
                int cnt = 1;
                while (cnt != 0) {
                    if (s.charAt(i) == '[') cnt++;
                    else if (s.charAt(i) == ']') cnt--;
                    i++;
                }
                --i;
                int end = i;
                String sub = decodeString(s.substring(start, end));
                for (int k = 0; k < num; k++) {
                    sb.append(sub);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();

    }

}
