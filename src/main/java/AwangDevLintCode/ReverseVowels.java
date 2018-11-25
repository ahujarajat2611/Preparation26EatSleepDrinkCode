package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
import java.util.*;
public class ReverseVowels {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        final StringBuffer sb = new StringBuffer(s);

        int maxIndex = sb.length() - 1;
        int i = 0;
        int j = maxIndex;
        while (i < j) {
            while (i < maxIndex && !vowels.contains(sb.charAt(i))) i++;
            while (j > 0 && !vowels.contains(sb.charAt(j))) j--;

            if (i < j && vowels.contains(sb.charAt(i)) && vowels.contains(sb.charAt(j))) {
                char letter = sb.charAt(j);
                sb.setCharAt(j, sb.charAt(i));
                sb.setCharAt(i, letter);
                j--;
                i++;
            }
        }
        return sb.toString();
    }
}
