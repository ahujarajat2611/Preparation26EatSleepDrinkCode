package PracticeOneWeek26;

/**
 * Created by hadoop on 8/12/17.
 */
public class CompareStrings {
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
}
