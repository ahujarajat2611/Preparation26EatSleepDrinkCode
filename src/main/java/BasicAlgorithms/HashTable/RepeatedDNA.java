package BasicAlgorithms.HashTable;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class RepeatedDNA {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        // IF STRING HAS 10 LENGTH IN THAT CASE ONLY ONCE LOOP SHOULD GET
        // EXECUTED ... SO HERE ITS WRONG HAPPENIG TWICE ..
        for (int i = 0; i < s.length() - 10+1; i++) {
            String sub = s.substring(i, i + 10);
            if (set.contains(sub)) {
                ans.add(sub);
            } else {
                set.add(sub);
            }
        }
        return ans;
    }
}