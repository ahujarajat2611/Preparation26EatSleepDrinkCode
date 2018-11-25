package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
import java.util.*;
public class PermutationAAndB {
    public boolean Permutation(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        final Map<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            final char charA = A.charAt(i);
            final char charB = B.charAt(i);
            if (!strMap.containsKey(charA)) {
                strMap.put(charA, 0);
            }
            strMap.put(charA, strMap.get(charA) + 1);
            if (!strMap.containsKey(charB)) {
                strMap.put(charB, 0);
            }
            strMap.put(charB, strMap.get(charB) - 1);
        }
        for (Map.Entry<Character, Integer> entry : strMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
