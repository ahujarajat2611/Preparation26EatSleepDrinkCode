package BasicAlgorithms.String;

/**
 * Created by hadoop on 3/1/18.
 */
public class ReverseString {
    public String reverse(String s) {
        if (s == null) {
            return null;
        }
        char[] c = s.toCharArray();
        int length = s.length();
        int mid = length >> 1;
        for (int i = 0; i < mid; i++) {
            char temp = c[i];
            c[i] = c[length - i - 1];
            c[length - i - 1] = temp;
        }
        return new String(c);
    }

    public String reverse2(String s) {
        char[] str = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            str[begin] = (char) (str[begin] ^ str[end]);
            str[end] = (char) (str[begin] ^ str[end]);
            str[begin] = (char) (str[end] ^ str[begin]);
            begin++;
            end--;
        }
        return new String(str);
    }
    public String reverse5(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse5(right) + reverse5(left);
    }

    public static void main(String[] args) {
        System.out.println(3+ Math.random() *4);
    }
}
