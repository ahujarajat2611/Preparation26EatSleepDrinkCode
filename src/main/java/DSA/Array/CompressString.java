package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class CompressString {

    public String compressString(String str, int n) {
        if (null == str || str.length() <= 1)
            return str;
        StringBuffer sb = new StringBuffer();

        char pre = str.charAt(0), cur;
        int count = 1;
        for (int i = 1; i < n; i++) {
            cur = str.charAt(i);
            if (cur == pre) {
                count++;
            } else {
                sb.append(pre);
                if (count > 1)
                    sb.append(count);
                pre = cur;
                count = 1;
            }
        }
        sb.append(pre);
        if (count > 1)
            sb.append(count);
        return sb.toString();
    }
}
