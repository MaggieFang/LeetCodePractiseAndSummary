package com.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/8/18
 * Talk is Cheap,Show me the Code.
 **/
public class ValidPalindromeII680E {
    public boolean validPalindrome(String s) {
        boolean hasDelete = false;
        int low = 0;
        int hi = s.length() - 1;
        while (low < hi) {
            char left = s.charAt(low);
            char right = s.charAt(hi);
            if (left == right) {
                low++;
                hi--;
            } else if (hasDelete) {
                return false;
            } else {
                //"aabacabaaa" 这种情况会误判！
                char tmp = s.charAt(low + 1);
                char tmp2 = s.charAt(hi - 1);
                if (tmp == right) {
                    hasDelete = true;
                    low++;
                } else if (tmp2 == left) {
                    hasDelete = true;
                    hi--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * KEYPOINTS:
     * <p>
     * If the beginning and end characters of a string are the same (ie. s[0] == s[s.length - 1]),
     * then whether the inner characters are a palindrome (s[1], s[2], ..., s[s.length - 2])
     * uniquely determines whether the entire string is a palindrome.
     * Suppose we travel to s[l] and s[r] and they are not equal,
     * we had to check s[l,...., r-1]  or s[l+1,...r] is palindrome. both cases should be checked.
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
    public boolean validPalindromeGreedy(String s) {
        int low = 0;
        int hi = s.length() - 1;
        while (low < hi){
            if(s.charAt(low) == s.charAt(hi)){
                low++;
                hi--;
            }else {
                return isPalindrome(s,low+1,hi) || isPalindrome(s,low,hi-1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }


}
