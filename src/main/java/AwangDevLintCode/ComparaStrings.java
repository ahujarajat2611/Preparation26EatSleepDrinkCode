package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
/*
/*
Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

Example
For A = "ABCD", B = "ABC", return true.

For A = "ABCD" B = "AABC", return false.

Tags Expand
Basic Implementation String LintCode Copyright

Thinking process:
Count the number of occurance for StringA.
Count the number of occurance for StringB.
Check if all of StringB's char# <= StringA's char# at each index.
*/
// create hasmap of first string
    // second string keep removing and decremeting count // if count gets less than 0 then it mean no all chars are presnt

    // there is no !!!
public class ComparaStrings {
    public boolean compareStrings(String A, String B) {
        if (A == null || B == null || A.length() < B.length()) {
            return false;
        }
        int[] countA = new int[26];
        int[] countB = new int[26];
        for (int i = 0; i < A.length(); i++) {
            countA[A.charAt(i) - 'A']++;
        }
        for (int i = 0; i < B.length(); i++) {
            countB[B.charAt(i) - 'A']++;
            if (countB[B.charAt(i) - 'A'] > countA[B.charAt(i) - 'A']) {
                return false;
            }
        }
        return true;
    }
    // we can use removal technique as well here !!! hashmap<> firststring
    // whilel traversing second string keep removing from hashmap
    // if count becomes less thatn zero thats it not possible
    // removal technique nice one
    //
}
