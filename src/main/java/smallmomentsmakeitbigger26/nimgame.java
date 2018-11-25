package smallmomentsmakeitbigger26;
//Data Structure: DP || Math
//If the sum of stones are not multiple of 4. Then the first one can win.
//dp[i] = !dp[i - 1] && !dp[i - 2] && !dp[i - 3];
//public class Solution {
//    public boolean canWinNim(int n) {
//        return n % 4 != 0;
//    }
//}


public class nimgame {
    public boolean canWinNim(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for (int i = 4; i <= n; i++){
            dp[i] = !dp[i - 1] && !dp[i - 2] && !dp[i - 3];
        }
        return dp[n];
    }
}


/**
 * Created by hadoop on 23/10/17.
 */
class NimGame {
    public boolean canWinNim(int n) {
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n == 2){
            return true;
        }

        if(n == 3){
            return true;
        }

        if(!canWinNim(n-1) || !canWinNim(n-2) || !canWinNim(n-3)){
            return true;
        }
        return false;
    }
    boolean [] cache;
    public boolean canWinNimite(int n) {
        cache = new boolean[n+1];
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(n == 2){
            return true;
        }

        if(n == 3){
            return true;
        }

        cache[0] = false;
        cache[1] = true;
        cache[2] = true;
        cache[3] = true;

        for(int i=4;i<=n;i++){
            cache[i]  = (!cache[i-1] || !cache[i-2] || !cache[i-3]);
        }

        return cache[n];
    }
}