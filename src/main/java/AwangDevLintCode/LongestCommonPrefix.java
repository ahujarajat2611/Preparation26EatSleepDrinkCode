package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = "";
        int ind = 0;



        // take firsy ystring as base check iterate its char and pick one char ask other function to validate(String []arra, 1 to n,index)
        // if it matches
        // indexes are there index = 0...
        while (ind < strs[0].length()) {
            char c = strs[0].charAt(ind);
            boolean valid = false;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() > ind && strs[i].charAt(ind) == c) {
                    valid = true;
                } else {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                prefix += "" + c;
            } else {
                break;
            }
            ind++;
        }//END WHILE
        return prefix;
    }
}
