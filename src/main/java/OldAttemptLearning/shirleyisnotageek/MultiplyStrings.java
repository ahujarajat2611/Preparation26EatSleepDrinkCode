package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Multiply Strings
Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
Yeah, here comes the problem that always causes overflow. I used a long variable at first, but it couldn't solve the problem. In the end, I choose to use an array.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;
        if (num1.length() == 0 || num2.length() == 0)
            return "0";
        while (num1.length() > 0 && num1.charAt(0) == '0') {
            num1 = num1.substring(1);
        }
        if (num1.length() == 0)
            return "0";
        while (num2.length() > 0 && num2.charAt(0) == '0') {
            num2 = num2.substring(1);
        }
        if (num2.length() == 0)
            return "0";

        int l1 = num1.length();
        int l2 = num2.length();
        int[] num3 = new int[l1 + l2];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int p2 = Character.getNumericValue(num2.charAt(i));
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int p1 = Character.getNumericValue(num1.charAt(j));
                int product = (p1 * p2 + carry + num3[i + j + 1]);
                carry = product / 10;
                num3[i + j + 1] = product % 10;
            }
            if (carry > 0) {
                num3[i] = carry;
            }
        }
        String rst = "";
        for (int n : num3) {
            rst += String.valueOf(n);
        }
        while (rst.charAt(0) == '0') {
            rst = rst.substring(1);
        }
        return rst;
    }
}
