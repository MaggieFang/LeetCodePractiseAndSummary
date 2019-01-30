package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 10/29/18
 * Talk is Cheap,Show me the Code.
 **/
public class PascalTriangleII119E {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0; i<= rowIndex;i++){
            ans.add(1);
            for(int j =i-1; j >= 1;j--){ // we cannot loop from 1 to i-1,e.g. 1 2 1 1. if we from the lower A[1]= 3,A[2]=A[1]+A[2] we will use the A[1] has increased not the pre one.
                ans.set(j,ans.get(j)+ans.get(j-1));
            }
        }
        return ans;
    }
}
