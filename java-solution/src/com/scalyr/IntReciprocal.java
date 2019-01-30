package com.scalyr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/17/18
 * Talk is Cheap,Show me the Code.
 **/
public class IntReciprocal {
    public static void reciprocal(int N) {
        // Write your code here
        List<Integer> factor = new ArrayList<>(); // store quotient digits when doing dividing
        List<Integer> remain = new ArrayList<>(); // store the pre dividend when doing dividing
        int dd = 1; // dividend
        int repeatIndex; // index begin recur.

        while(true){
            factor.add(dd/N); // add current quotient digit to list.
            remain.add(dd);   // store the pre dividend to remain list.
            dd = (dd % N)*10; // the dividend for next dividing.
            if(dd == 0){   // divisible, so the end digit is 0.
                repeatIndex = 0;
                factor.add(0);
                break;
            }

            int i = remain.indexOf(dd);
            if (i != -1){ // the next dividend already in remain list. So we know recur begin.
                repeatIndex = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder("0.");
        //append the quotient
        for(int i = 1; i < factor.size();i++){
            sb.append(factor.get(i));
        }

        //append the repeat part.
        sb.append(" ");
        if(repeatIndex == 0){  //divisible condition
            sb.append("0");
        }else{ // recur condition
            for(int i = repeatIndex; i < remain.size();i++){
                sb.append(factor.get(i));
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args){
        double i = 1/8d;
        double i2 = 1/6d;
        double i3 = 1/9d;
        double i4 = 1/3d;
        double i5 = 1/10d;
        double i6 = 1/11d;
        double i7 = 1/99d;
        double i8 = 1/202d;


    }
}
