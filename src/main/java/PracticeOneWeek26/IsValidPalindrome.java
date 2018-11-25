package PracticeOneWeek26;

/**
 * Created by hadoop on 9/12/17.
 */
public class IsValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            while (start < s.length() &&
                    (s.charAt(start) < '0' || (s.charAt(start) > '9' && s.charAt(start) < 'a') || s.charAt(start) > 'z') ) {
                start++;
            }
            while (end >= 0 &&
                    (s.charAt(end) < '0' || (s.charAt(end) > '9' && s.charAt(end) < 'a') || s.charAt(end) > 'z')) {
                end--;
            }
            if (start < end && s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
