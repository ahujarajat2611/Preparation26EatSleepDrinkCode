package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*
Thoughts:
Find total number of ways. Think of DP.
At last two letters: treat them as 2 separeate letters, or (if possible) treat them as combo.
dp[i]: # ways to decode at index i.
dp[i - 1]: # ways to decode s[0, i-1]
dp[i - 2]: # ways to decode s[0, i-2]
dp[i] = dp[i-1] + dp[i-2]

init:
dp[0] = decode s[0,0]: 0
dp[1] = decode s[0, 1]: 1
dp[2] = decode s[0, 2]: 1 or 2
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigit <= 26 && twoDigit >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int numDecodingsMine(String s) {
        // IF STARITNG WITH ZERO not possible to decode it
        if (s == null || s.length() == 0 || s.equals("0")) {
            return 0;
        }

        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        // 1 to 9
        dp[1] = valid(s.substring(0,1));

        for(int i=2;i<=s.length();i++){
            int totalways = 0;
                totalways = totalways + dp[i-1]*valid(s.substring(i-1,i));
                totalways = totalways + dp[i-2]*validtwochar(s.substring(i-2,i));
                dp[i] = totalways;
        }
        return dp[s.length()];
    }

    private int validtwochar(String substring) {
        int x = Integer.parseInt(substring);
        if (x>=10 && x<=26){
            return 1;
        }
        return 0;
    }

    private int valid(String substring) {
        if(substring.equals("0")){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodingsMine("23150"));
    }

}
