package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
public class ZigZag {
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || s.length() <= numRows || numRows == 1)
            return s;
        StringBuilder[] array = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            array[i] = new StringBuilder();
        boolean down = true;
        int rowIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            array[rowIndex].append(s.charAt(i));
            if (down) {
                if (rowIndex < numRows - 1)
                    rowIndex++;
                else {
                    down = false;
                    rowIndex--;
                }
            } else {
                if (rowIndex > 0)
                    rowIndex--;
                else {
                    down = true;
                    rowIndex++;
                }
            }
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += array[i];
        }
        return result;
    }
}
