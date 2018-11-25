package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.

Hide Company Tags Google Uber
Hide Tags Hash Table String
Hide Similar Problems (M) Group Anagrams

*/
import java.util.*;
public class GroupSiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return rst;
        }
        Arrays.sort(strings);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String s : strings) {
            char[] arr = s.toCharArray();
            char head = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] - head < 0) {
                    arr[i] = (char)((arr[i] - head) + 26);
                } else {
                    arr[i] = (char)(arr[i] - head);
                }
            }
            // creating key based on char array straight forward !!!
            String key = new String(arr);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }

        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            rst.add(entry.getValue());
        }
        return rst;
    }
}
