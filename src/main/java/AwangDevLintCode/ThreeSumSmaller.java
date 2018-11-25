package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

For example, given nums = [-2, 0, 1, 3], and target = 2.

Return 2. Because there are two triplets which sums are less than 2:

[-2, 0, 1]
[-2, 0, 3]

Follow up:
Could you solve it in O(n2) runtime?
 */
import java.util.*;
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int start, end;
        for (int i = 0; i < nums.length - 2; i++) {
            int firstNum = nums[i];
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end]< target) {
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
