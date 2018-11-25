package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
/*
Walk through:
1. check null conditions;
2. if p.length() == 0, return s.length() == 0
3. if p.length() == 1 or p.charAt(1) != '*', check:
    1. if s.length() < 1, or s.charAt(0) doesn't match p.charAt(0) or p.charAt(0) is not '.', return false;
    2. otherwise recursively check s.substring(1) and p.substring(1)
4. if p.charAt(1) == '*'. Assuming at first that the first character in p ("x*") doesn't match anything in s, so compare s with p.substring(2), if doesn't match, check if the first character in s and p  match, or if the first character in p is '.', if one of the conditions satisfy, increment index_s and check s.substring(index_s + 1).

The logic behind this problem is not very hard.

1. If p is an empty string, return if s is an empty string (the null condition as well)
2. If  the second character in p is not '*', if the first characters in both strings match, then we compare the substrings (recursively), otherwise return false.
3.  If the second character in p is '*', then the first two characters in p is matched. So we continue from the third character (p.substring(2)).


 */
public class RegexMatch {
    public boolean isMatch(String s, String p) {
        if (p == null || s == null)
            return false;
        if (p.length() == 0)
            return s.length() == 0;
        if (p.equals(s))
            return true;


        if (p.length() == 1 ||  p.charAt(1) != '*')
        {
            if (s.length() < 1 || (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.'))
                return false;
            return isMatch(s.substring(1), p.substring(1));
        }
        //if the first characters don't match, we need to compare substring_p with the whole s
        //e.g., s = "aab", p = "c*a*b" index_s + 1 = 0
        int index_s = -1;
        while (index_s < s.length() &&(index_s < 0 || s.charAt(index_s) == p.charAt(0) || p.charAt(0) == '.'))
        {
            // the first character is matched by '*', we move on to the next character
            if (isMatch(s.substring(index_s + 1), p.substring(2)))
                return true;
            index_s++;
        }
        return false;
    }
}
