package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/16/18
 * Talk is Cheap,Show me the Code.
 **/
public class MinWindownSubString76 {
    /**
     * KEYPOINTS:
     * <p>
     *     Q 1) strictly match or can be case igoro? NO
     *     2) any limitation of the input? all the ascii character can included? (256) YES
     *     3) "ABC" and "AABC" can say ABC covers all the AABC? NO
     * 1- First check if length of string is less than the length of given pattern,
     * if yes,then "no such window can exist ".
     * 2- Store the occurrence of characters of given pattern in a hash_pat[].
     * 3- Start matching the characters of pattern with the characters of string i.e. increment count
     * if a character matches
     * 4- Check if (count == length of pattern ) this means a window is found
     * 5- If such window found, try to minimize it by removing extra characters from beginning of current window.
     * 6- Update min_length.
     * 7- Print the minimum length window.
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
    static final int no_of_chars = 256;

    // Function to find smallest window containing
    // all characters of 'pat'
    public String findSubString(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();

        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        // store occurrence ofs characters of pattern
        for (int i = 0; i < len2; i++)
            hash_pat[pat.charAt(i)]++;

        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;

        // start traversing the string
        int count = 0;  // count of characters
        for (int j = 0; j < len1; j++) {
            // count occurrence of characters of string
            hash_str[str.charAt(j)]++;

            // If string's char matches with pattern's char
            // then increment count
            if (hash_pat[str.charAt(j)] != 0 &&
                    hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
                count++;

            // if all the characters are matched
            if (count == len2) {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
                    hash_str[str.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting from start_index
        // and length min_len
        return str.substring(start_index, start_index + min_len);
    }

    public static void main(String[] args) {
        MinWindownSubString76 test = new MinWindownSubString76();
        System.out.println(test.findSubString("ABAACBAB", "ABC"));
    }
}
