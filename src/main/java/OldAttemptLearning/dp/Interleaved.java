package OldAttemptLearning.dp;

/**
 * Created by hadoop on 11/8/17.
 */
public class Interleaved {
    public static void main(String args[]){
        String a = "ACBCD";
        String b = "ABC";
        String c = "CD";

        boolean ans = isinterleaved(a,b,c,a.length()-1,b.length()-1,c.length()-1);
        System.out.println("ans"+ans);
    }

    private static boolean isinterleaved(String a, String b, String c, int i, int i1, int i2) {
        if(i<0 && i1<0 &&i2<0){
            return true;
        }
        if(i<0){
            return false;
        }
        boolean ans = false;
        System.out.println("false");

        if(i1 >=0  && a.charAt(i) == b.charAt(i1)){
            System.out.println("here");
            ans = isinterleaved(a,b,c,i-1,i1-1,i2);
        }
        if(ans) return ans;
        if(i2 >=0 && a.charAt(i) == c.charAt(i2)){
            System.out.println("here");
            ans = isinterleaved(a,b,c,i-1,i1,i2-1);
        }
        return ans;
    }
}
