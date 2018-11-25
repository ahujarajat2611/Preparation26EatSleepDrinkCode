package OldAttemptLearning.dp;

/**
 * Created by hadoop on 12/8/17.
 */
public class NoOfSub {
    public static void main(String[] args) {
        String x = "subsequence";
        String y="sue";
        int ans = countsubsequences(x,y,x.length()-1,y.length()-1);
        System.out.println("ans"+ans);

    }

    private static int countsubsequences(String x, String y, int i, int i1) {
        if(i1<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(x.charAt(i) == y.charAt(i1)){
            return countsubsequences(x,y,i-1,i1-1) + countsubsequences(x,y,i-1,i1);
        }
        else{
            return countsubsequences(x,y,i-1,i1);
        }
    }
}
