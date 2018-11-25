package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 20/9/17.
 */
public class Palindrome {
    public boolean isPalndrome(String a){
        int start =0;
        int end = a.length()-1;
        while (start<end){
            while (start<end && Character.isSpaceChar(a.charAt(start))){
                start++;
            }
            while (start<end && Character.isSpaceChar(a.charAt(end))){
                end--;
            }
            if(a.charAt(start) != a.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
