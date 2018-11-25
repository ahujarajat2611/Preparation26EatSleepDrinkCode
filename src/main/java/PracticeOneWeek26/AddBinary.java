package PracticeOneWeek26;

/**
 * Created by hadoop on 7/12/17.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }
        char[] shortArr = a.length() < b.length() ? a.toCharArray() : b.toCharArray();
        char[] longArr = a.length() < b.length() ? b.toCharArray() : a.toCharArray();
        int carry = 0;
        int shortVal = 0;
        int nextCarry = 0;
        int diff = longArr.length - shortArr.length;
        for (int i = longArr.length - 1; i >= 0; i--) {
            shortVal = (i - diff) >= 0 ? shortArr[i - diff] - '0': 0;
            nextCarry = (longArr[i] - '0' + shortVal + carry) / 2;
            longArr[i] =(char)((longArr[i] - '0' + shortVal + carry) % 2 + '0');
            carry = nextCarry;
        }

        if (carry != 0) {
            return "1" + new String(longArr);
        }

        return new String(longArr);
    }
}
