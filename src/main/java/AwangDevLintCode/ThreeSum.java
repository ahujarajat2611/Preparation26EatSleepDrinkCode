package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.
Note
You may assume that each input would have exactly one solution.
Example
For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Tags Expand
Two Pointers Sort Array

 */
/*
Thoughts:
3 SUM = for loop + 2SUM. Normally it'd be O(n^2).
Two pointer in the inner 2SUM..
Note: result should be initialized with first 3 indexes.
 */
import java.util.*;
public class ThreeSum {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ans = -1;
        long diff = Integer.MAX_VALUE;
        Arrays.sort(nums); // nLog(n)
        long result = nums[0] + nums[1] + nums[2];
        // very imp since last three numbers
        // nums.length-3, nums.length - 2, nums.length -1
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                // very imp imp ...
                long sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(sum-target)<diff){
                    diff = Math.abs(sum-target);
                    ans =(int)sum;
                }
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                //result = Math.abs(sum - target) < Math.abs(result - target) ? sum : result;
            }
        }
        return (int)ans;
    }
}
