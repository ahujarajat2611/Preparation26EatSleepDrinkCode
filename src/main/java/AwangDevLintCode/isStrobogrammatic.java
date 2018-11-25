package AwangDevLintCode;

/**
 * Created by hadoop on 7/2/18.
 */
import java.util.*;
public class isStrobogrammatic {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        if (num.length() == 1) {
            return num.equals("0") || num.equals("1") || num.equals("8");
        }
        List<Character> candidate = new ArrayList<>(Arrays.asList('0', '1', '8', '6', '9'));
        char[] charArray = num.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!candidate.contains(charArray[i])) {
                return false;
            }
            if (charArray[i] == '6') {
                charArray[i] = '9';
            } else if (charArray[i] == '9') {
                charArray[i] = '6';
            }
        }
        StringBuffer sb = new StringBuffer(String.valueOf(charArray));
        String upsideDownNum = sb.reverse().toString();
        return num.equals(upsideDownNum);
    }
    public boolean isStrobogrammaticAgain(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        // store mapping of all characters
        // left right poinnter!!
        HashMap<Character, Character> map = new HashMap<Character,Character>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');

        // For middle case // we will get same character
        // like 00 11 88 .. so those cases will get clear
        // but 6 9 and 9 to 6 !!!!
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!map.containsKey(num.charAt(right)) || num.charAt(left) != map.get(num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
