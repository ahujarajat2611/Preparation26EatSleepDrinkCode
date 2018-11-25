package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 21/1/18.
 */
/*
Find all the repeating sub-String sequence
Find all the repeating sub-String sequence of
specified length in a large String sequence.
The sequences returned i.e. the output must be sorted alphabetically.


For e.g.

Input String: "ABCACBABC"
repeated sub-String length: 3

Output: ABC

Input String: "ABCABCA"
repeated sub-String length: 2

Output: AB, BC, CA

Click here for the original problem.
Ha, very interesting problem. I was wondering why all the add() methods returns boolean type. Now I  know, since Set doesn't allow duplicate values,  if add() returns false, it means the set fails to add the value, which probably imply there already exists the value. And in this problem, we are utilizing this feature.
 */
class SubStringOfLength {
    public class RepeatingSubString {
        public ArrayList<String> repeatSubString (String s, int length) {
            if (s == null)
                throw new NullPointerException("Null array");
            ArrayList<String> rst = new ArrayList<String> ();
            if (s.length() == 0)
                return rst;
            HashSet<String> nonRepeating = new HashSet<String> ();
            TreeSet<String> repeating = new TreeSet<String> ();
            for (int i = 0; i + length <= s.length(); i++) {
                if (!nonRepeating.add(s.substring(i, i + length)))
                    repeating.add(s.substring(i, i + length));
            }
            rst = new ArrayList<String> (repeating);
            return rst;
        }

    }
}
