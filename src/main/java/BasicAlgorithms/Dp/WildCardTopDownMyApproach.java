package BasicAlgorithms.Dp;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by hadoop on 27/1/18.
 */
public class WildCardTopDownMyApproach {
    static Map<Pair, Boolean> cache = new HashMap<Pair, Boolean>();

    public boolean isMatch(String s, String p) {
        // Remove pattern which has multiple ***** in the pattern

        char[] pattern = p.toCharArray();
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }
        boolean returnvalue = isMatchHelper(s.toCharArray(), pattern, s.length() - 1, writeIndex-1);
        return returnvalue;
    }
    private static boolean isMatchHelper(char []s,char[] p,int sindex,int pindex){

        if(sindex == -1){
            for(int i=0;i<=pindex;i++){
                if(p[i] !='*'){
                    return false;
                }
            }
            return true;
        }
        if(cache.containsKey(new Pair<Integer,Integer>(sindex,pindex))){
            return cache.get(new Pair<Integer,Integer>(sindex,pindex));
        }

        if(sindex == -1 && pindex == -1){
            return true;
        }
        if(sindex == -1 && pindex !=-1){
            return false;
        }
        if(sindex != -1 && pindex == -1){
            return false;
        }

        if(s[sindex] == p[pindex]){
            Boolean value = isMatchHelper(s,p,sindex-1,pindex-1);
            cache.put(new Pair<Integer,Integer>(sindex,pindex),value);
            return value;
        }

        if(p[pindex] == '?'){
            Boolean value= isMatchHelper(s,p,sindex-1,pindex-1);
            cache.put(new Pair<Integer,Integer>(sindex,pindex),value);
            return value;
        }

        if(p[pindex] =='*'){
            Boolean value =  isMatchHelper(s,p,sindex,pindex-1) || isMatchHelper(s,p,sindex-1,pindex) || isMatchHelper(s,p,sindex-1,pindex-1);
            cache.put(new Pair<Integer,Integer>(sindex,pindex),value);
            return value;
        }

        cache.put(new Pair<Integer,Integer>(sindex,pindex),false);
        return false;
    }
}
