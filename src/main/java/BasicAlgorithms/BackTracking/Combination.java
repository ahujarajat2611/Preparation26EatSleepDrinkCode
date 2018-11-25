package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 22/10/17.
 */
import java.util.*;
public class Combination {

/*
	Combinations
	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	For example,
	If n = 4 and k = 2, a solution is:
	[
  		[2,4],
  		[3,4],
  		[2,3],
  		[1,2],
  		[1,3],
  		[1,4],
	]
	Tags: Backtracking
*/

 /*
        n: n = 4 代表1,2,3,4
        k: k = 2 代表由1..n 个数种选取k(2)个数组合，必须小到大排列。
 */


    /*

    */
    //Recursive
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        if (n < k)
            return res;
        dfs(n, k ,res, item, 1);
        return res;
    }

    public void dfs(int n, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item, int start) {
        // one possible combinition constructured
        //由item的size == k 控制返回条件
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }

        //不是数组，因此1--n 不是0--n-1
        // try each possibility number in current position
        for (int i = start; i <= n; i++) {
            item.add(i);
            // the new publish should be after the next number after i
            dfs(n, k, res, item, i + 1);// after selecting number for current position, process next position
            item.remove(item.size() - 1);// clear the current position to try next possible number
        }
    }
}
