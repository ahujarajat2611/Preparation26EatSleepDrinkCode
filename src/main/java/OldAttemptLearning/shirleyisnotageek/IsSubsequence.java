package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 22/1/18.
 */
/*

Go through the string and whenever pass all chars that don't match. In the end a subsequence of the string should reach to the end.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS == 0) {
            return true;
        }
        if (lenS > lenT) {
            return false;
        }

        int posS = 0, posT = 0;
        while (posS < lenS && posT < lenT) {
            while (posT < t.length() && t.charAt(posT) != s.charAt(posS)) {
                posT++;
            }
            posS++;
            posT++;
        }
        return posS == lenS;
    }
}
