package BasicAlgorithms.String;

import java.util.HashMap;

/**
 * Created by hadoop on 23/10/17.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String word[] = str.split(" ");
        HashMap<Character,String> patternMap = new HashMap<>();
        if(word.length != pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            Character pat = pattern.charAt(i);
            if(!patternMap.containsKey(pat)){
                if(patternMap.containsValue(word[i])){
                    return false;
                }
            }
            else {
                String wordInMap = patternMap.get(pat);
                if(!wordInMap.equals(word[i])){
                    return false;
                }
            }
            patternMap.put(pat,word[i]);
        }
        return true;
    }
}
