package OldAttemptLearning.shirleyisnotageek;
import java.util.*;
/**
 * Created by hadoop on 18/1/18.
 * Not a hard problem. We can use a sentinel character to concatenate strings. The tricky part is that the string can have any characters, including our sentinel. We can also track the length of the string, so the structure can be len_string + sentinel_char + len_string + sentinel_char.
 *
 */
public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('$').append(s).append('$');
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> rst = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int pos = index;
            while (pos < s.length() && Character.isDigit(s.charAt(pos))) {
                pos++;
            }
            int len = Integer.valueOf(s.substring(index, pos));
            if (s.charAt(pos++) != '$') {
                //throw new InvalidParameterException("Invalid input String!");
            }
            rst.add(s.substring(pos, pos + len));
            pos += len;
            if (s.charAt(pos++) != '$') {
                //throw new InvalidParameterException("Invalid input String!");
            }
            index = pos;
        }
        return rst;
    }
    public List<String> mydecode(String s) {
        List<String> rst = new ArrayList<>();
        int start =0;
        while (start<s.length()){
            int end = start;
            int index = s.indexOf('$',end);
            int length = Integer.parseInt(s.substring(end,index));
            end = index + length +1;
            rst.add(s.substring(index+1,end));
            start = end+1;
        }
        return rst;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        List<String> rs = new ArrayList<>();
        rs.add("rajat");
        rs.add("ahuja");
        rs.add("why");
        String ans = encodeDecodeStrings.encode(rs);
        System.out.println(encodeDecodeStrings.decode(ans));
    }
}
