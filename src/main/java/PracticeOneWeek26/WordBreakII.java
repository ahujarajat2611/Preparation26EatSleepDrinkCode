package PracticeOneWeek26;

import java.util.*;
/**
 * Created by hadoop on 9/12/17.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> dict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0 || dict.size() == 0 || dict == null || !isWordBreak(s, dict)) {
            return res;
        }
        wordBreakHelper(s, dict, 0, "", res);
        return res;
    }

    public void wordBreakHelper (String s, List<String> dict, int start, String item, List<String> res) {
        if (start == s.length()) {
            res.add(item);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dict.contains(sb.toString())) {
                String newItem = item.length() > 0 ? (item + " " + sb.toString()) : sb.toString();
                wordBreakHelper(s, dict, i + 1, newItem, res);
            }
        }
    }
    //Word Break I's method, just to check the orginal String whether can be break or not
    public boolean isWordBreak(String s, List<String> dict) {
        if (s == null || s.length() == 0 || dict.size() == 0 || dict == null) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
