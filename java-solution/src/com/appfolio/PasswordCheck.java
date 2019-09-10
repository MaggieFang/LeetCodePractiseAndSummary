package com.appfolio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-08-23
 **/
public class PasswordCheck {

    public static boolean onlyLetters(String str) {

        Pattern letter = Pattern.compile("[a-zA-Z]+"); //"[a-zA-Z]" matches only one character. To match multiple characters, use "[a-zA-Z]+".
        return letter.matcher(str).matches();
//        return str != null && !str.trim().isEmpty() && str.trim().matches("^[a-zA-Z]*$");
    }

    public static boolean overall(String password) {
        Pattern letter = Pattern.compile("[a-zA-Z]+");
        Pattern digital = Pattern.compile("[0-9]+");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]+");

        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digital.matcher(password);
        Matcher hasSpecial = special.matcher(password);
        return hasLetter.find() && hasDigit.find() && hasSpecial.find();
    }

    public static boolean notAllDigitalLetter(String str){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        return pattern.matcher(str).find();
    }



    public static void main(String[] args) {
        System.out.println('a'-'A');
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
