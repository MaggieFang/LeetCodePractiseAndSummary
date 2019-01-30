package com.oscar;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/21/19
 * Talk is Cheap,Show me the Code.
 **/
public class RomantoInteger12M {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"}; //千位 1000,2000,3000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//百位 100,200,..900
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//十位 10,20,30,...90
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//个位 1-9
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

}
