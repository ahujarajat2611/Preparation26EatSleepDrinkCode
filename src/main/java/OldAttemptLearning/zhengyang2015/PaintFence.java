package OldAttemptLearning.zhengyang2015;

/**
 * Created by hadoop on 23/8/17.
 */
public class PaintFence {
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int ans = dp(n,k);
        System.out.println("ans"+ans);
    }

    private static int dp(int n, int k) {
     //   int dp[] = new dp[n+1];
        int samelasttwo [] = new int[n+1];
        int difflasttwo [] = new int[n+1];

        samelasttwo[1] = 0;
        difflasttwo[1] = k;


        for( int i=2;i<=n;i++){
            samelasttwo[i] = difflasttwo[i-1];
            difflasttwo[i] = samelasttwo[i-1]*(k-1)+difflasttwo[i-1]*(k-1) ;
        }

        return samelasttwo[n] + difflasttwo[n];
    }

}
