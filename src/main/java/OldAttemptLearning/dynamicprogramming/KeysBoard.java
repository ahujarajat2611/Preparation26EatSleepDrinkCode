package OldAttemptLearning.dynamicprogramming;

/**
 * Created by hadoop on 5/8/17.
 */
public class KeysBoard {
    static int copy = 0;
    public static void main(String[] args) {

        //int n = 7;
        //int x = maxAs(n,0);
        //System.out.println(f(n));
        for(int n = 3;n<20;n++){
            System.out.println("ques"+n);
            System.out.println("ans1  "+f(n));
            System.out.println("ans2  "+findoptimal(n));
            System.out.println("ans3 "+maxA(n));
            System.out.println("ans4 "+maxAMine(n));
           // System.out.println("ans3  "+solve(n));
            System.out.println("==============");
        }
    }
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



//    private static int maxAs(int n,int cv) {
//        if(n==0){
//            return 0;
//        }
//        if(n ==1){
//            return 1;
//        }
//        if ( n ==2){
//            return 2;
//        }
//        if(cv ==1){
//            copy = Math.max(copy,)
//        }
//        int x =  Integer.MIN_VALUE;
//
//        x= Math.max(x,Math.max(Math.max(Math.max(maxAs(n-1,0)+1,maxAs(n-1,0)),maxAs(n-2,0)),2*maxAs(n-3,1)));
//        if(x ==1){
//            x = Math.max(x,maxAs(n-1,1)+copy;
//        }
//    }

    static int f( int n )
    {
        int DP[] = new int[n+1];

        if(n<=3)return n;
        DP[1]=1;
        DP[2]=2;
        DP[3]=3;

        int copied=0,i,val;

        for( i=4;i<=n;i++ )
        {
            val= Math.max( DP[i-3]*2 , DP[i-1]+1 );

            if( copied > 0 )
                val=Math.max( val , DP[i-1] + copied );

            if( val == DP[i-3]*2 )
                copied=Math.max( copied , DP[i-3] );

            DP[i]=val ;

        }

        return DP[n] ;

    }
    static int  findoptimal(int N)
    {
        // The optimal string length is N when N is smaller than 7
        if (N <= 6)
            return N;

        // Initialize result
        int max = 0;

        // TRY ALL POSSIBLE BREAK-POINTS
        // For any keystroke N, we need to loop from N-3 keystrokes
        // back to 1 keystroke to find a breakpoint 'b' after which we
        // will have Ctrl-A, Ctrl-C and then only Ctrl-V all the way.
        int b;
        for (b=N-3; b>=1; b--)
        {
            // If the breakpoint is s at kb'th keystroke then
            // the optimal string would have length
            // (n-b-1)*screen[b-1];
            int curr = (N-b-1)*findoptimal(b);
            if (curr > max)
                max = curr;
        }
        return max;
    }
    static int solve(int n) {
        int f[][] = new int[100][4];
        f[0][0] = 1;
        for(int i = 1; i < n; i++)
            for(int j = 0; j < 4; j++)
                for(int k = 0; k < 4; k++)
                {
                    if (j == 0) // add A
                    {
                        f[i][j] = Math.max(f[i][j], f[i-1][k] + 1);
                    }
                    else if (j == 1) // ctrl+A
                    {
                        f[i][j] = Math.max(f[i][j], f[i-1][k]);
                    }
                    else if (j == 2) // ctrl+C
                    {
                        if (k == 1) // only previous is ctrl+A makes ctrl+C available
                            f[i][j] = Math.max(f[i][j], f[i-1][k]);
                    }
                    else if (j == 3) //ctrl+V
                    {
                        if (k == 2)
                            f[i][j] = Math.max(f[i][j], f[i-1][k] * 2);
                    }
                }

        return Math.max(f[n-1][3], f[n-1][0]);
    }
    public static int maxA(int N) {
        int[] dp = new int[N+1];
        for(int i=1;i<=N;i++){
            dp[i] = i;
            for(int j=3;j<i;j++){
                dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
            }   
        }
        return dp[N];
    }
}
