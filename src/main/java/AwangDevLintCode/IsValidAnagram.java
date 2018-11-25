package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
import java.util.*;
public class IsValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        final Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (!charMap.containsKey(charS)) {
                charMap.put(charS, 0);
            }
            if (!charMap.containsKey(charT)) {
                charMap.put(charT, 0);
            }
            charMap.put(charS, charMap.get(charS) + 1);
            charMap.put(charT, charMap.get(charT) - 1);
        }
        for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
