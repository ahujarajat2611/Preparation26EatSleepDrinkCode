package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
/*
Given a non-negative number represented as an array of digits, plus one to the number.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.


Example
Given [1,2,3] which represents 123, return [1,2,4].

Given [9,9,9] which represents 999, return [1,0,0,0].

Tags Expand
Array

*/
/**
 Thoughts:
 Loop over all digit and see if it advanced into next position. If not, return digits.
 Check if last position if over 10, if so, create a new array and set last pos = 1.
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits.length==0) return digits;
        digits[digits.length-1] += 1;
        //Check index digit.length-1 to 1
        for(int i = digits.length-1; i>0; i--){
            if(digits[i] == 10){
                digits[i]=0;
                digits[i-1]+=1;
            }
            else return digits;
        }

        //Check index 0. If ==0, set it to 0 and carry over 1
        if(digits[0]==10){
            int[] output = new int[digits.length+1];
            output[0] = 1;
            // copy values from digit to output as well which is not begin done
            return output;
        }
        else return digits;
    }
}
