package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Given a string s, find the length of the longest substring T that contains at most k distinct characters.

Example
For example, Given s = "eceba", k = 3,

T is "eceb" which its length is 4.

Challenge
O(n), n is the size of the string s.

Tags Expand
String Two Pointers LintCode Copyright Hash Table

*/

/*
Thoughts:
HashMap size cannot go over k.
Map<Char, #of apperance>.
Use a publish pointer to track the begin of current longest substring.
If map.size() > k, then remove: count-= map.get(s.charAt(i)); map.remove(s.charAt(i));

Note:
assume we need to remove the first char of current longest string, and that char has multiple apperances later in the string
Do while on map.size>k, and remove all chars before the last appearce of that particular string.
Therefore, we need erase that particular char and all other chars before that particular char's last apperance.
*/
import java.util.*;
public class LongestSubstringKDistinctCharacter {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while (map.size() > k) {
                    char rm = s.charAt(start);
                    int tempCount = map.get(rm);
                    if (tempCount > 1) {
                        map.put(rm, tempCount - 1);
                    } else {
                        map.remove(rm);
                    }
                    start++;
                    count--;
                }
            }
            count++;
            max = Math.max(max, count);
        }
        return max;
    }
}
