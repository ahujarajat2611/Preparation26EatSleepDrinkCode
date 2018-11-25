package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.



For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]

Note
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example
given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]

Tags Expand
Backtracking Array

Thinking process:
Similar to 'Combination' problem,
do back-tracking with ability to repeat itself at index i.
In order to stop duplicates of result entry, use a 'prev' tracker to 'continue' if a value is repeating at any index. Skip repeating integers because we've already allow unlimited # of same integer in one single solution. (IMPORTANT: will have to sort the int[] in order to detect the duplicates)
In particular, I pass a 'sum' to compare with 'target' (want to have sum == target). Some solution prefer to use 'target - someVlaue' == 0 to find solution.
*/
import java.util.*;
public class CombinationSum1and2 {
    public List<List<Integer>> combinationSum(int[] num, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (num == null || num.length == 0 || target < 0) {
            return rst;
        }
        Arrays.sort(num);
        helper(rst, list, num, target, 0, 0);
        return rst;
    }
    public void helper(List<List<Integer>> rst, List<Integer> list,
                       int[] num, int target, int sum, int start) {
        if (sum == target) {
            rst.add(new ArrayList(list));
            return;
        } else if (sum > target) {//Stop if greater than target
            return;
        }
        int prev = -1;//Repeat detection
        for (int i = start; i < num.length; i++) {
            if (prev != -1 && prev == num[i]) {
                continue;
            }
            list.add(num[i]);
            sum += num[i];
            // PASSING I not i + 1
            // here recursing is ending with sum varibale (had that sum variable wudnt had been theer, it woudl be infite recurison)
            helper(rst, list, num, target, sum, i);
            //Back track:
            sum -= num[i];
            list.remove(list.size() - 1);
            //Repeat Detection
            prev = num[i];
        }
    }
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (num == null || num.length == 0 || target < 0) {
            return rst;
        }
        Arrays.sort(num);
        helper(rst, list, num, target, 0, 0);
        return rst;
    }
    /*
    Thinking process:
Exact same idea as in Combination Sum I. The difference is,
cannot reuse the current index
in nums. Instead, in helper() function, use index of i + 1
     */
    public void helper2(List<List<Integer>> rst, List<Integer> list,
                       int[] num, int target, int sum, int start) {
        if (sum == target) {
            rst.add(new ArrayList(list));
            return;
        } else if (sum > target) {//Stop if greater than target
            return;
        }
        int prev = -1;//Repeat detection
        for (int i = start; i < num.length; i++) {
            if (prev != -1 && prev == num[i]) {
                continue;
            }
            list.add(num[i]);
            sum += num[i];
            helper2(rst, list, num, target, sum, i + 1);
            //Back track:
            sum -= num[i];
            list.remove(list.size() - 1);
            //Repeat Detection
            prev = num[i];
        }
    }
    //always check to see what is ending codntion for combinations problem
    // nck ---list.size == k
    // sum == target
    // other things as well !!!
}
