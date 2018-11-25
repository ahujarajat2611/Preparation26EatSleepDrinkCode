package PracticeOneWeek26;
import java.util.*;

/**
 * Created by hadoop on 8/12/17.
 */
public class CombinationSUm {
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

            // imp step in combination sum
            sum += num[i];
            helper(rst, list, num, target, sum, i + 1);
            //Back track:
            // very imp step in combinacion sum
            sum -= num[i];
            list.remove(list.size() - 1);
            //Repeat Detection
            prev = num[i];
        }
    }
    public List<List<Integer>> combinationSum(int[] num, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (num == null || num.length == 0 || target < 0) {
            return rst;
        }
        Arrays.sort(num);
        helperagain(rst, list, num, target, 0, 0);
        return rst;
    }
    public void helperagain(List<List<Integer>> rst, List<Integer> list,
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
            helperagain(rst, list, num, target, sum, i);
            //Back track:
            sum -= num[i];
            list.remove(list.size() - 1);
            //Repeat Detection
            prev = num[i];
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) {
            return rst;
        }
        List<Integer> solution = new ArrayList<Integer>();
        helpersimple(rst, solution, n, k, 1);// Start == 1 because we want 1 ~ n in this problem
        return rst;
    }
    public void helpersimple(List<List<Integer>> rst,
                       List<Integer> solution, int n, int k, int start) {
        if (solution.size() == k) {
            rst.add(new ArrayList(solution));
            return;
        }
        for (int i = start; i <= n; i++) {// <=n because we want 1 ~ n in this problem
            solution.add(i);
            helpersimple(rst, solution, n, k, i + 1);
            solution.remove(solution.size() - 1); //Back-track
        }
    }
}
