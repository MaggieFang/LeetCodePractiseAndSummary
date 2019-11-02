package kongqichuang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Author by Maggie Fang <maggie2fang@gmail.com>. Date on 2019-11-02
 **/
public class GroupId {
    /**
     * Clarification:

     * input: 1,2,3,4,1,5,1,2,3,1,3 ; page size : 5
     * output:
     * 1,2,3,4,5 / 1,2,3,1,1 / 3
     * </p>
     * Keypoints:
     *
     * </p>
     * TIME COMPLEXITY:
     * SPACE COMPLEXITY:
     * </p>
     **/
    public List<String> displayPages(List<String> input, int pageSize) {
        List<String> res = new ArrayList<>();
        Iterator<String> ite = input.iterator();
        HashSet<String> visited = new HashSet<>();
        boolean reachEnd = false;
        while (ite.hasNext()) {
            String cur = ite.next();
            String hostId = cur.split(" ", 2)[0];
            if (!visited.contains(hostId) || reachEnd) {
                res.add(cur);
                visited.add(hostId);
                ite.remove(); // !!! important
            }

            if (pageSize == visited.size()) {
                res.add("\\");
                visited.clear();
                ite = input.iterator();
                reachEnd = false;
            }

            if (!ite.hasNext()) {
                reachEnd = true;
                ite = input.iterator();
            }
        }

    }
}
