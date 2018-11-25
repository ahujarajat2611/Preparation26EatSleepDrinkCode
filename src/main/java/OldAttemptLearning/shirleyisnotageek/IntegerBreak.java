package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 18/1/18.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<i+1; j++){
                //if(i+j<=n){
                dp[i]=Math.max(Math.max(dp[i-j],i-j)*Math.max(dp[j],j), dp[i]);
                //}
            }
        }

        return dp[n];
    }
}
