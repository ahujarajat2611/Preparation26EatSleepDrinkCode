package BasicAlgorithms.Dp;
import java.util.*;

public class TargetSum {

    int count = 0;

    public int findTargetSumWays2(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }


    public int findTargetSumWays3(int[] nums, int S) {
        Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
        return calculate(nums, 0, 0, S, mem);
    }

    public int calculate(int[] nums, int i, int sum, int S, Map<Integer, Map<Integer, Integer>> mem) {
        if (mem.containsKey(i) && mem.get(i).get(sum) != null) {
            return mem.get(i).get(sum);
        }
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            int add = calculate(nums, i + 1, sum + nums[i], S, mem);
            int sub = calculate(nums, i + 1, sum - nums[i], S, mem);
            if (!mem.containsKey(i)) {
                mem.put(i, new HashMap<>());
            }
            mem.get(i).put(sum, mem.get(i).getOrDefault(sum, 0) + add + sub);
            return add + sub;
        }
    }
}