package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Use a helper method to perform recursive backtracking:add an element to next-level recursive call, and remote the entry after the recursive call.
Note: When 'new' something, cannot use 'List' because it's a abstract class. Need to new 'ArrayList'
*/
import java.util.*;
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) {
            return rst;
        }
        List<Integer> solution = new ArrayList<Integer>();
        helper(rst, solution, n, k, 1);// Start == 1 because we want 1 ~ n in this problem
        return rst;
    }
    public void helper(List<List<Integer>> rst,
                       List<Integer> solution, int n, int k, int start) {
        if (solution.size() == k) {
            // once my index reach to k then i know i have reached the end
            // lets print out the list out of the combinations
            //
            // list.size() == k since i have to select k elements out of n elements
            // when my list has K elements time to addd to ans ..
            //
            rst.add(new ArrayList(solution));
            return;
            // if(start > n )
            // then also we shold return for sure !!!!!
            //
        }
        for (int i = start; i <= n; i++) {// <=n because we want 1 ~ n in this problem
            //adding
            solution.add(i);
            // make sure you dont end up calling same funciotn if u pass i as variable
            helper(rst, solution, n, k, i + 1);
            // backtrack  the move !!
            solution.remove(solution.size() - 1); //Back-track
        }
    }

}
