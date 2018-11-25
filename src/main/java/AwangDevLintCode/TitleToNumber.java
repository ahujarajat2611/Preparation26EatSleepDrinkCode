package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
public class TitleToNumber {


/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
*/


    //ABC -> 'A', 'B', 'C'
    public int titleToNumber(String s) {//S = AA
        int rst = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {//i = 0,1,2 // (char c : arr)
            rst = rst * 26 + (arr[i] - 'A') + 1;//rst =1, 26 + 1 = 27,
        }
        return rst;
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        System.out.println(titleToNumber.titleToNumber("ABCD"));
    }
}
