package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
Credits:
Special thanks to @peisi for adding this problem and creating all test cases.

Hide Company Tags Google
Show Tags
Divide and Conquer Dynamic Programming


*/

/*
	Thoughts: as seen in dicussion. Build DP.
	State:
	dp[i][j]: the number of max coins can collect between i and j.
		For a position x in [i,j],
		where to burst it?
		So this goes into a divide and conquer method.
		Burst at x, track the sum, and record the max into dp[i][j]
	Function:
		dp[i][j] = Math.max(dp[i][j], DP(i, x-1) + nums[x-1]*nums[x]*nums[x+1] + DP(x+1, j))
	Init:
		create dp[n+2][n+2].  (from 0 to n+1)
		dp[0][1] = 1;
		dp[n][n+1] = 1;
	Return:
		dp[1][n]

	DP(int i, int j, int[][] dp)

	Need to redo that nums.
*/

public class BurstBallons {
    int[][] dp;
    int[] values;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        dp = new int[n + 2][n + 2];

        //Initialize new array
        values = new int[n + 2];
        values[0] = values[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            values[i] = nums[i - 1];
        }

        // pass 1 andd n specifically !!1
        return DP(1, n);
    }

    public int DP(int i, int j){
        if (dp[i][j] > 0) {//momorization
            return dp[i][j];
        }
        //divide and conquer DP
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], DP(i, x - 1) + values[i-1]*values[x]*values[j+1] + DP(x + 1, j));
        }
        return dp[i][j];
    }
}
