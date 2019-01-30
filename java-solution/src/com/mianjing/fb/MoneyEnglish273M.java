package com.mianjing.fb;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/15/18
 * Talk is Cheap,Show me the Code.
 **/
public class MoneyEnglish273M {
    /**
     * KEYPOINTS:
     * <p>
     *    e.g 11,234,101
     *    we can handle it three digit at one time. From the lowest digital.
     *    and add an weight to indicate if had to add map3's expression.
     *
     *    getEnd() is to handle the three digit. so it is just only hundred, tens  larger thant 20. and the least < 20
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
    private final String[] map1 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] map2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] map3 = {"", " Thousand", " Million", " Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        int weight = 0;
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            int n = num % 1000;
            String s = getEng(n);

            if (s.length() != 0) {
                sb.insert(0, " " + s + map3[weight]);
            }
            weight++;
            num = num / 1000;
        }

        return sb.toString().trim();
    }

    public String getEng(int num) {
        if (num == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        int h = num / 100;
        if (h != 0) {
            sb.append(map1[h] + " " + "Hundred");
        }

        num = num % 100;
        if (num < 20) {
            sb.append(" " + map1[num]);
            return sb.toString().trim();
        }


        int t = num / 10;
        if (t != 0) {
            sb.append(" " + map2[t]);
        }
        num = num % 10;
        if (num != 0) {
            sb.append(" " + map1[num]);
        }

        return sb.toString().trim();
    }
    public static void main(String[] args){
        System.out.println(new MoneyEnglish273M().numberToWords(11110101));
    }
}
