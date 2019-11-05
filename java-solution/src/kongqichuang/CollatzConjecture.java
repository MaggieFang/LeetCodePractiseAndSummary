package kongqichuang;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.HashMap;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-05
 **/
public class CollatzConjecture {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int findLongestSteps(int num) {
        if (num < 1) return 0;
        int res = 0;

        for (int i = 0; i <= num; i++) {
            int step = findStep(i);
            map.put(i,step);
            res = Math.max(res,step);
        }
        return res;
    }

    // In fact, I consider if it is better to put the compute result to map in this method is better?
    public int findStep(int i) {
        if (i <= 1) return 1;
        if (map.containsKey(i)) return map.get(i);
        if (i % 2 == 0) {
            return findStep(i / 2) + 1;
        }
        return 1 + findStep(3 * i + 1);
    }
}
