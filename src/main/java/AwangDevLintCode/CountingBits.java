package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
/*
Thoughts:
Just looking at the bit representation:
0: 0000
1: 0001
2: 0010
3: 0011

check 1 and 2: 2 >> 1 becomes 1. '0001' was calculated before, so 2 should use it.
dp[i]: represents num <= i, then how many 1's are there.
dp[i>>1]: represents the binary number has less 1 bit.
dp[i]:
    - if i's binary has a tailing '1', then dp[i] = dp[i >> 1] + 1
    - if i's binary has a tailing '0', then dp[i] = dp[i >> 1]
Combine:
dp[i] = dp[i >> 1] + i % 2;
Usually use num value itself as DP's status index.
*/


public class CountingBits {
    public int[] countBits(int num) {
        if (num < 0) {
            return null;
        }
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            int prevNum = i >> 1;
            dp[i] = dp[prevNum] + i % 2;
        }
        return dp;
    }
}
