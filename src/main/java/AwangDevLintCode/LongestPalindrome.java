package AwangDevLintCode;

/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Example
Given the string = "abcdzdcab", return "cdzdc".

Challenge
O(n2) time is acceptable. Can you do it in O(n) time.

Hide Company Tags Amazon Microsoft Bloomberg
Hide Tags String
Hide Similar Problems (H) Shortest Palindrome (E) Palindrome Permutation


*/

/*
	O(n) way, not done yet
*/


/*
	02.16.2016 recap: Worst case still O(n^2)
	Find index i to split S into left and right.
	Check if from i's two sides can form a palindrom.
	If so, mark the longest, then keep increasing i.
*/
/**
 * Created by hadoop on 4/2/18.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String rst = "";
        for (int i = 0; i < s.length(); i++) {
            if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i)) {
                rst = checkPalindrom(s, i-1, i, rst);
            }
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                rst = checkPalindrom(s, i, i+1, rst);
            }
            if (i - 1 >= 0 && i + 1 < s.length() && s.charAt(i - 1) == s.charAt(i + 1)) {
                rst = checkPalindrom(s, i-1, i+1, rst);
            }
        }
        return rst;
    }

    public String checkPalindrom(String s, int start, int end, String rst) {
        while (start - 1 >= 0 && end + 1 < s.length() && s.charAt(start - 1) == s.charAt(end + 1)) {
            start--;
            end++;
        }
        if (rst.length() < s.substring(start, end + 1).length()) {
            rst = s.substring(start, end + 1);
        }
        return rst;
    }
}
