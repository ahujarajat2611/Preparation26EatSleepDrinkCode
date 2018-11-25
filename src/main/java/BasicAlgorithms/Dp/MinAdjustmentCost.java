package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 24/12/17.
 */
public class MinAdjustmentCost {
}
/*
Minimum Adjustment Cose

Question

Given an integer array,
adjust each integers so that the difference of every adjacent
 integers are not greater than a given number target.
If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|
Example Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.
Return 2.
Note You can assume each number in the array is a positive integer and not greater than 100.
Thoughts

dp[i][j] means the minimum cost of changing A[i-1] to j to meat the requirement
init state

dp[0][j] = 0
connection function

dp[i][j] = min(dp[i-1][k] + abs(A[i-1] - j)) k is a range, since abs(j - k) <= target, so we can know k's range to get the minimum dp[i][j]
final result

the minimum of dp[len(A)][j] for j in range(0,101)
Solution

class Solution:
    # @param A: An integer array.
    # @param target: An integer.
    def MinAdjustmentCost(self, A, target):
        # write your code here
        if not A:
            return 0
        dp = [[0 for i in range(101)] for j in range(len(A)+1)]
        #init states
        for i in range(101):
            dp[0][i] = 0

        curMin = 0
        for i in range(1, len(A)+1):
            curMin = sys.maxint
            for j in range(1, 101):
                dp[i][j] = sys.maxint
                low = max(1, j - target)
                high = min(100, j + target)
                for k in range(low, high + 1):
                    dp[i][j] = min(dp[i][j], dp[i-1][k] + abs(A[i-1]-j))
                    curMin = min(curMin, dp[i][j])

        return curMin
 */