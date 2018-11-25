package BasicAlgorithms.String;

/**
 * Created by hadoop on 27/2/18.
 */
import java.util.*;
public class ScrambleStringOptions {
        public boolean isScramble(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.equals(s2)) {
                return true;
            }
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (char a : s1.toCharArray()) {
                if (!hashMap.containsKey(a)) {
                    hashMap.put(a, 1);
                } else {
                    hashMap.put(a, hashMap.get(a) + 1);
                }
            }
            for (char b : s2.toCharArray()) {
                if (!hashMap.containsKey(b)) {
                    return false;
                }
                int freq = hashMap.get(b);
                freq = freq - 1;
                if (freq == 0) {
                    hashMap.remove(b);
                } else {
                    hashMap.put(b, freq);
                }
            }
            if (hashMap.keySet().size() != 0) {
                return false;
            }
            String reverse = new StringBuilder(s2).reverse().toString();
            for (int i = 0; i < s1.length() - 1; i++) {
                if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1)) && isScramble(s1.substring(i + 1), s2.substring(i + 1))) {
                    return true;
                }
                if (isScramble(s1.substring(0, i + 1), reverse.substring(0, i + 1)) && isScramble(s1.substring(i + 1), reverse.substring(i + 1))) {
                    return true;
                }
            }
            return false;
        }
}
