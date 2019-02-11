package com.mianjing.kuola;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-10
 * Talk is cheap,show me the Code.
 **/
public class PrintFormat {
    /**
     * input：s, w
     * s = [
     * ["123434", "1234567", "01234"],
     * ["012", "34556", "01"],
     * ["345", "1234567", "01234"],
     * ]
     * -baidu 1point3acres
     * w代表打出table的col的width.
     * w = [3,7,3]
     * output:
     * w[0], w[1],w[2] ==>每个col的length
     * 123|1234567|012
     * 434|       |34
     * 012|34556  |01
     * 345|1234567|012
     *    |        |34
     */
    public void printFormat(String[][] ss, int[] w) {
        for (String[] s : ss) {
            int[] idx = new int[s.length];
            while (true) {
                for (int i = 0; i < w.length; i++) {
                    String format = "|%-" + w[i] + "s";
                    if (idx[i] < s[i].length()) {
                        System.out.printf(format, s[i].substring(idx[i], idx[i] + w[i] > s[i].length() ? s[i].length() : idx[i] + w[i]));
                        idx[i] += w[i];
                    } else {
                        System.out.printf(format, " ");
                    }
                }
                System.out.println();
                if (checkDone(s, idx)) {
                    break;
                }
            }

        }
    }

    public boolean checkDone(String[] str, int[] idx) {
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > idx[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String[][] s = new String[][]{{"123434", "1234567", "01234"}, {"012", "34556", "01"}, {"345", "1234567", "01234"}};
        int[] w = {3,7,3};
        PrintFormat f = new PrintFormat();
        f.printFormat(s,w);
    }
}
