package com.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-09-25
 **/
public class GuesstheWord843M {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * since we only have 10 chance to guess it otherwise we will fail. so for wordlist size > 10, we cannot travel them all.
     * so random selected. and since each time, guess() will return the number of char matched. we can used them to eliminate the elements
     * not matched with this number.
     * so define a match(String s1,String s2) to return to count of the numbers of characters two strings matched.
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public void findSecretWord(String[] wordlist, Master master) {
        Random rdm = new Random();
        for (int i = 0, gus = 0; i < 10 && gus < 6; i++) {
            int index = rdm.nextInt(wordlist.length);
            String t = wordlist[index];
            gus = master.guess(t);
            List<String> tmp = new ArrayList<>();
            for (String s : wordlist) {
                if (!t.equals(s) && match(t, s) == gus) {
                    tmp.add(s);
                }
            }
            wordlist = tmp.toArray(new String[tmp.size()]);// should write it in this way
        }


    }

    private int match(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    interface Master {
        public int guess(String word);
    }
}
