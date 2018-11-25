package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 19/9/17.
 */
public class ReverseIngeter {
    public static void main(String[] args) {

    }
    public  int reverse(int n){
        int result = 0;
        while (n>0){
            if(result> Integer.MAX_VALUE/10){
                return 0;
            }
            result = result*10 + n%10;
            n = n/10;
        }
        return result;
    }
}
