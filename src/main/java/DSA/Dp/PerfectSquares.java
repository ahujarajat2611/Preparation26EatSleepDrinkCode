/**
 * 
 */
package DSA.Dp;

import java.util.Arrays;

/**
 * @author Raj
 *
 *         Given a positive integer n, find the least number of perfect square
 *         numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 *         For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n =
 *         13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {

	// Time:O(n2), Space :O(n)
	public static int numSquares(int n) {
		if (n <= 0) {
			return 0;
		}
		int t[] = new int[n + 1];
		Arrays.fill(t, Integer.MAX_VALUE);
		t[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				t[i] = Math.min(t[i], 1 + t[i - j * j]);
			}
		}
		return t[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = -1;
		res = numSquares(12);
		System.out.println(res);
		res = numSquares(13);
		System.out.println(res);
	}

}
