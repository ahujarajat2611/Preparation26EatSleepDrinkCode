package BasicAlgorithms.String;

/**
 * Created by hadoop on 3/1/18.
 */
public class ReplaceString {
    public String replaceSpace(String input) {
        if (input == null) {
            return null;
        }
        if (input.length() == 0) {
            return "";
        }
        char[] str = input.toCharArray();
        int spaceCount = 0;
        for (char c : str) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        int len = str.length + spaceCount * 2;
        char[] res = new char[len];
        int idx = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                res[idx++] = '%';
                res[idx++] = '2';
                res[idx++] = '0';
            } else {
                res[idx++] = str[i];
            }
        }
        return new String(res);
    }
}
