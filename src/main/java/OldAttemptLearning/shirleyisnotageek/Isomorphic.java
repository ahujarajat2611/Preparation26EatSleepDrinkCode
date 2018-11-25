package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 21/1/18.
 */
/*
Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic
if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all
occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters
may map to the same letter, but a letter may map to itself.

Example:
given "foo", "app"; returns true
we can map 'f' -> 'a' and 'o' -> 'p'
given "bar", "foo"; returns false
we can't map both 'a' and 'r' to 'o'

given "turtle", "tletur"; returns true
we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r'

given "ab", "ca"; returns true
we can map 'a' -> 'c', 'b'

Click here for the original problem.
I implement two methods, the first one map the character to the first occurred index for both strings, and check if the encodings are the same for both strings. The second one is more traditional, map characters in the first string to the same index one in the second string. However, both methods require two maps.
 */
public class Isomorphic {
    public boolean isIsomorphic2 (String a, String b) {
        if (a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();

        Map<Character,Character> amap = new HashMap<Character,Character> ();
        Map<Character,Character> bmap = new HashMap<Character,Character> ();

        for (int i = 0; i < a.length(); i++) {
            if (amap.containsKey(a.charAt(i))) {
                if(amap.get(a.charAt(i)) != b.charAt(i))
                    return false;
            }
            if (bmap.containsKey(b.charAt(i))) {
                if (bmap.get(b.charAt(i)) != a.charAt(i))
                    return false;
            }
            amap.put(a.charAt(i), b.charAt(i));
            bmap.put(b.charAt(i), a.charAt(i));
        }
        return true;
    }

}
