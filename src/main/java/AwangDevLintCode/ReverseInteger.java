package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
/*
Reverse Integer

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
//input = 1534236469

Thinking process:
Make sure of operators.
Note: check for overflow using long. When integer is > Integer.MAX_VALUE, then it's overflow.
Initialize long : long x = 1234L;
Convert using (int)

*/
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) {
            return x;    //123
        }
        boolean sign = x > 0; //sign = true
        long rst = 0L;
        x = Math.abs(x);                        // 123
        while (x != 0) {                        //x = 123, 12, 1
            rst = rst * 10 + x % 10;           //rst = 3, 30 + 2 = 32, 320 + 1 = 321
            x = x / 10;                         //x = 12; 1; 0
        }
        // take long variable to dal with out of range thinsg
        // check if more than INTEGER.MAX_VALUE return !!!
        if (rst < 0 || rst > Integer.MAX_VALUE) {
            return 0;
        }
        return sign ? (int)rst : -(int)rst;
    }
    /*
    Thoughts:
    1. Use long to capture the result. If > Integer.MAX_VALUE,return 0;
    2. Use string to reverse, the conver to long
    3. use string builder to reverse string

    */
    public int reverseIntegerUsingStringBuilder(int n) {
        long num = (long)n;
        int sign = n > 0 ? 1 : -1;
        String rst = new StringBuilder(Math.abs(num)+"").reverse().toString();
        num = Long.parseLong(rst) * sign;

        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)num;
        }
    }
    public int reverseUsingCharArray(int x) {
        long result = (long) x;
        char[] arr = (Math.abs(result) + "").toCharArray();
        int arrLength = arr.length;
        for (int i = 0; i < arrLength/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arrLength - i - 1];
            arr[arrLength - i - 1] = temp;
        }
        result = Long.parseLong(String.valueOf(arr)) * (x > 0 ? 1 : -1);
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
