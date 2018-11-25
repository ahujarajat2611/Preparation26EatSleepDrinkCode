package DSA.Arrays2;

/**
 * Created by hadoop on 21/2/18.
 */
import DSA.nodes.NestedInteger;

import java.util.*;
public class NestedWeightList2 {
    private HashMap<Integer, List<Integer>> hm = new HashMap<>();
    private int maxLevel = Integer.MIN_VALUE;
    public int depthSumInverse(List<NestedInteger> nestedList) {

        int sum = 0;
        dfs(nestedList, 1);
        for (int level : hm.keySet()) {
            // System.out.println("level: " + level);
            for (int num : hm.get(level)) {
                // System.out.println("num -> " + num);
                sum += (num * (maxLevel-level+1));
            }
        }
        return sum;
    }

    private void dfs(List<NestedInteger> nestedList, int level) {
        if (nestedList == null) return;

        maxLevel = Math.max(maxLevel, level);
        if (!hm.containsKey(level)) {
            hm.put(level, new ArrayList<Integer>());
        }

        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                hm.get(level).add(ni.getInteger());
            } else {
                dfs(ni.getList(), level+1);
            }
        }

    }
}
