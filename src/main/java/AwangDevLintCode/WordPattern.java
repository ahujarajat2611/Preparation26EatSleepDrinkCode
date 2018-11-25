package AwangDevLintCode;

/**
 * Created by hadoop on 6/2/18.
 */
import java.util.*;
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern != null && str != null && pattern.length() == 0 && str.length() == 0) {
            return true;
        }
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<Character, String>();
        HashMap<String, Character> mapStr = new HashMap<String, Character>();

        for (int i = 0; i < strArr.length; i++){
            // two way mapping one for char to string
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), strArr[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(strArr[i])) {
                    return false;
                }
            }
            // mapping from  string to char
            // if does not contain string then put char correspoing to this string
            if (!mapStr.containsKey(strArr[i])) {
                mapStr.put(strArr[i], pattern.charAt(i));
                // if it contains then char should match
            } else {
                if (mapStr.get(strArr[i]) != pattern.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean wordPatternOneHashMap(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }

        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = strArr[i];
            /// if map does not contains //
            // then make sure its value also does not string as well
            //
            if (!map.containsKey(c)) {
                // we are doing so with the value to make sure value is
                // not present in the map
                if (map.containsValue(s)) {
                    return false;
                }
                map.put(c, s);
                // if it contains then make sure current values
                // equal to value present in the map as well !!!
            } else if (!map.get(c).equals(s)) {
                return false;
            }
        }
        return true;
    }
}
