package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class StrStr {
    int strStr(String source,String target){

        for(int start=0;start<=source.length()-target.length();start++){
            int lengthMatched = 0;
            while (lengthMatched<target.length() && source.toCharArray()[start+lengthMatched]==target.toCharArray()[lengthMatched]){
                lengthMatched++;
            }
            if(lengthMatched == target.length()){
                return start;
            }
        }
        return -1;
    }
}
