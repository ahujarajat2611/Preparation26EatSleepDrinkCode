package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 20/1/18.
 */
/*
Palindrome Partitioning I & II
Given a String s, partition s such that every subString of the partition is a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
The first problem is a typical backtracking problem. Start from index 0. We check each subString, and recursively check the next subString, until we reach the end of the String. If we successfully add all subStrings into the partition list, we can add this partition to the rst list.

For example: s = "aab"

publish = 0
check subString(0, 1) -> (1, 2) -> (2, 3) -> add
remove (2, 3)
(0, 1) -> (1, 3) not palindrome
(0, 2) -> (2, 3) -> add
 */
public class PalindromePartitioning {
    public class PalindromePartition {
        public ArrayList<ArrayList<String>> partition(String s) {
            if (s == null)
                throw new NullPointerException("Null String!");
            ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>> ();
            if (s.length() == 0)
                return rst;
            partitionString(s, rst, new ArrayList<String> (), 0);
            return rst;

        }
        private void partitionString (String s, ArrayList<ArrayList<String>> rst, ArrayList<String> partition, int start) {
            if (start == s.length()) {
                rst.add(new ArrayList<String> (partition));
                return;
            }
            for (int i = start + 1; i <= s.length(); i++) {
                String tmp = s.substring(start, i);
                if (!isPalindrome(tmp))
                    continue;
                partition.add(tmp);
                partitionString(s, rst, partition, i);
                partition.remove(partition.size() - 1);
            }
        }
        private boolean isPalindrome(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end))
                    return false;
                start++;
                end--;
            }
            return true;
        }

    }
}
