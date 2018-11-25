package BasicAlgorithms.SlidingWindow;

/**
 * Created by hadoop on 14/12/17.
 */
/*
Given a string that consists of only uppercase English letters,
 you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

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
import java.util.*;
public class    LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {

        int[] letters = new int[26];
        if (s.length() == 0) return 0;

        int start = 0, end = 0, count = 0, max = 0;
        while (end < s.length()){
            char c = s.charAt(end);
            letters[c - 'A']++;
            count = Math.max(count, letters[c - 'A']);
            end++;
            // i will consider not to replace the max repeating char
            // rather than other characters
            while (end - start - count > k){
                char cc = s.charAt(start);
                letters[cc - 'A']--;
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
    public int characterReplacementMine(String s, int k) {

        int end = 0;
        int start =0;
        HashMap<Character,Integer> hashmap = new HashMap<Character,Integer>();
        int maxcount=0;
        int ans = 0;
        while(end <s.length()){
            int count = hashmap.getOrDefault(s.charAt(end),0)+1 ;
            hashmap.put(s.charAt(end),count);
            maxcount = Math.max(maxcount,count);
            // now pointers are not valid anymore
            while(end-start+1-maxcount>k){
                hashmap.put(s.charAt(start),hashmap.get(s.charAt(start))-1);
                start++;
            }

            ans = Math.max(ans,end-start+1);
            end++;
        }
        return  ans;
    }

    public static void main(String[] args) {
     ///   "AABABBA"
       // 1
        LongestRepeatingCharReplacement longestRepeatingCharReplacement = new LongestRepeatingCharReplacement();
        System.out.println(longestRepeatingCharReplacement.characterReplacementMine("AABABBA",1));
    }
}
