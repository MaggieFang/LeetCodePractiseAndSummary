package com.google;

import java.util.Arrays;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 12/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class NextClosestTime681M {
    // 20:24 , HH:M_: find the lager or return the minimum. 20:20, continue
    //         HH:_M:  find the larger or the miminum  20:00; continue
    //           HH:MM     22:00 return

    public String nextClosestTime(String time) {
        char[] result = time.toCharArray();
        char[] ds = new char[]{result[0],result[1],result[3],result[4]};

        Arrays.sort(ds);

        result[4] = findNext(result[4],'9',ds);
        if(result[4] > time.charAt(4)){
            return String.valueOf(result);
        }


        result[3] = findNext(result[3],'5',ds);
        if(result[3] > time.charAt(3)){
            return String.valueOf(result);
        }

        result[1] = findNext(result[1],result[0] == '2'? '3':'9',ds);
        return String.valueOf(result);

    }


    public char findNext(char cur,char upper,char[] ds){
        //0 .2 2 4
        if(cur == upper){
            return ds[0];
        }

        char r = ds[0]; // if not found, return the minimum;
        int i = ds.length -1;
        while(i >= 0){
            if(ds[i] <= upper && ds[i] > cur){
                r = ds[i];
            }
            i--;
        }

        return r;
    }
    public static void main(String[] args){
        NextClosestTime681M test = new NextClosestTime681M();
        test.nextClosestTime("19:34");
    }

}
