package BasicAlgorithms.Dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 17/1/18.
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> rst = new ArrayList<>();
        if (nums == null || nums.length < 1)
            return rst;
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        int[] index = new int[len];
        int max_dp = 0, max_index = 0;
        Arrays.fill(index, -1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
            if (max_dp < dp[i]) {
                max_dp = dp[i];
                max_index = i;
            }
        }
        for (int i = max_index; i != -1; i = index[i]) {
            rst.add(nums[i]);
        }
        return rst;

    }

}
