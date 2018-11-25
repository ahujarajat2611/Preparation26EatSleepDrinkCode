package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;

/**
 * Created by hadoop on 21/9/17.
 */
public class MaxSubarray3 {
    public int maxSubArray(ArrayList<Integer> num){
        int len = num.size();
        int leftmax[]= new int[len];
        int leftmin[] = new int[len];

        int rightmax[] = new int[len];
        int rightmin[] = new int[len];
        int currentMax = 0;
        int currentMin = 0;
        for(int i=0;i<len;i++){
            currentMax = Math.max(currentMax+num.get(i),num.get(i));
            currentMin = Math.min(currentMin+num.get(i),num.get(i));
            if(i==0){
                leftmax[i] = currentMax;
                leftmin[i] = currentMin;
                continue;
            }
            leftmax[i] = Math.max(leftmax[i-1],currentMax);
            leftmin[i] = Math.min(leftmin[i-1],currentMin);
        }

        return 0;
    }
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        int len = nums.size();
        int[] leftMax = new int[len];
        int[] leftMin = new int[len];
        int curMaxSum = 0;
        int curMinSum = 0;
        // scan from left to right
        for (int i = 0; i < len; i++) {
            curMaxSum = Math.max(curMaxSum + nums.get(i), nums.get(i));
            curMinSum = Math.min(curMinSum + nums.get(i), nums.get(i));
            if (i == 0) {
                leftMax[i] = curMaxSum;
                leftMin[i] = curMinSum;
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], curMaxSum);
                leftMin[i] = Math.min(leftMin[i - 1], curMinSum);
            }
        }
        // scan from right to left
        curMaxSum = 0;
        curMinSum = 0;
        int rightMax = 0;
        int rightMin = 0;
        int maxDiff = 0;
        for (int i = len - 1; i > 0; i--) {
            curMaxSum = Math.max(curMaxSum + nums.get(i), nums.get(i));
            curMinSum = Math.min(curMinSum + nums.get(i), nums.get(i));
            if (i == len - 1) {
                rightMax = curMaxSum;
                rightMin = curMinSum;
            } else {
                rightMax = Math.max(rightMax, curMaxSum);
                rightMin = Math.min(rightMin, curMinSum);
            }
            maxDiff = Math.max(
                    maxDiff,
                    Math.max(
                            Math.abs(leftMax[i - 1] - rightMin),
                            Math.abs(rightMax - leftMin[i - 1])));
        }
        return maxDiff;
    }
}
