package BasicAlgorithms.String;

/**
 * Created by hadoop on 15/10/17.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int dp[] = new  int[s.length()+1];
        dp[0] = 1;
        if(isvalid(s.substring(0,1))){
            dp[1] = 1;
        }
        else {
            dp[0] = 0;
        }
        for(int i=2;i<=s.length();i++){
            dp[i]=0;
            if(isvalid(s.substring(i-1,i))) {
                dp[i] += dp[i - 1];
            }
            if(isvalid(s.substring(i-2,i))){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    private boolean isvalid(String s) {

        if(s.charAt(0)=='0'){
            return false;
        }
        int element = Integer.parseInt(s);
        if(1<=element&& element<=26){
            return true;
        }
        return false;
    }
}

class recursive{
    public int numdecodings(String s){
        if(s.length() == 0){
            return 0;
        }
        return dfs(s);
    }

    private int dfs(String s) {
        if(s.length() == 0){
            return 1;
        }
        int total =0;
        for(int i=0;i<=1 && i<s.length();i++){
            if(isvalid(s.substring(0,i+1))) {
                total += numdecodings(s.substring(i+1));
            }
        }
        return total;
    }
    private boolean isvalid(String s) {

        if(s.charAt(0)=='0'){
            return false;
        }
        int element = Integer.parseInt(s);
        if(1<=element&& element<=26){
            return true;
        }
        return false;
    }
}