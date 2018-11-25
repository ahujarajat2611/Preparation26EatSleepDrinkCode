package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by hadoop on 21/9/17.
 */
public class ReverseString3 {
    public static void main(String args[]){

    }
    public static String reverseString(String s){
        Map<Integer,String> punctuationMap = new HashMap<>();
        Stack<String> wordStack = new Stack<>();
        int start =0;
        int end = 0;
        int wordcount = 0;
        while(end <s.length()){
            start = end;
            while(start<s.length() && s.charAt(start) == ' '){
                start++;
            }
            end = start;
            while (end<s.length() && Character.isLetter(s.charAt(end))){
                end++;
            }
            wordcount++;
            if(Character.isLetter(s.charAt(end-1))){
                wordStack.push(s.substring(start,end));
            }
            else{
                punctuationMap.put(wordcount,s.substring(start,end));
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i=1;i<=wordcount;i++){
            if(punctuationMap.containsKey(i)){
                builder.append(punctuationMap.get(i));
            }
            else {
                builder.append(" "+wordStack.pop());
            }
        }
        return builder.toString().trim();
    }
}
