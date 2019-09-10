package com.appfolio;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-24
 **/
public class PasswordGenerator {
//    /**
//     * Clarification:
//     * wordlist ask: can they be used duplicatedly
//     * </p>
//     * Keypoints:
//     * random pick a letter from a-z
//     * Random rnd = new Random();
//     * char c = (char) (rnd.nextInt(26) + 'a');
//     * </p>
//     * TIME COMPLEXITY:
//     * SPACE COMPLEXITY:
//     *
//     * </p>
//     **/
//    private static void passwordGenerate() {
//        Random random = new Random();
//        char[] base = {'0', 'A', 'a'};
//        char[] count = {9, 26, 26};
//        int brnd = random.nextInt(3);
//        char c = (char) (random.nextInt(count[brnd]) + base[brnd]);
//        System.out.println(c);
//    }
//
//  显示纯大写 然后大小写混合 然后再加上数字 要求几率相等 ，字母+数字，总的m+n位
    private static String generate8BitLetter(int bit) {
        String content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < bit; i++) {
            sb.append(content.charAt(random.nextInt(content.length())));
        }
        return sb.toString();
    }

    private static String generatemnLetterNumber(int m, int n) {
        String content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int letterCount = 0;
        int digitalCount = 0;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            int index;
            if (digitalCount >=n) {
                index = random.nextInt(52);
            } else if (letterCount >= m) {
                index = 52 + random.nextInt(10);
            } else {
                index = random.nextInt(content.length());
            }
            char c = content.charAt(index);
            sb.append(c);
            if (Character.isLetter(c)) {
                letterCount++;
            } else {
                digitalCount++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generatemnLetterNumber(4,4));
        System.out.println(generate8BitLetter(0));
        System.out.println(generate8BitLetter(8));
    }
}
