package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 4/1/18.
 */
public class ControlAsolution {
    public int maxA(int N) {
        int[] dp = new int[N+1];
        for(int i=1;i<=N;i++){
            dp[i] = i;
            for(int j=3;j<i;j++){
                dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
            }
        }
        return dp[N];
    }
    /*
    dp[i] = max(dp[i], dp[i-j]*(j-1)) j in [3, i)


     */
}
