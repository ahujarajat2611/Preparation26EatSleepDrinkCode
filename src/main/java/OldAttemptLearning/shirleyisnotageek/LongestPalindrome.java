package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes
 that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Note:
Assume the length of given string will not exceed 1,010.
Example:
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

We know that if a string is a palindrome, there can be at most one odd number in it. So what we should do is to count occurrence of all Characters. Then if the occurrence of the number is even, we add the occurrence to result, otherwise we decrease the occurrence by one and add it to result. In the end if number of odd occurrence Characters is greater than 0, we increase the final result by 1.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!counts.containsKey(c)) {
                counts.put(c, 1);
            } else {
                counts.put(c, counts.get(c) + 1);
            }
        }
        int odd = 0;
        int sum = 0;
        for (int i : counts.values()) {
            sum += i;
            if (i % 2 != 0) {
                sum -= 1;
                odd++;
            }
        }
        return odd > 0 ? sum + 1 : sum;
    }
}
