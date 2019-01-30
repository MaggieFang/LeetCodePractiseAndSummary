package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 1/2/19
 * Talk is Cheap,Show me the Code.
 **/
public class FizzBuzz412E {
    static final String for35 = "FizzBuzz";
    static final String for3 = "Fizz";
    static final String for5 = "Buzz";

    public List<String> fizzBuzz(int n) {


        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n;i++){
            if(i % 3 == 0 && i % 5 == 0){
                ans.add(for35);
            }else if(i % 3 == 0){
                ans.add(for3);
            }else if(i % 5 == 0){
                ans.add(for5);
            }else{
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
