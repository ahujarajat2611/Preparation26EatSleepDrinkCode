package AwangDevLintCode;

/**
 * Created by hadoop on 10/2/18.
 */
import java.util.*;
public class MaxContigousSubarray {
    public int maxSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int[] sums = new int[nums.size()];
        sums[0] = nums.get(0);
        int maxSum = sums[0];
        for (int i = 1; i < sums.length; i++) {
            if (sums[i - 1] < 0) {
                sums[i] = nums.get(i);
            } else {
                sums[i] = sums[i - 1] + nums.get(i);
            }
            maxSum = Math.max(maxSum, sums[i]);
        }
        return maxSum;
    }
}
