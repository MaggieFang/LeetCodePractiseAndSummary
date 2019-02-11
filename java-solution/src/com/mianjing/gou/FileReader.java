package com.mianjing.gou;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/9/19
 * Talk is Cheap,Show me the Code.
 **/
public class FileReader {
    //适用于一个单词写成一行情况，文件很大的话，就不用set装，每次对br1中都搜br2中一遍，搜到就break出来

    /*** how to read large file. with new enhancements coming to Java IO package,
     *  it is becoming more and more efficient.BufferReader, I tried read 1GB, max memory used id 258MB, and time take 100sec.
     *  Java 8 Stream. Scanner(460MB,60sec)
     ***/
    public void deleteCertain(String input, String delete) throws IOException {
        PrintWriter writer = new PrintWriter("out.txt");
        HashSet<String> deleteSet = new HashSet<>();
        BufferedReader br2 = new BufferedReader(new java.io.FileReader(delete));
        String word = br2.readLine();
        while (word != null) {
            deleteSet.add(word);
            word = br2.readLine();
        }

        BufferedReader br1 = new BufferedReader(new java.io.FileReader(input));
        word = br1.readLine();
        while (word != null) {
            if (!deleteSet.contains(word)) {
                writer.println(word);
            }
            word = br1.readLine();
        }
        writer.flush();
        br1.close();
        br2.close();
    }

    /**
     * KEYPOINTS:
     * <p>
     * There are several ways to read a plain text file in Java e.g. you can use FileReader, BufferedReader
     * or Scanner to read a text file. Every utility provides something special
     * e.g. BufferedReader provides buffering of data for fast reading, and Scanner provides parsing ability.
     * As to the choice, use the Scanner if you want to parse the file,
     * use the BufferedReader if you want to read the file line by line.
     * Parsing = interpreting the given input as tokens (parts). It's able to give back you specific parts directly
     * as int, string, decimal, etc. See also all those nextXxx() methods in Scanner class.
     * <p>
     * Reading = dumb streaming. It keeps giving back you all characters, which you in turn have to manually
     * inspect if you'd like to match or compose something useful. But if you don't need to do that anyway,
     * then reading is sufficient.
     * </p>
     * TIME COMPLEXITY:
     * <p>
     * SPACE COMPLEXITY:
     * <p>
     **/
    public void compar(String s1) throws IOException {
        File f1 = new File(s1);
        Scanner scanner = new Scanner(f1);
        int cout = 0;
        while (scanner.hasNext()) {
            String w = scanner.next();
            cout++;
        }
    }
}
