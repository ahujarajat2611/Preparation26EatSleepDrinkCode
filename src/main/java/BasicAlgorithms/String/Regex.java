package BasicAlgorithms.String;
import java.util.*;

/**
 * Created by hadoop on 22/12/17.
 */
/*
The matching should cover the entire input string (not partial).
The function prototype should be:

bool isMatch(String str, String patter)
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa","a{1,3}") → true
isMatch("aaa","a{1,3}") → false
isMatch("ab","a{1,3}b{1,3}") → true
isMatch("abc","a{1,3}b{1,3}c") → true
isMatch("abbc","a{1,3}b{1,2}c") → false
isMatch("acbac","a{1,3}b{1,3}c") → false
isMatch("abcc","a{1,3}b{1,3}cc{1,3}") → true
 */
public class Regex {
    public static ArrayList<String> getPatternOptions(char prev, String subStr){

        int lowerB = Integer.valueOf(subStr.split(",")[0]);
        int upperB = Integer.valueOf(subStr.split(",")[1]);

        ArrayList<String> options = new ArrayList<>();
        String subPattern = "";
        for (int i = lowerB; i < upperB; i++){ // we already used one char in the previous comparision
            subPattern += prev;
            options.add(subPattern);
        }

        return options;
    }
    public static boolean isMatcheeing(String input, String pattern){

        char prevPattern = Character.MIN_VALUE;
    for (int i = 0; i < input.length(); i++){
        if (input.charAt(i) != pattern.charAt(i)){
            if (pattern.charAt(i) == '{'){
                String inBrace = "";
                for (int j = i+1; j < i+5; j ++){ // this is constant time
                    if (pattern.charAt(j) == '}'){
                        ArrayList<String> options = getPatternOptions(prevPattern, inBrace);
                        boolean valid = false;
                        for (String subpattern : options){
                            String comparee = input.substring(0, i) + subpattern;
                            if (input.startsWith(comparee)){
                                valid |= isMatcheeing(input.substring(comparee.length()), pattern.substring(j+1));
                            }
                        }
                        return valid;
                    } else {
                        inBrace += pattern.charAt(j);
                    }
                }
            } else {
                return false;
            }
        }
        prevPattern = pattern.charAt(i);
    }
    return true;
}

}
