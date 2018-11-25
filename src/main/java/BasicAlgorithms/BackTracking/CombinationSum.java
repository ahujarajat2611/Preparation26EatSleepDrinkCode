package BasicAlgorithms.BackTracking;

import java.util.*;
/*
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] 
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
        	return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(0);
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<Integer>(), new int[1], res);
        return res;
    }
	private static void helper(int[] candidates, int target, int pos, List<Integer> item, int[] value, List<List<Integer>> res) {
		if (value[0] == target) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		if (value[0] > target) {
			return;
		}
		for (int i = pos; i < candidates.length; i++) {
			item.add(candidates[i]);
			value[0] += candidates[i];
			helper(candidates, target, i, item, value, res);
			item.remove(item.size()-1);
			value[0] -= candidates[i];
		}
	}
}
