package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class MaxSubarray2 {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int[] frontSum = new int[nums.size()];
        int[] endSum = new int[nums.size()];
        int maxSum = 0;
        frontSum[0] = nums.get(0);
        //Init frontSum
        for (int i = 1; i < frontSum.length; i++) {
            if (frontSum[i - 1] < 0) {
                frontSum[i] = nums.get(i);
            } else {
                frontSum[i] = frontSum[i - 1] + nums.get(i);
            }
        }
        maxSum = frontSum[0];
        //Find max
        for (int i = 1; i < frontSum.length; i++) {
            if (frontSum[i] < maxSum) {
                frontSum[i] = maxSum;
            } else {
                maxSum = frontSum[i];
            }
        }

        //Init endSum
        endSum[endSum.length - 1] = nums.get(nums.size() - 1);
        for (int i = endSum.length - 2; i >= 0; i--) {
            if (endSum[i + 1] < 0) {
                endSum[i] = nums.get(i);
            } else {
                endSum[i] = endSum[i + 1] + nums.get(i);
            }
        }
        //Find max
        maxSum = endSum[endSum.length - 1];
        for (int i = endSum.length - 2; i >= 0; i--) {
            if (endSum[i] < maxSum) {
                endSum[i] = maxSum;
            } else {
                maxSum = endSum[i];
            }
        }
        //Calculate max Sum
        maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            maxSum = Math.max(maxSum, frontSum[i] + endSum[i + 1]);
        }
        return maxSum;
    }
}
