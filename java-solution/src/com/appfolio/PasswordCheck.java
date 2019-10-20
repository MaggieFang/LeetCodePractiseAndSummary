package com.appfolio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-23
 **/
public class PasswordCheck {

    /**
     * Clarification:
     *  Regular expression is based on finite state machine.
     *  Running a DFA-compiled regular expression against a string is indeed O(n),
     *  but can require up to O(2^m) construction time/space (where m = regular expression size).
     *  but please note, when performing a partial match on a string, you need roughly m*n steps,
     *  because if the regex engine can't match the pattern in the first character, it must try again starting with a 2nd, 3rd character
     *  and so on until it finds a matching sequence
     * </p>
     * Keypoints:
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public static boolean onlyLetters(String str) {

        Pattern letter = Pattern.compile("[a-zA-Z]+"); //"[a-zA-Z]" matches only one character. To match multiple characters, use "[a-zA-Z]+".
        return letter.matcher(str).matches();//matches only succeeds if it matches the entire string
//        return str != null && !str.trim().isEmpty() && str.trim().matches("^[a-zA-Z]*$");
    }

    public static boolean overall(String password) {
        Pattern letter = Pattern.compile("[a-zA-Z]+");
        Pattern digital = Pattern.compile("[0-9]+");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]+");

        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digital.matcher(password);
        Matcher hasSpecial = special.matcher(password);
        return hasLetter.find() && hasDigit.find() && hasSpecial.find();//Attempts to find the next subsequence of the input sequence that matches the pattern.
    }

    public static boolean notAllDigitalLetter(String str) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        return pattern.matcher(str).find();
    }

    //https://www.1point3acres.com/bbs/interview/coursera-software-engineer-520816.html
    public static boolean matched(String s, String p){
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).find();
    }


    public static void main(String[] args) {
        System.out.println(matched("oa","[a-z]*"));
        System.out.println(matched("hello","ll"));
        System.out.println(matched("hello","e"));
        System.out.println(matched("hello","eo"));
        System.out.println(matched("hello","e."));


        System.out.println('a' - 'A');
        System.out.println(notAllDigitalLetter("12gvs"));
        System.out.println(notAllDigitalLetter(")&^$#"));
        System.out.println(notAllDigitalLetter("gvs#"));
        System.out.println(notAllDigitalLetter("24gvs#"));
        System.out.println(overall("dfasf"));
        System.out.println(overall("34t2342231d"));
        System.out.println(overall("234"));
        System.out.println(overall("wsdfvn&rbf"));
        System.out.println(overall("234f&rbf"));
        Pattern letter = Pattern.compile("[0-9]+");
        System.out.println(letter.matcher("-").find());
        System.out.println(letter.matcher("23").find());
        System.out.println(letter.matcher("-23").find());
        System.out.println(Integer.parseInt("-23"));

    }
}
