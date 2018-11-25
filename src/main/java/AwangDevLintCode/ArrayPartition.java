package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say
(a1, b1), (a2, b2), ..., (an, bn) which makes sum of
min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].

 */
/*
Thoughts: goal is to find the half of the numbers' sum, and always pick the min value of the pair.
Also, need to make the overall sum as large as possible: can't always choose the smallest numbers, but we can choose numbers at ascending order.
1. sort array.
2. only pick the even ones (starting from index 0)
Note:
1. use long to save result: never know what sum can occur in the process.
2. sort the array
O(nlogn)
*/
// pick even positioned which starts from 0 boom you are done
import java.util.*;
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        /*
        (a1, b1), (a2, b2), ..., (an, bn) which makes sum of
         min(ai, bi) for all i from 1 to n as large as possible.
        so thats for sure you want to consider max valuues together !!! then only you can get max sum !!!
        so sort it and addd all even numberrs value in case array is not even .. last and i ==
         */
        // since number of elements are even so we
        // will consider every even positioned
        // element and leave odd indexed element !!
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += i % 2 == 0 ? nums[i] : 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        ArrayPartition arrayPartition = new ArrayPartition();
        System.out.println(arrayPartition.arrayPairSum(new int[]{1,10,25,100,150}));
    }
}
