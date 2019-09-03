package com.mianjing.fb;

import java.util.ArrayList;
import java.util.Random;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class ReadFromFile158 {
    /**
     * Clarification:
     *
     * </p>
     * Keypoints:
     * the difference between LC 157 is this one can do the multiple read.
     * e.g file = "abc, it can call read(buf,1) then we return "a", then we call read(buf,2) then we return "bc",
     * but notice that the first time read(buf,1),we use read4 has read "abc" all out. so in read(buf,2), we need to use the
     * unretrieved read4 first. so we can know, we need to store the global buf4 and the size of read4 and the last time index of we get from read4.
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    char[] buf4 = new char[4];
    int j = 0;
    int size = 0;

    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            while (i < n && j < size) {
                buf[i++] = buf4[j++];
            }
            if (i >= n) break;
            j = 0;
            size = read4(buf4);
            if (size == 0)
                break; // don't forget. otherwise, it never stop in some case. e.g file "abc", read(buf,1),read(buf,2),read(buf,1)
        }
        return i;
    }

    private int read4(char[] buffer) {
        return new Random().nextInt(4);
    }

    /**
     * KEYPOINTS:
     * <p>
     * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=450202&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3088%5D%5Bvalue%5D%3D1%26searchoption%5B3088%5D%5Btype%5D%3Dradio%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
     * 我有一个size为k的char array，一个write pointer和一个read pointer，
     * write pointer指向char array中第一个要写的位置，read pointer指向char array中第一个要读的位置。
     * 每回读或者写的时候pointer++，到达尾部的时候再回开头。
     * 不过我还加了个int size，表明这个char array中现在有多少是可以读的char。
     *
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
    private final int N = 5;// buffer的长度
    private char[] buf = new char[N];
    private int rp = 0, wp = 0; // write point,read pointer
    private int countCanRead = 0;

    public int readM(int n) {
        ArrayList<Character> list = new ArrayList<>();
        int i = 0;
        for (; i < n; i++) {
            if (countCanRead > 0) {
                list.add(buf[rp % N]);
                rp++;
                countCanRead--;
            } else {
                break;
            }
        }
        System.out.println("size= " + list.size() + ",list=" + list);
        return i;

    }

    public int writeM(char[] b) {
        int i = 0;
        for (; i < b.length; i++) {
            if (N - countCanRead > 0) {
                buf[wp % N] = b[i];
                wp++;
                countCanRead++;
            } else {
                break;
            }
        }
        return i;

    }

    public static void main(String[] a) {
        ReadFromFile158 test = new ReadFromFile158();
        System.out.println(test.writeM(new char[]{'a', 'b', 'c'}));
        System.out.println(test.writeM(new char[]{'d', 'e', 'f'}));
        System.out.println(test.readM(3));
        System.out.println(test.writeM(new char[]{'x', 'y', 'z', 'a', 'b', 'c'}));

        System.out.println(test.readM(8));
    }

}
