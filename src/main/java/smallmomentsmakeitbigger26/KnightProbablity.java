package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 13/12/17.
 */
public class KnightProbablity {
//    static int dx []={1,2,-1,-2,1,2,-1,-2};
//    static int dy[] = {2,1,2,1,-2,-1,-2,-1};
//    public static double knightProbability(int N, int K, int r, int c) {
//        double [][][]cache = new int[K+1][N][N];
//            return knightProbabilityHelper(N,K,r,c,cache);
//    }
//
//    private static double knightProbabilityHelper(int n, int k, int r, int c, double[][][] cache) {
//        if(outside(r,c)){
//            return 0;
//        }
    // if(k ==0){
     //   return 1;
    //}
//        if(cache[k][r][c]!=0){
//
//        }
//        double ans =0;
//        for(int i=0;i<8;i++){
//            int newx = r + dx[i];
//            int newy = c + dy[i];
//            ans = ans + knightProbabilityHelper(n,k-1,newx,newy,cache)/8;
//        }
//        cache[k][r][c] = ans;
//        return ans;
//    }
static final int[][] delta = new int[][] {
        {1,2},{-1,2},{-1,-2},{1,-2},
        {2,1},{-2,1},{-2,-1},{2,-1}
};

    static double[][][] memo;

    public static double knightProbability(int N, int K, int r, int c) {
        memo = new double[N][N][K+1];
        return recur(N,K,r,c);
    }

    private static double recur(int N, int k, int r, int c) {
        if (!(r < N && r > -1 && c < N && c > -1)) return 0;
        if (k == 0) return 1;
        if (memo[r][c][k] != 0) return memo[r][c][k];
        double accum = 0;
        /// WATTTTA SOLUTION IT IS
        /// JUST AWWESOME IT IS
        for (int[] d : delta) {
            accum += (recur(N,k-1,r+d[0],c+d[1])/8);
        }
        memo[r][c][k] = accum;
        return memo[r][c][k];
    }
    /*

    Thinking .. How can i reach to a particular place frmo diff diff places ...

    private int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;
        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir : dirs) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp[step][i][j] += dp[step - 1][x][y] * 0.125;
                    }
                }
            }
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[K][i][j];
            }
        }
        return res;
    }
     */
}