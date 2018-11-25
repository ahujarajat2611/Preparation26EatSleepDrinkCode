package BasicAlgorithms.String;

import java.util.*;
/**
 * Created by hadoop on 18/12/17.
 */
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i< s.length()-10+1; i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }
}
