package AwangDevLintCode;

/*
Recap 3.28.2016
Use number+"#" to mark a string. Append them all.
*/
import java.util.*;
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.size(); i++) {
            // LENGTH + # WOULD WORK LIKE ANYTHING !!!! FOR SURE NO OTHER CASES
            sb.append(strs.get(i).length() + "#" + strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return strs;
        }
        int start = 0;
        while (start < s.length()) {

            /// index of function , we also pass the starrting index , very imp

            int ind = s.indexOf("#", start);

            int leng = Integer.parseInt(s.substring(start, ind));

            start = ind + 1 + leng;
            strs.add(s.substring(ind + 1, start));
        }
        return strs;
    }
    /*
     public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            //            sb.append(s.length()).append('$').append(s);

            sb.append(s.length()).append('$').append(s).append('$');
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
         List<String> rst = new ArrayList<>();
        int start =0;
        while (start<s.length()){
            int end = start;
            // index of function , we also pass the starrting index , very imp
            int index = s.indexOf('$',end);
            int length = Integer.parseInt(s.substring(end,index));
            end = index + length +1;
            rst.add(s.substring(index+1,end));
            // start = end;
            start = end+1;
        }
        return rst;
    }
     */
}