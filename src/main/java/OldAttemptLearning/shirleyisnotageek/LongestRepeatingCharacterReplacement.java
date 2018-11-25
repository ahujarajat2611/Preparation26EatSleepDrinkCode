package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
Note:
Both the string's length and k will not exceed 104.
Example 1:
Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:
Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 */
/*
This problem asks us to find the longest substring of repeating characters if we can make at most k replacement. Now if we remove the restriction that we can only make k replacement, the solution should be length of string - occurrence of character with maximum occurrence. With the k restriction, we can use sliding window manner, if length of the window - max occurrence so far > k, we know we cannot construct such substring with at most k replacement, so we move window rightward. The longest substring should be updated with the length of the window.

 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int len = s.length();
        int[] count = new int[26];
        int maxCount = 0;
        int rst = 0;
        for (int i = 0; i < len; i++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(i) - 'A']);
            while (i - start + 1 - maxCount > k) {
                maxCount = Math.max(maxCount, --count[s.charAt(start) - 'A']);
                start++;
            }
            rst = Math.max(rst, i - start + 1);
        }
        return rst;
    }
}
