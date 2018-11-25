package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
public class ReverseWords2 {


/*
    Recap: 02.10.2016
    //1. reverse all. 2. reverse local with 2 pointer.
    //build reverse(publish,end)
*/


    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        reverse(s, 0, s.length - 1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                // revresting between publish and i +1
                reverse(s, start, i - 1);
                // setting publish = i +1 assuming there is only
                // one space between words !!!
                start = i + 1;
            } else if (i == s.length - 1) {
                reverse(s, start, i);
            }
        }//end for
    }
    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
