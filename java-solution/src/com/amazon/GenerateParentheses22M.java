package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email menogenfong@gmail.com. Date on 11/6/18
 * Talk is Cheap,Show me the Code.
 **/
public class GenerateParentheses22M {
    /**
     * KEYPOINTS:
     * <p>
     *
     * </p>
     * PSEUDOCODE:
     * <pre>
     *  <code>
     *
     * </code>
     * </pre>
     * TIME COMPLEXITY:Catalan number,Central binomial coefficient. O(n^4/sqrt(n))
     * <p>
     * SPACE COMPLEXITY:O(n^4/sqrt(n))
     * <p>
    **/
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(ans,0,0,n,"");
        return ans;

    }
    public void backtrace(List<String> ans,int open,int close,int max,String chosen){
        if(chosen.length() == max*2){
            ans.add(chosen);
            return;
        }

        if(open < max){
            backtrace(ans,open+1,close,max,chosen+"(");
        }

        if(close < open){
            backtrace(ans,open,close+1,max,chosen+")");
        }

    }
}
