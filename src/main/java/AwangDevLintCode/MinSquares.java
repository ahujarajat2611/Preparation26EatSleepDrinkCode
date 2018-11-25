package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
/*
Thoughts:
	Math:
	num =13. sqrt(13) = 3.xxx. Floor() = 3. count++;//1
	num = 13 - 9 = 4. sqrt(4) = 2. No remaining. count++;//2
	DP:
	state
		dp[i]: min # of perfect square till i.
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1 + 1 = 2;
		dp[3] = 1,1,1;//3
		dp[4] = 2^2;//1
		dp[5] = dp[5 - floor(sqrt(5))^2] + 1;
	fn: 		//Pick the largest perfect square possible, then added on what's remaining's dp. Do a BFS on all possiblilities
		maxFlorNum = Math.floor(Math.sqrt(i))
								12
			-3^2 = 3		-2^2 = 8			-1^2 = 11
			1 + dp[3]		1 + dp[8]			1 + dp[11]
		for (j = 0 ~ i)
			dp[i] = min(min, dp[i - j ^ 2] + 1)
	init:
		dp[0] = 0;
		dp[1] = 1;
	return dp[n];
*/
public class MinSquares {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int maxSqrNum = (int)Math.floor(Math.sqrt(i));
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= maxSqrNum; j++) {
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
