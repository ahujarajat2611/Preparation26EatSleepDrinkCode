package DSA.Arrays2;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * Created by hadoop on 20/2/18.
 */
public class LeftMinRightMax {
    public boolean increasingTriplet2(int[] a) {
        if (a.length < 3) {
            return false;
        }
        int lmin[] = new int[a.length];
        int rmax[] = new int[a.length];
        int min = a[0], max = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            lmin[i] = min;
            min = Math.min(a[i], min);
        }

        for (int i = a.length - 2; i >= 0; i--) {
            rmax[i] = max;
            max = Math.max(a[i], max);
        }

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > lmin[i] && a[i] < rmax[i]) {
                return true;
            }
        }
        return false;
    }

    public void findMaxIndexDiff(int[] a, int n) {
        if (n <= 0)
            return;
        int leftMin[] = new int[n];
        int rightMax[] = new int[n];
        leftMin[0] = a[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }

        rightMax[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], a[i]);
        }
        int i, j, maxIndexDiff = Integer.MIN_VALUE;
        i = j = 0;
        int maxLeft = -1, maxRight = -1;

        while (i < n && j < n) {
            if (leftMin[i] < rightMax[j]) {
                if ((j - i) > maxIndexDiff) {
                    maxIndexDiff = j - i;
                    maxLeft = i;
                    maxRight = j;
                }
                j++;
            } else {
                i++;
            }
        }

        ConsoleWriter.printArray(a);
        ConsoleWriter.printArray(leftMin);
        ConsoleWriter.printArray(rightMax);

        System.out
                .println("maxLeft:" + maxLeft + ", " + "maxRight:" + maxRight + ":: " + "maxIndexDiff:" + maxIndexDiff);

    }
    public int rainWaterTrapped2(int a[]) {
        int n = a.length;
        if (n <= 3) {
            return 0;
        }
        int lMax[] = new int[n];
        int rMax[] = new int[n];

        int max_on_left = a[0];
        int max_on_right = a[n - 1];

        for (int i = 1; i < n; i++) {
            lMax[i] = max_on_left;
            max_on_left = Math.max(a[i], max_on_left);
        }

        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = max_on_right;
            max_on_right = Math.max(a[i], max_on_right);
        }

        int t = 0;
        ConsoleWriter.printArray(lMax);
        ConsoleWriter.printArray(a);
        ConsoleWriter.printArray(rMax);

        int min;
        for (int i = 1; i < n - 1; i++) {
            min = Math.min(lMax[i], rMax[i]);
            if (a[i] < min) {
                t += min - a[i];
            }
        }
        return t;
    }

    /**
     * Created by hadoop on 26/2/18.
     */
/*
Maximum Subarray Difference

Problem

Given an array with integers.
 Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest. Return the largest difference.
Notice The subarray should contain at least one number
Example

For [1, 2, -3, 1], return 6.
 */
  //  public class SubarrayMaxDIfference {
        public int maxDiffSubArrays(int[] nums) {
            int len = nums.length;

            int[] maxLeft = new int[len];
            int[] minLeft = new int[len];
            int[] maxRight = new int[len];
            int[] minRight = new int[len];

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

            int diff = 0;
            for (int i = 0; i < len - 1; i++) {
                diff = Math.max(diff, Math.abs(maxLeft[i] - minRight[i + 1]));
                diff = Math.max(diff, Math.abs(minLeft[i] - maxRight[i + 1]));
            }
            return diff;
        }
}
