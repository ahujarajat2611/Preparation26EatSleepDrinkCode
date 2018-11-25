package DSA.Dp;

/**
 * 
 * @author Raj
 *
 *         Given a string s and a string t, check if s is subsequence of t.
 * 
 *         You may assume that there is only lower case English letters in both
 *         s and t. t is potentially a very long (length ~= 500,000) string, and
 *         s is a short string (<=100).
 * 
 *         A subsequence of a string is a new string which is formed from the
 *         original string by deleting some (can be none) of the characters
 *         without disturbing the relative positions of the remaining
 *         characters. (ie, "ace" is a subsequence of "abcde" while "aec" is
 *         not).
 * 
 *         Example 1: s = "abc", t = "ahbgdc"
 * 
 *         Return true.
 */
public class IsSubsequence {

	// Time :O(n), Space : O(1)
	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
		int i = 0, j = 0;
		while (j < t.length()) {
			if (t.charAt(j) == s.charAt(i)) {
				i++;
				if (i == s.length())
					return true;
			}
			j++;
		}
		return false;
	}

	public static void main(String args[]) {
		boolean res = false;
		res = isSubsequence("abc", "ahbgdc");
		System.out.println(res);

	}

}
