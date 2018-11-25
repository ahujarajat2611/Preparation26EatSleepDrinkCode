package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
Largest Divisible Subset
Given a set of distinct positive Integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
If there are multiple solutions, return any subset is fine.
Example 1:
nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:
nums: [1,2,4,8]

Result: [1,2,4,8]

Sort the array first, which makes us only have to  think about nums[i] % nums[j] where i > j. Now we build a dp array which tracks the the longest subarray before the current element that all nums[i] % nums[j] = 0 where i > j. We also use an index array, which tracks the index of the element before current one in the subset. We use maxLen to track the max length of the sub array and max_index for the last/largest element in the subset. Now we can use index array to find all elements in subarray.
 */
public class LargestDivisibleSUbset {
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
