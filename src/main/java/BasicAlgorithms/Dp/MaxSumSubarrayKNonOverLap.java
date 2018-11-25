package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 25/2/18.
 */
import BasicAlgorithms.utils.ConsoleWriter;

import java.util.*;

/*
Maximum Subarray III

    Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

    The number in each subarray should be contiguous.

    Return the largest sum.

    Example

    Given [-1,4,-2,3,-2,3], k=2, return 8

    Note

    The subarray should contain at least one number

Method 1: DP
Analysis

Using sums[i][j] to denote the maximum total sum of choosing i subarrays from the first j numbers.

We can update by sums[i][j] = max(sums[i - 1][t] + maxSubarraySum(nums[t+1...j])), which means using the first t numbers to choose i - 1 subarrays, and plus the maximum sum from remaining numbers(nums[t]...nums[j-1]). We want to try all possible split point, so t ranges from nums[i-1] to nums[j-1].

In the most inner loop, it will try to examine the max sum from the subarray nums[t] to nums[j-1], where t goes from j-1 down to i-1. We can compute for each t the maximum sum. However, if we scan from right to left instead of left to right, we only needs to update the maximum value incrementally. For example, t's range is [1..5], so at first, the max sum is pick from [5], then it's picked from [4...5], ..., finally picked from [1...5]. By scanning from right to left, we are able to include the new number into computing on the fly.
 */
public class MaxSumSubarrayKNonOverLap {
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() < k) {
            return 0;
        }
        int len = nums.size();
        int[][] sums = new int[k + 1][len + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= len; j++) { // at least need one number in each subarray
                sums[i][j] = Integer.MIN_VALUE;
                int sum = 0;
                // you can not go from beginning
                // since we are finding max from staring point and
                // if we canlcute from beginning point then
                // there would be overlap unto that point
                // hence correct way would be to publish from end !!! all possible options
                // to avoid overlap !!!
                int max = Integer.MIN_VALUE;
                for (int t = i - 1; t <= j - 1; t++) {
                    sum = Math.max(nums.get(t), sum + nums.get(t));
                    max = Math.max(max, sum);
                    sums[i][j] = Math.max(sums[i][j], sums[i - 1][t] + max);
                }
//                System.out.println("new =====");
//                ConsoleWriter.printArray(sums);
            }
        }
        return sums[k][len];
    }

    public int maxSubArrayOld(ArrayList<Integer> nums, int k) {
        if (nums == null || nums.size() < k) {
            return 0;
        }
        int len = nums.size();
        int[][] sums = new int[k + 1][len + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= len; j++) { // at least need one number in each subarray
                sums[i][j] = Integer.MIN_VALUE;
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for (int t = j - 1; t >= i - 1; t--) {
                    sum = Math.max(nums.get(t), sum + nums.get(t));
                    max = Math.max(max, sum);
                    sums[i][j] = Math.max(sums[i][j], sums[i - 1][t] + max);
                }
                System.out.println("old =====");
                ConsoleWriter.printArray(sums);
            }
        }
        return sums[k][len];
    }

    public static void main(String[] args) {
        Integer []array = new Integer[]{-1,4,-2,3,-2,3};
        Integer []ar = {1,2,3};
        int k=1;
        MaxSumSubarrayKNonOverLap maxSumSubarrayKNonOverLap = new MaxSumSubarrayKNonOverLap();
        System.out.println(maxSumSubarrayKNonOverLap.maxSubArray(new ArrayList<Integer>(Arrays.asList(ar)),k));
        System.out.println(maxSumSubarrayKNonOverLap.maxSubArrayOld(new ArrayList<Integer>(Arrays.asList(array)),k));
    }
}
