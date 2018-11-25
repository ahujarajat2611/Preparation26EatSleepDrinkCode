package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 27/1/18.
 */
public class WildCardBottopUPMy {
    public boolean ismatchingagainbottomup(String s, String p){
        if(p==null || p.length() == 0){
            return s== null || s.length() ==0;
        }
        int rows = s.length();
        int cols = p.length();

        boolean dp [][] = new boolean[rows+1][cols+1];
        dp[0][0] = true;




        /// no need to remove extra ****
        // since i am consderinga ll options
        for(int j=1;j<=p.length();j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-1];
            }
            else{
                dp[0][j] = false;
            }
        }

        for(int i=1;i<=s.length();i++){
            dp[i][0] = false;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1) !='*'){
                    if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) =='?')
                        dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j-1]||dp[i][j-1]||dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
