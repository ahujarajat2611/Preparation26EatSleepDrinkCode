package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
import java.util.*;
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
    public List<Integer> singleNumberIII(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        List<Integer> rst = new ArrayList<Integer>();
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        int bitOnePos = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor >> i & 1) == 1) {
                bitOnePos = i;
                // check which bit pos is 1
            }
        }
        int rstA = 0;
        int rstB = 0;
        for (int i = 0; i < A.length; i++) {
            // we could have gonne other way 1<< bitOneePos
            if ((A[i] >> bitOnePos & 1) == 1) {
                rstA ^= A[i];
            } else {
                rstB ^= A[i];
            }
        }
        rst.add(rstA);
        rst.add(rstB);
        return rst;
    }
    /*
Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
One-pass, constant extra space
Thinking process:
Still using bit manipulation. We need to erase all of the 3-appearance number and leave the single number out. A few steps:
Store the final result by continuously bit OR with the result variable.
Want to XOR the 3 numbers, but can’t erase them as if only 2 duplicate numbers:Consider the number as 3-based number, so XOR can be understand this way
	when add 3 numbers together, add each individual bit. If the sum is 3, then set it as 0. If not 3, leave as is.
3.   Store the bits in a integer array, which simulates a binary version of the integer
4.   When each bit’s XOR process finishes, bit OR it with result
*/
    public int singleNumberII(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        //present the XOR results in binary format
        int[] bits = new int[32];
        int rst = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++){
                //XOR the numbers in a 3-base fashion. Whenever bit[i] has a number 3, set it back to 0.
                bits[i] += A[j] >> i & 1;
                bits[i] %= 3;
            }
            //OR it to the result. However, each time only the i - spot is updated with the bits[i].
            rst |= bits[i] << i;
        }
        return rst;
    }
}
