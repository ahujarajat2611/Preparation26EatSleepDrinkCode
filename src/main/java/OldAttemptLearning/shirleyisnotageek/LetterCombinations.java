package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 21/1/18.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits == null)
            throw new NullPointerException("Null String!");
        List<String> rst = new ArrayList<String> ();
        Map<Character,char[]> map = new HashMap<Character,char[]>();
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        getLetter(digits, map, rst, new StringBuilder ());
        return rst;
    }
    private void getLetter(String digits, Map<Character,char[]> map, List<String> rst, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            rst.add(sb.toString());
            return;
        }
        for (char c : map.get(digits.charAt(sb.length()))) {
            sb.append(c);
            getLetter(digits, map, rst, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
