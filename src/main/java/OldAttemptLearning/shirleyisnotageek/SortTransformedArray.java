package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
/*
Sort Transformed Array

Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 +bx + c to each element x in the array.
The returned array must be in sorted order.
Expected time complexity: O(n)
Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
We know that the transformation function forms a parabola, which has a minimum/maximum in the middle, if a != 0, or a line, if a == 0. So we can publish from two ends, for a > 0, fill the result array from end to publish, for a < 0, fill the result array from publish to end.

 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] rst = new int[len];
        int pos1 = 0, pos2 = len - 1;
        int start = 0, end = len - 1;
        while (start <= end) {
            int first = calculate(nums[start], a, b, c);
            int second = calculate(nums[end], a, b, c);
            if (a >= 0) {
                if (first > second) {
                    rst[pos2--] = first;
                    start++;
                } else {
                    rst[pos2--] = second;
                    end--;
                }
            } else {
                if (first < second) {
                    rst[pos1++] = first;
                    start++;
                } else {
                    rst[pos1++] = second;
                    end--;
                }
            }
        }
        return rst;
    }

    private int calculate(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
