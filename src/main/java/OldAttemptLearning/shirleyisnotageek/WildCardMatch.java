package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
/*
1. If the corresponding char in s and p are the same, or char_p == '?', then pass, we move to the next char.
2. If char_p == '*', since '*' can represent multiple characters, we store the '*' position in p (p_star) and the corresponding position in s (s_star). Since '*' can represent any sequence, at first we assume it represents empty sequence. So we increase index_p while preserve index_s.
3. It is possible that the next char after '*' is equal to '?' or is the same as the char in s, in this case, we follow condition 1.
4. In the case when  p.charAt(index_p) != s.charAt(index_s). If there is a '*' in advance, we assume s.charAt(s_star) is represented by '*'. We increase s_star.  Meanwhile, we return index_s to s_star + 1 and let index_p = p_star + 1 because we changed the match of '*' in s so we need to rematch every character after that.
5. If no '*' is found and p.charAt(index_p) != s.charAt(index_s), we return false.

s = "abefdgd"
p = "?b*?d"

I use 'x' - 'y' to represent the two characters match. 'x' !- 'y' for not matching

'a' - '?'
'b' - 'b'
'*': p_star = 2, s_star = 2, index_p++
'e' - '?'
'f' !- 'd', '*' exists, s_star = 3, index_s = 3, index_p = 3
'f' - '?'
'd' - 'd'
'*' exists, s_star = 4, index_s = 4, index_p = 3
'd' - '?'
'g' !- 'd', '*' exists, s_star = 5, index_s = 5, index_p = 3
'g' - '?'
'd' - 'd'

Update cleaner code version3:
 */
public class WildCardMatch {
    public class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null)
                return p == null;
            if (p == null)
                return s == null;
            if (p.length() == 0)
                return s.length() == 0;
            if (s.equals(p) || p.equals("*"))
                return true;
            int index_s = 0;
            int index_p = 0;
            int s_star = 0;
            int p_star = 0;
            boolean star = false;
            while (index_s < s.length()) {
                if (index_p < p.length() && (s.charAt(index_s) == p.charAt(index_p) || p.charAt(index_p) == '?')) {
                    index_s++;
                    index_p++;
                }
                else if (index_p < p.length() && p.charAt(index_p) == '*') {
                    star = true;
                    s_star = index_s;
                    p_star = ++index_p;
                }
                else {
                    if (!star)
                        return false;
                    index_p = p_star;
                    index_s = ++s_star;
                }
            }
            while (index_p < p.length()) {
                if (p.charAt(index_p) != '*')
                    return false;
                index_p++;
            }
            return true;
        }
    }
}
