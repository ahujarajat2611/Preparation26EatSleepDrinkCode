package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Given a string, find the first
 non-repeating character in it and return it's index.

  If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the
string contain only lowercase letters.
*/
import java.util.*;
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
    public int firstUniqCharOptimized(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        final Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char letter = s.charAt(i);
            if (!map.containsKey(letter)) {
                map.put(letter, new ArrayList<Integer>());
            }
            map.get(letter).add(i);
        }

        // Thats how you can do it one scan !!!
        // now get all indexes that has only
        // one occureence
        // sort those indexs and return taht ans
        // wondering how can you miss this answer !!!
        final ArrayList<Integer> indexes = new ArrayList<>();
        for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                indexes.addAll(entry.getValue());
            }
        }

        if (indexes.size() == 0) {
            return -1;
        }
        Collections.sort(indexes);
        return indexes.get(0);
    }

}

/*
Thoughts:
1. put all letter into map <char, index>
2. If more than 1 occurs, remove it from
*/