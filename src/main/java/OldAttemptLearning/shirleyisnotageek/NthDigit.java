package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 22/1/18.
 */
/*
Nth Digit
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).
Example 1:
Input:
3

Output:
3
Example 2:
Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10
 */
/*
Math. :(

0 - 9 : 9 * 1 digits
10 - 99 : 90 * 2 digits
100 - 999: 900 * 3 digits
...

So we can calculate the number of digits by finding the range of the number first, e.g., if n = 1000, 1000 - 9 - 90 = 811, which is the 811th digit starting from 100. Now the actual number is calculated by 100 + (811 - 1)/ 3 = 370. The digit is calculated by (811 - 1) % 3.

Now why should we do (811 - 1)? For number 370, let n1, n2, and n3 for the nth digit of digit 3, 7, and 0. Then n1/3, n2/3 and n3/3 should all equal 370. To achieve that, we need to do (811 - 1). Let's use another example. If we have n = 190, 191, or 192, all three n should lead to number 100. The reminder after we subtract the first two digits are 1, 2, and 3 (190 - 189, 191 - 189, 192 - 189). If we want all 1, 2, 3 / 3 leads to 0 (100 + 0), we need to subtract the reminder by 1, i.e., change it to 0 based expression.
 */
public class NthDigit {

    public int findNthDigit(int n) {
        long digitLen = 1, count = 9, start = 1;
        long m = (long)n;
        while (m > count * digitLen) {
            m -= count * digitLen;
            start *= 10;
            count *= 10;
            digitLen++;
        }
        start += (m - 1) / digitLen;
        return String.valueOf(start).charAt((int)((m - 1)% digitLen)) - '0';
    }
}
