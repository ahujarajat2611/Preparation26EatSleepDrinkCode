package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
import java.util.*;
public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            /// Wattt a way if you want to keep it string instead of char ( fuck )
            // imp  can be used
            String str = s.charAt(i) + "";
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }//ENd for
        int countOdd = 0;
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                countOdd++;
            }
            if (countOdd > 1) {
                return false;
            }
        }//END for
        return true;
    }
}
