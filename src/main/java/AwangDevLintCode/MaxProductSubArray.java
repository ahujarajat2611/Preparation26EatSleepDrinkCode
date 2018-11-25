package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
public class MaxProductSubArray {
    /*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags Expand
Dynamic Programming Subarray
*/
/*
Thoughts:
'Largest', DP.
Consider positivie/Negative numbers.
f[x] = largest continuous product at index x. NOTE: it's not entire array's largest, need a stand-along variable to hold global max.
if nums[x] < 0, want (min of f[x-1]) * nums[x]
if nums[x] > 0, want (max of f[x-1]) * nums[x]
Consider two different arrays.
f[x] = Math.max( min(f[x-1]) * nums[x] if nums[x]<0, or max(f[x-1])*nums[x] if nums[x]>0)
initial condition:
x = 0 -> nums[0]

*/
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        final int[] maxProduct = new int[nums.length];
        final int[] minProduct = new int[nums.length];
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                maxProduct[i] = Math.max(nums[i], maxProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], minProduct[i - 1] * nums[i]);
            } else {
                maxProduct[i] = Math.max(nums[i], minProduct[i - 1] * nums[i]);
                minProduct[i] = Math.min(nums[i], maxProduct[i - 1] * nums[i]);
            }
            result = Math.max(result, maxProduct[i]);
        }
        return result;
    }
}
