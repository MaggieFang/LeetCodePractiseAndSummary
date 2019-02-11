package com.mianjing.gou;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by Maggie Fang. Email maggie2fang@gmail.com. Date on 2019-02-11
 * Talk is cheap,show me the Code.
 **/
public class BuildListDifference2Power {
    public List<List<Integer>> build(int n) {
        List<Integer> backUp = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            backUp.add(i);
            i <<= 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int start = 0; start <= n; start++) {
            combind(new ArrayList<>(), start, ans, backUp, n);
        }
        return ans;

    }

    public void combind(List<Integer> pre, int start, List<List<Integer>> ans, List<Integer> backUp, int n) {
        pre.add(start);
        if (pre.size() > 0) {
            System.out.println(pre);
            ans.add(new ArrayList<>(pre));
        }
        for (int choice : backUp) {
            if (start + choice <= n) {
                combind(pre, start + choice, ans, backUp, n);
                pre.remove(pre.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        BuildListDifference2Power t = new BuildListDifference2Power();
        t.build(3);
    }
}
