package DSA.Mathematical;

/**
 * Created by hadoop on 4/3/18.
 */
public class MaxAMine {
    public static int maxAMine(int N) {

        int dp [] = new int[N+1];
        dp[0] =0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int end =4;end<=N;end++){
            dp[end] = end;
            for(int i=1;i<=end;i++) {
                dp[end] = Math.max(dp[end],dp[i]*(end-i-2+1));
            }
        }
        return dp[N];
    }
}
