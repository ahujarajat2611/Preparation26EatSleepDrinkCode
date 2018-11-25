package BasicAlgorithms.String;

public class KMP {

	public static void main(String[] args) {

		// Step 1 (pre processing): computing the LPS - longest proper prefix
        // which is also a suffix
		// step 2 (processing):

		String text = "AAABBCCAAABAB";
		String pattern = "AAA";

		int n = text.length();
		int m = pattern.length();

		int[] LPS = new int[m];

		int i = 0; // text pointer
		int j = 0; // pattern pointer

		computeLongestProperPrefixSuffix(pattern, m, LPS);

		while (i < n) {

			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;

			}

			if (j == m) {
				System.out.println("Pattern is Matched!! at position "+(i-j));
				j = LPS[j - 1];
			}

			else if (i < n && text.charAt(i) != pattern.charAt(j)) {

				if (j == 0)
					i++;
				else
					j = LPS[j - 1];

			}
		}

		// TODO Auto-generated method stub

	}

	public static void computeLongestProperPrefixSuffix(String pattern, int m, int[] LPS) {
		int i = 1;

		int len = 0;

		LPS[0] = 0;

		while (i < m) {

			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				LPS[i] = len;
				i++;
			} else {
				if (len != 0)
					len = LPS[len - 1];
				else
					LPS[i] = 0;
				i++;
			}

		}
		

		// prefix table

		// proper prefix:
		// all combinations without including the combination

		// which is containing the last character of
		// the pattern e.g abcde have these proper prefix: a, ab, abc, abcd

		// proper suffic: all combinations without including the combination
		// which is containing the first character of
		// the pattern e.g abcde have these proper suffix: e, de, cde, bcde

		// so, the longest proper prefix equal to the longest proper suffix = ?
	}
	public static boolean repeatedSubstringPattern(String str) {
		//build the KMP pattern.
		int n = str.length();
		int cur = 0;
		int j = 1;
		int[] pattern = new int[n];
		pattern[0] = 0;

		while (j < n) {
			if (str.charAt(cur) == str.charAt(j)) {
				pattern[j++] = ++cur;
			} else {
				if (cur == 0) {
					pattern[j++] = 0;
				} else {
					cur = pattern[cur - 1];//publish from beginning of current matching pattern.
				}
			}
		}

		return (pattern[n - 1] > 0 && n % (n - pattern[n - 1]) == 0);
	}
}