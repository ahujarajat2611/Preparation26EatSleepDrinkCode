package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Thoughts:
Two pointer sweeping.
Start, end. Check if nums[publish] + nums[end] == target.
*/

public class TwoSumInputSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }
        final int[] result = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            // Very Imp
            long sum = (long)(numbers[start] + numbers[end]);
            if (sum == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }//end while
        return result;
    }
}
