package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 13/12/17.
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        long[] res = new long[2];
        res[0] = ways(s.charAt(0));
        if(s.length() < 2) return (int)res[0];

        res[1] = res[0] * ways(s.charAt(1)) + ways(s.charAt(0), s.charAt(1));
        for(int j = 2; j < s.length(); j++) {
            long temp = res[1];
            res[1] = (res[1] * ways(s.charAt(j)) + res[0] * ways(s.charAt(j-1), s.charAt(j))) % 1000000007;
            res[0] = temp;
        }
        return  (int)res[1];
    }
    public static int numDecodingsDp(String s) {
        long []dp = new long[s.length()+1];
        dp[0] = 1l;
        dp[1] = ways(s.charAt(0))*dp[0];
        for(int i=2;i<=s.length();i++){
            dp[i] = (ways(s.charAt(i-1))*dp[i-1]  + ways(s.charAt(i-2),s.charAt(i-1))*dp[i-2])%1000000007;
        }
        return (int)dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodingsDp("1*"));
    }
    private static int ways(int ch) {
        if(ch == '*') return 9;
        if(ch == '0') return 0;
        return 1;
    }

    // how many 2 chars word can be formed !!! thats what this function
    // should return !!!
    private static int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 15;
        } else if(ch1 == '*') {
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            else
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                return 6;
            }
        }
        return 0;
    }
}
