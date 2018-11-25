package BasicAlgorithms.String;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str:strs) {
            sb.append(str).append("/");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int start=0;
        int end = 0;
        while (end<s.length()){
            while (end<s.length() && s.charAt(end)!='/'){
                end++;
            }
            res.add(s.substring(start,end));
            start = end+1;
            end++;
        }
        return res;
    }
}