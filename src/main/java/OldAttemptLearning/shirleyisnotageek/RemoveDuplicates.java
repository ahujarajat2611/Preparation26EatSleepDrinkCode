package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 19/1/18.
 */
/*
The idea is to use a stack.
 Go through the string twice. First count the occurrence of each letters. In the second time, if there are existing chars in stack that are larger than current one, and we know later the same letter will appear again, we pop the letter from the stack. We then add current letter when no more letters can be popped out.

 */
public class RemoveDuplicates {
    public String removeDuplicateLetters(String s) {
        if (s.length() <= 1) {
            return s;
        }

        Stack<Character> chars = new Stack<>();
        int[] counter = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!chars.isEmpty() && chars.peek() > c && counter[chars.peek() - 'a'] > 0) {
                char p = chars.pop();
                visited[p - 'a'] = false;
            }
            // before pushing we can check if its visited then we can simply ignore this
            chars.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!chars.isEmpty()) {
            builder.append(chars.pop());
        }
        return builder.reverse().toString();
    }
}
