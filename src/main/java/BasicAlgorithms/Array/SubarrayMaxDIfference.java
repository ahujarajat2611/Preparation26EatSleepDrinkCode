package BasicAlgorithms.Array;

import BasicAlgorithms.utils.ConsoleWriter;

/**Difference
 * Created by hadoop on 26/2/18.
 */
/*
Maximum Subarray Difference

Problem

Given an array with integers. Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest. Return the largest difference.
Notice The subarray should contain at least one number
Example

For [1, 2, -3, 1], return 6.
 */
public class SubarrayMaxDIfference {
    public int maxDiffSubArrays(int[] nums) {
        int len = nums.length;

        int[] maxLeft = new int[len];
        int[] minLeft = new int[len];
        int[] maxRight = new int[len];
        int[] minRight = new int[len];




        int[] maxLeftMine = new int[len];
        int[] minLeftMine = new int[len];
        int[] maxRightMine = new int[len];
        int[] minRightMine = new int[len];


        maxLeftMine[0] =nums[0];
        minLeftMine[0] = nums[0];

        int currentmin =nums[0];
        int currentmax = nums[0];
        for(int i=1;i<nums.length;i++){
            currentmin = Math.min(currentmin+nums[i],nums[i]);
            currentmax = Math.max(currentmax+nums[i],nums[i]);

            maxLeftMine[i] = Math.max(currentmax,maxLeftMine[i-1]);
            minLeftMine[i] = Math.min(currentmin,minLeftMine[i-1]);
        }
        minRightMine[nums.length-1] = nums[nums.length-1];
        maxRightMine[nums.length-1] = nums[nums.length-1];
         currentmin =nums[nums.length-1];
         currentmax = nums[nums.length-1];
        for(int i= nums.length-2;i>=0;i--) {
            currentmin = Math.min(currentmin + nums[i], nums[i]);
            currentmax = Math.max(currentmax + nums[i], nums[i]);
            maxRightMine[i] = Math.max(currentmax, maxRightMine[i + 1]);
            minRightMine[i] = Math.min(currentmin, minRightMine[i + 1]);
        }


        ConsoleWriter.printArray(maxLeftMine);
        ConsoleWriter.printArray(minLeftMine);
        ConsoleWriter.printArray(maxRightMine);
        ConsoleWriter.printArray(minRightMine);
        System.out.println("============");

        for (int i = 0; i < len; i++) {
            maxLeft[i] = maxRight[i] = Integer.MIN_VALUE;
            minLeft[i] = minRight[i] = Integer.MAX_VALUE;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = sum < 0 ? 0 : sum;
            maxLeft[i] = max;
        }
        sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            min = Math.min(min, sum);
            sum = sum > 0 ? 0 : sum;
            minLeft[i] = min;
        }
        sum = 0;
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = sum < 0 ? 0 : sum;
            maxRight[i] = max;
        }
        sum = 0;
        min = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            sum += nums[i];
            min = Math.min(min, sum);
            sum = sum > 0 ? 0 : sum;
            minRight[i] = min;
        }

        ConsoleWriter.printArray(maxLeft);
        ConsoleWriter.printArray(minLeft);
        ConsoleWriter.printArray(maxRight);
        ConsoleWriter.printArray(minRight);
        int diff = 0;
        for (int i = 0; i < len - 1; i++) {
            diff = Math.max(diff, Math.abs(maxLeft[i] - minRight[i + 1]));
            diff = Math.max(diff, Math.abs(minLeft[i] - maxRight[i + 1]));
        }
        return diff;
    }
    public static void main(String args[]){
        SubarrayMaxDIfference subarrayMaxDIfference = new SubarrayMaxDIfference();
        System.out.println(subarrayMaxDIfference.maxDiffSubArrays(new int[]{1, 2, -3, 1}));
    }
}
