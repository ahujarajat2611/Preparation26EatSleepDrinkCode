package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
public class ReverseWordsEasy {
    public void reverseWords(char[] s) {
        if (s.length <= 1) {
            return;
        }
        reverse(s, 0, s.length - 1);
        int last = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, last, i - 1);
                last = i + 1;
            }
        }
    }
    private void reverse(char[] s, int start, int end) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
