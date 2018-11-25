package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 24/12/17.
 */
public class DeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] f = new int[n + 1][m + 1];
        // for(int i=0;i<n+1;i++){
        //     Arrays.fill(f[i],Integer.MAX_VALUE);
        // }


        // min sum to be deleted so that both strings become equal
        // sum means char ascii weight
        for (int i = 1; i <= n; i++)
            f[i][0] = f[i - 1][0] + s1.charAt(i - 1);
        for (int j = 1; j <= m; j++)
            f[0][j] = f[0][j - 1] + s2.charAt(j - 1);
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++) {
                f[i][j] = 122*(i+j);
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    // if chars are equal nothing to be deleted
                    f[i][j] = Math.min(f[i][j],f[i-1][j-1]);
                }
                else{
                    f[i][j] = Math.min(f[i][j],Math.min(f[i-1][j] +s1.charAt(i-1),f[i][j-1]+s2.charAt(j-1)));
                }
            }
        }
        return f[n][m];
    }
    /*
    // wta a solution ...
       int minimumDeleteSum(string s1, string s2) {
        int n1 = s1.size(), n2 = s2.size();
        int dp[n1+1][n2+1] = {};
        for (int i1 = 1; i1 <=n1; ++i1) for (int i2 = 1; i2 <=n2; ++i2)  {
            int ans = 0;
            ans = max(dp[i1][i2-1], dp[i1-1][i2]);
            if (s1[i1-1]==s2[i2-1]) ans = max(ans, (int)s1[i1-1] + dp[i1-1][i2-1]);
            dp[i1][i2] = ans;
        }
        int ret = 0;
        for (auto c:s1) ret +=c;
        for (auto c:s2) ret +=c;
        ret -= 2*dp[n1][n2];
        return ret;

    }


     */
}
