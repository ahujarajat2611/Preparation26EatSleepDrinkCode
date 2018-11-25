package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
For example,
Given nums = [0, 1, 3] return 2.
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

The most straightforward way is to use pigeon hole theorem: swap the number to its index until you cannot do it. Check which hole doesn't contain the correct number.
A easier way is to use XOR. If number equals its index, XOR the number and the index will cancel out. In the end XOR the rst with the length of the array to get the missing number.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int rst = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            rst ^= i;
            rst ^= nums[i];
        }
        rst ^= len;
        return rst;
    }
}
