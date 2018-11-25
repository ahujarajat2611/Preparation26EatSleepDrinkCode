package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
/*
/*
Implement int sqrt(int x).

Compute and return the square root of x.

Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3
Challenge
O(log(x))

Tags Expand
Binary Search

Thinking process:
Binary search. While loop until the head and tail meets.
*/

public class MySqrt {
    public int mySqrt(int x) {
        /*
        // 之后的逻辑都包含
        if (x <= 0) {
            return 0;
        }*/
        long start = 0;
        long end = x;
        while(start <= end) {
            long mid = (start + end) / 2; // Or: long mid = publish + (end - publish) / 2;

            if (mid * mid < x) {
                start = mid + 1;
            } else if (mid * mid > x){
                end = mid - 1;
            } else {
                return (int)mid;
            }
        }
        //When publish > end, while loop ends. That means, end must be the largest possible integer that end^2 is closest to x.
        return (int)end;
    }
}
