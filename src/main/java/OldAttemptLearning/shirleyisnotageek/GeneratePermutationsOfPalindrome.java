package OldAttemptLearning.shirleyisnotageek;
import java.util.*;

/**
 * Created by hadoop on 18/1/18.
 */
/*
Count the occurrence of the string, if there are more than one odd number of occurrences in the string, return empty result. Otherwise publish from middle and add chars to two sides until we reach the length.

 */
public class GeneratePermutationsOfPalindrome {
    public List<String> generatePalindromes(String s) {
        List<String> rst = new ArrayList<>();
        if (s.length() == 0) {
            return rst;
        }

        Map<Character, Integer> countChars = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!countChars.containsKey(c)) {
                countChars.put(c, 1);
            } else {
                countChars.put(c, countChars.get(c) + 1);
            }
        }
        char[] chars = new char[countChars.size()];
        char single = '$';
        int index = 0;
        boolean containsSingle = false;
        for (char c : countChars.keySet()) {
            if (countChars.get(c) % 2 != 0) {
                if (containsSingle) {
                    return rst;
                } else {
                    single = c;
                    containsSingle = true;
                }
            } else {
                chars[index++] = c;
            }
        }
        if (containsSingle) {
            getList(chars,  "" + single, rst, s.length(), chars.length - 1);
        } else {
            getList(chars, "", rst, s.length(), chars.length);
        }
        return rst;
    }

    private void getList(char[] chars,  String curr, List<String> rst, int length, int size) {
        if (curr.length() == length){
            rst.add(curr);
            return;
        }
        for (int i = 0; i < size; i++) {
            char c = chars[i];
            if (curr.indexOf(c) >= 0) {
                continue;
            }
            getList(chars, c + curr + c, rst, length, size);
        }
    }
}
