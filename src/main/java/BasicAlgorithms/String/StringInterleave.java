package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class StringInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!= s3.length()){
            return false;
        }
        boolean[][]dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=0;i<=s1.length();i++){
            for(int j=0;j<=s2.length();j++){
                if( i==0 &&j!=0){
                    dp[0][j] =dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
                    continue;
                }
                if( j==0 && i!=0){
                    dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
                    continue;
                }
                if(i==0 && j==0){
                    dp[0][0] = true;
                    continue;
                }
                dp[i][j] =(dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                        (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public static void main(String args[]){
        StringInterleave stringInterleave = new StringInterleave();
        System.out.println(stringInterleave.isInterleave("raa","jt","rajat"));
    }
}