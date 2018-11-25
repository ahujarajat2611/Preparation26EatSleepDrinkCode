package BasicAlgorithms.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 25/11/17.
 */
public class slidingWindowTemplateByHarryChaoyangHe {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        // init a collection to store the final result
        List<Integer> result = new ArrayList<>();
        if (t.length() > s.length()) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //must be the map size, NOT the string size because the char may be duplicate.
        int counter = map.size();
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window

        int begin = 0;
        int end = 0;
        //the length of the substring which match the target string.

        int len = Integer.MAX_VALUE;
        while (end < s.length()) {
            char x = s.charAt(end);
            if (map.containsKey(x)) {
                map.put(x, map.get(x) - 1);
                if (map.get(x) == 0) counter--;
            }
            end++;
            //increase begin pointer to make it invalid/valid again
            // counter condition. different question may have different condition */
            while (counter == 0) {
                char tempC = s.charAt(begin);
                if (map.containsKey(tempC)) {
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) {
                        counter++;
                    }
                }
                begin++;
            }
        }
        return result;
    }
}
