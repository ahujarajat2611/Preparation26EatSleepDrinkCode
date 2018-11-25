package OldAttemptLearning.dp;

/**
 * Created by hadoop on 11/8/17.
 */
public class WildMatching {
    public static void main(String[] args) {
        String a= "xyxzzxy";
        String b ="***";
        boolean match = ismatch(a, b,a.length()-1,b.length()-1);
        System.out.println("match"+match);
    }

    private static boolean ismatch(String text, String pattern, int i, int i1) {

        if(i<0 &&i1<0){
            return true;
        }
        if(i<0){
            while(i1 >= 0){
                if(pattern.charAt(i1)!='*'){
                    return false;
                }
                i1--;
            }
            return true;
        }
        if(i1<0){
            return false;
        }


        if(pattern.charAt(i1)=='*'){
            return ismatch(text,pattern,i,i1-1)||ismatch(text,pattern,i-1,i1);
        }
        if(pattern.charAt(i1)=='?' || pattern.charAt(i1) ==text.charAt(i)){
            return ismatch(text,pattern,i-1,i1-1);
        }
        return false;
    }
}
