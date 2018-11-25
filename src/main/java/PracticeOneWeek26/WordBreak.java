package PracticeOneWeek26;

import java.util.Set;

/**
 * Created by hadoop on 9/12/17.
 */
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
}
