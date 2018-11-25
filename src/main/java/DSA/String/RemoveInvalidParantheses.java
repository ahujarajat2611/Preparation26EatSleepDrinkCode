/**
 *
 */
package DSA.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author Raj
 * 
 *         Remove the minimum number of invalid parentheses in order to make the
 *         input string valid. Return all possible results.
 * 
 *         Note: The input string may contain letters other than the parentheses
 *         ( and ).
 * 
 *         Examples: "()())()" -> ["()()()", "(())()"] "(a)())()" -> ["(a)()()",
 *         "(a())()"] ")(" -> [""]
 */

public class RemoveInvalidParantheses {

	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		// sanity check
		if (s == null) {
			return res;
		}

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		// initialize
		queue.add(s);

		boolean found = false;

		while (!queue.isEmpty()) {
			s = queue.poll();
			visited.add(s);

			if (isValid(s)) {
				// found an answer, add to the result
				res.add(s);
				found = true;
			}

			// once found atleast one valid result, add to result only if same
			// length result is valid. This is because we need to find max
			// length valid string
			if (found) {
				continue;
			}

			// generate all possible states
			for (int i = 0; i < s.length(); i++) {
				// we only try to remove left or right paren
				if (s.charAt(i) != '(' && s.charAt(i) != ')') {
					continue;
				}

				String t = s.substring(0, i) + s.substring(i + 1);
				if (!visited.contains(t)) {
					// for each state, if it's not visited, add it to the queue
					queue.add(t);
				}
			}
		}

		return res;
	}

	// helper function checks if string s contains valid parantheses
	boolean isValid(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
			}
			if (c == ')' && count-- == 0) {
				return false;
			}
		}

		return count == 0;
	}

	public static void main(String[] args) {
		RemoveInvalidParantheses obj = new RemoveInvalidParantheses();

		String str = "()())()";
		List<String> result = null;

		// Time : O(n) Space :O(1)
		result = obj.removeInvalidParentheses(str);
		System.out.println(result);
	}

}
