package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 22/9/17.
 */
import java.util.*;
public class Anagrams {
    private class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Integer, List<String>> map = new HashMap<>();
            for (String str : strs) {
                int hashCode = computeHashCode(str);
                List<String> anagramList;
                if (map.containsKey(hashCode)) {
                    anagramList = map.get(hashCode);
                } else {
                    anagramList = new ArrayList<>();
                }
                anagramList.add(str);
                map.put(hashCode, anagramList);
            }

            List<List<String>> result = new ArrayList<>();

            for (List<String> anagramList : map.values()) {
                Collections.sort(anagramList);
                result.add(anagramList);
            }
            return result;
        }

        private int computeHashCode (String str) {
            int[] count = new int[26];
            for (char c: str.toCharArray()) {
                ++count[c - 'a'];
            }

            int hashCode = 17;

            for (int val: count) {
                hashCode = hashCode * 31 + val;
            }
            return hashCode;
            // in java string we use
            //s[0]*31^(n-1) + s[1]*31^(n-2) + … + s[n-1]
            // mind u u r calcultaing hashcode of ocunt array
            //
        }
    }
}
