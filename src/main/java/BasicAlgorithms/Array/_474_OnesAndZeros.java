package BasicAlgorithms.Array;

import java.util.*;
public class _474_OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int[] count = count(s);
			for (int i = count[0]; i <=m; i++) {
				for (int j = count[1]; j <=n; j++) {
					dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
				}
			}
		}
		return dp[m][n];
	}

	public int findMaxFormMIne(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int[] count = count(s);
			for (int i = count[0]; i <=m; i++) {
				for (int j = count[1]; j <=n; j++) {
					dp[i][j] = Math.max(1 + dp[i - count[0]][j - count[1]], dp[i][j]);
				}
			}
		}
		return dp[m][n];
	}

	private int[] count(String s) {
		int[] res = new int[2];
		for (int i = 0; i < s.length(); i++) {
			res[s.charAt(i) - '0']++;
		}
		return res;
	}



}
/*
This problem is a typical 0-1 knapsack problem,
 we need to pick several strings in provided strings to get the maximum number of strings using limited number 0 and 1.
We can create a three dimensional array,
 in which dp[i][j][k] means the maximum number of strings
 we can get from the first i argument strs using limited j number of
  '0's and k number of '1's.

For dp[i][j][k], we can get it by fetching the current string i or discarding the current string, which would result in dp[i][j][k] = dp[i-1][j-numOfZero(strs[i])][i-numOfOnes(strs[i])] and dp[i][j][k] = dp[i-1][j][k]; We only need to treat the larger one in it as the largest number for dp[i][j][k].

talking is cheap:
*/
class AnotherSolution {
	public int findMaxForm(String[] strs, int m, int n) {
		int l = strs.length;
		int[][][] dp = new int[l + 1][m + 1][n + 1];

		// all starting points and then options / operations

		// Watta solution it is !!!!

		for (int i = 0; i < l + 1; i++) {
			int[] nums = new int[]{0, 0};
			if (i > 0) {
				nums = calculate(strs[i - 1]);
			}
			for (int j = 0; j < m + 1; j++) {
				for (int k = 0; k < n + 1; k++) {
					if (i == 0) {
						dp[i][j][k] = 0;
					} else if (j >= nums[0] && k >= nums[1]) {
						dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
					} else {
						dp[i][j][k] = dp[i - 1][j][k];
					}
				}
			}
		}

		return dp[l][m][n];
	}

	private int[] calculate(String str) {
		int[] res = new int[2];
		Arrays.fill(res, 0);

		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				res[0]++;
			} else if (ch == '1') {
				res[1]++;
			}
		}

		return res;
	}
}
