package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
import java.util.*;
public class LargestNumber {
    class CustomComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        String[] strs = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            strs[i] = num[i] + "";
        }
        Arrays.sort(strs, new CustomComparator());
        StringBuffer sb=  new StringBuffer();
        for (int i = 0; i < num.length; i++) {
            sb.append(strs[i]);
        }
        String rst = sb.toString();
        if (rst.charAt(0) == '0') {
            return "0";
        }
        return rst;
    }
}
