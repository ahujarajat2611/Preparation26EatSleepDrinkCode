package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class ReverseString {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int length = arr.length;
        for (int i = 0; i < length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = temp;
        }
        return String.valueOf(arr);

        //return new StringBuilder(s).reverse().toString();
    }
}
