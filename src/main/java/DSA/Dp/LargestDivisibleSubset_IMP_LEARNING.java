package DSA.Dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Raj
 *
 *         Given a set of distinct positive integers, find the largest subset
 *         such that every pair (Si, Sj) of elements in this subset satisfies:
 *         Si % Sj = 0 or Sj % Si = 0.
 * 
 *         If there are multiple solutions, return any subset is fine.
 * 
 *         Example 1:
 * 
 *         nums: [1,2,3]
 * 
 *         Result: [1,2] (of course, [1,3] will also be ok) Example 2:
 * 
 *         nums: [1,2,4,8]
 * 
 *         Result: [1,2,4,8]
 */

// if i have to find one i will do it using DP and track its parents
	// if i have to find all i will use DFS kind of approach 
public class LargestDivisibleSubset_IMP_LEARNING {


	// Time : O(n2), Space :O(n)
	// if i have to find
	public static List<Integer> largestDivisibleSubsetUsingDp(int[] a) {
		Arrays.sort(a);
		int t[] = new int[a.length];
		int r[] = new int[a.length];

		List<Integer> res = new ArrayList<>();
		int max_value = 1;
		int max_index = 0;
		Arrays.fill(t, 1);
		// Its parent is actually -1 whcih can be used in the loops
		r[0] = -1;
		// end statet DP it is
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] % a[j] == 0) {
					if (1 + t[j] > t[i]) {
						t[i] = 1 + t[j];
						// ith parent is j
						r[i] = j;
						if (t[i] > max_value) {
							max_value = t[i];
							max_index = i;
						}
					}
				}
			}
		}

		int idx = max_index;
		while (idx >= 0) {
			res.add(a[idx]);
			idx = r[idx];
		}
		return res;
	}

	public static List<Integer> largestDivisibleSubsetUsingDfs(int[] a) {
		Arrays.sort(a);
		List<Integer> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		dfs(a, 0, cur, res);
		return res;
	}

	private static void dfs(int[] a, int start, List<Integer> cur, List<Integer> res) {
		if (cur.size() > res.size()) {
			res.clear();
			res.addAll(cur);
		}

		for (int i = start; i < a.length; i++) {
			// To begin with Very nice approach taken since nothing is there to publish with
			// very clenly done
			// else you had to make looop outside and pass first elemment as all index and very nicely done
			// must note this way to code !!!!!

			if (0 == cur.size()) {
				cur.add(a[i]);
				dfs(a, i + 1, cur, res);
				cur.remove(cur.size() - 1);
			} else {
				int top = cur.get(cur.size() - 1);
				if (a[i] % top == 0) {
					cur.add(a[i]);
					dfs(a, i + 1, cur, res);
					cur.remove(cur.size() - 1);
				}
			}
		}
	}

	public static void main(String args[]) {
		int a[] = { 1, 2, 4, 8, 9, 72 };
		List<Integer> res = largestDivisibleSubsetUsingDfs(a);
		System.out.println(res);

		res = largestDivisibleSubsetUsingDp(a);
		System.out.println(res);
	}
}