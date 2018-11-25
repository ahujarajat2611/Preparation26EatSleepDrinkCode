package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

	public static List<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		System.out.println("total ways"+dfs(result, "", n, n));
		return result;
	}

	/*
	 * left and right represents the remaining number of ( and ) that need to be
	 * added. When left > right, there are more ")" placed than "(". Such cases
	 * are wrong and the method stops.
	 */
	public static int dfs(ArrayList<String> result, String s, int left, int right) {
		if (left > right)
			return 0;

		if (left == 0 && right == 0) {
			result.add(s);
			return 1;
		}
		int ways =0;

		if (left > 0) {
			ways +=dfs(result, s + "(", left - 1, right);
		}

		if (right > 0) {
			ways +=dfs(result, s + ")", left, right - 1);
		}
		return ways;
	}

	public static void main(String[] args) {

		List<String> res = generateParenthesis(4);
		System.out.println(res);
	}
}