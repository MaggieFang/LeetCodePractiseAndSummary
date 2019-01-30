package com.mianjing.fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/19/18
 * Talk is Cheap,Show me the Code.
 **/
public class AlienDict269 {
    public static String alienOrderWrong(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }

        char[][] ws= new char[words.length][];
        int maxWidth = 0;
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            ws[i]= s.toCharArray();
            maxWidth = Math.max(maxWidth,s.length());
        }

        HashMap<Character,Character> graph = new HashMap<>();

        for(int i = 0; i < maxWidth;i++){
            for(int j = 1; j < ws.length;j++){
                if(ws[j-1].length <= i || ws[j].length <= i){
                    continue;
                }

                char c = ws[j][i];
                char pre = ws[j-1][i];

                if(c == ' ' || pre == ' '){
                    continue;
                }

                if(i == 0 && c != pre){
                    graph.put(pre,c);
                } else  if(i > 0 ){
                    char pre1 = ws[j-1][i-1];
                    char pre2 = ws[j][i-1];
                    if(pre1 == pre2){
                        graph.put(pre,c);

                    }
                }

            }
        }
        char k = ws[0][0];
        StringBuilder sb = new StringBuilder();
        HashSet<Character> visited = new HashSet<>();
        int i = 0;
        while(i < graph.size()){

            if(visited.contains(k)){
                return "";
            }
            sb.append(k);
            visited.add(k);
            k = graph.get(k);
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] a){
//        String[] s = new String[]{"wrt","wrf","er","ett","rftt"};
        String[] s = new String[]{"zy","zx"};
        System.out.println(alienOrderWrong(s));

    }
}
