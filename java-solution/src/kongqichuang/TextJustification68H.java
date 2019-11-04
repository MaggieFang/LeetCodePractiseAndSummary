package kongqichuang;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-04
 **/
public class TextJustification68H {
    public static void main(String[] args){
        TextJustification68H t = new TextJustification68H();
        t.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},20);
    }
    public List<String> fullJustify(String[] words, int maxW) {
        List<String> res = new ArrayList<>();
        int left = 0;
        while (left < words.length) {
            int right = findRight(words, left, maxW);
            res.add(padding(left, right, words, maxW));
            left = right + 1;
        }
        return res;

    }

    private String padResult(String s, int maxW) {
        return s + padBlank(maxW - s.length());
    }

    private String padding(int left, int right, String[] words, int maxW) {
        if (left == right) {
            return padResult(words[left], maxW);
        }
        int len = charCount(left, right, words);
        int totalBlank = maxW - len;
        int seprateCnt = right == words.length - 1 ? 1 : totalBlank / (right - left);
        int remain = right == words.length - 1 ? 0 : totalBlank % (right - left);
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            sb.append(words[left]);
            for (int i = 0; left < right && i < seprateCnt; i++) {
                sb.append(" ");
            }

            if (remain > 0) {
                sb.append(" ");
                remain--;
            }

            left++;
        }

        return padResult(sb.toString(), maxW);

    }

    private String padBlank(int count) {
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
            sb.append(" ");
            count--;
        }
        return sb.toString();
    }

    private int charCount(int left, int right, String[] words) {
        int sum = 0;
        while (left <= right) {
            sum += words[left++].length();
        }
        return sum;
    }

    private int findRight(String[] words, int left, int maxW) {
        int sum = words[left++].length();
        while (left < words.length && words[left].length() + sum < maxW) {
            sum++;
            sum += words[left++].length();
        }
        return left - 1;
    }
}
