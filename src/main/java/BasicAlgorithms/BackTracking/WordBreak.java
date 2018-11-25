package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict.contains(s)) {
            return true;
        }
        boolean isreachable[] = new boolean[s.length()+1];
        isreachable[0] = true;
        for(int end=1;end<=s.length();end++){
            for(int i=0;i<end;i++){
                String substring = s.substring(i,end);
                if(dict.contains(substring) && isreachable[i]){
                    isreachable[end] = true;
                }
            }
        }
        return isreachable[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        HashSet<String> set = new HashSet<>();
        set.add("ra");
        set.add("jat");
        System.out.println(wordBreak.wordBreak("rajat",set));
    }
}
