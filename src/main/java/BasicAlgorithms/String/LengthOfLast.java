package BasicAlgorithms.String;

/**
 *
 * Created by hadoop on 14/10/17.
 */
public class LengthOfLast {
    public static void main(String arhs[]) {

    }

    public int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (end>=0  && s.charAt(end)==' ')
            end--;
        int start=end;
        while (start>=0 && s.charAt(start)!=' '){
            start--;
        }
        return  s.substring(start+1,end+1).length();
    }
}