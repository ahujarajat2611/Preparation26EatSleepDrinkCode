package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class ReverseWOrds {
    /*
Thinking Process:
1. Reverse it like reversing a int array
2. Use Split into arrays.
3. When reversing, make sure not empty string ""
*/
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        // reversee array of words strings !!!!
        // once that happens !!
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            String temp = new String(strs[j]);
            strs[j] = new String(strs[i]);
            strs[i] = temp;
        }
        // just iterat and make stringbuilder to add words and one space
        //"" apart from last space !!1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() > 0) {
                sb.append(strs[i]);
                if (i < strs.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
    public static void main(String args[]){
        ReverseWOrds reverseWOrds = new ReverseWOrds();
        System.out.println(reverseWOrds.reverseWords("rajat ahuja i will fukcing do it "));
    }
    /*
    Thoughts:12.08.2015
    Have multiple two other ways to do it:
        1. flip all,then flip each individual word;
        2. break into parts and append from end to beginning.
    For simplicity of code, try the appending from behind.
*/
    public String reverseWordsSimpler(String s) {
        if (s == null || s.length() == 0 || s.indexOf(" ") == -1) {
            return s;
        }

        String[] strs = s.split(" ");
        if (strs.length == 0) {
            return s;
        }
        StringBuffer sb = new StringBuffer();

        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i] + " ");
        }

        return sb.substring(0, sb.length() - 1).toString();
    }
}
