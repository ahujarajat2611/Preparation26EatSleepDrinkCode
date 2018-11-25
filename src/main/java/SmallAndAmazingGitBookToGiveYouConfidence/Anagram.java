package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class Anagram {
    int ascii = 256;
    boolean anagram(String a, String b){
        int [] count = new int[ascii];
        for(char c:a.toCharArray()){
            count[c]+=1;
        }
        for(char c:b.toCharArray()){
            count[c]-=1;
            if(count[c]<0){
                return false;
            }
        }
        return true;
    }
}
