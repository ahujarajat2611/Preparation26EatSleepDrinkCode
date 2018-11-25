package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
import java.util.*;
public class PermutationUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(rst, new ArrayList<Integer>(), nums, visited);

        return rst;
    }

    public void helper(List<List<Integer>> rst, ArrayList<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && visited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(rst, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;

        }
    }
}
