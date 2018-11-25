package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
public class SortLettersByCase {
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }

        //ASCII of '0'-> 48
        // ASCII of 'a' -> 97
        //ASCII of 'A'->65
          //  65 + 32 ( 6 some other chars )
        // thats why here  pivoting has different approach altoghether
        char pivot = 'a';
        int start = 0; int end = chars.length - 1;
        while (start <= end) {
            while (start <= end && chars[start] >= pivot) {
                start++;
            }
            while (start <= end && chars[end] < pivot) {
                end--;
            }
            if (start <= end) {
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
        }
    }
}
