package BasicAlgorithms.String;

/**
 * Created by hadoop on 24/10/17.
 */
import java.util.*;
public class LongestWord {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        int j =-1;
        for (String dict : d) {
            j=0;
            for (int i = 0; i < s.length() && j < dict.length(); i++) {
                if (s.charAt(i) == dict.charAt(j)) {
                    j++;
                }
            }
            if (j == dict.length()) {
                return dict;
            }
        }
        return null;
    }
}
