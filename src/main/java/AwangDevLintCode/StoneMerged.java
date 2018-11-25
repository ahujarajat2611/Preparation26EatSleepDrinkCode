package AwangDevLintCode;

/**
 * Created by hadoop on 24/2/18.
 */
public class StoneMerged {
    int search(int l, int r, int[][] f, int[][] visit, int[][] sum) {
        if(l>r){
            return 0;
        }

        if(visit[l][r] == 1) {
            return f[l][r];
        }

        if(l == r) {
            visit[l][r] = 1;
            return f[l][r];
        }

        f[l][r] = Integer.MAX_VALUE;
        /// deal such problems in recutsion reallly easy to solve solutions
        /// here breaking point has lots of significance
        // you can just randomly choose point
        // think carefuly had you put k<=r its a infinte recursion calll !!

        // k <r to avoid recursion
        // it cant be k<=r ( does not make sense overlfow it will be )\
        for (int k = l; k < r; k++) {
            f[l][r] = Math.min(f[l][r], search(l, k, f, visit, sum) + search(k + 1, r, f, visit, sum) + sum[l][r]);
        }

        visit[l][r] = 1;
        return f[l][r];
    }

    public int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;

        // initialize
        int[][] f = new int[n][n];
        int[][] visit = new int[n][n];

        for (int i = 0; i < n; i++) {
            f[i][i] = 0;
        }

        // preparation
        int[][] sum = new int[n][n];

        // thats how you preapre sum array
        // sum(i)(j) --->> to calculate sum from i to jth aray !!!!

        for (int i = 0; i < n; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }

        return search(0, n-1, f, visit, sum);
    }

    public static void main(String[] args) {
        StoneMerged stoneMerged = new StoneMerged();
        System.out.println(stoneMerged.stoneGame(new int[]{4, 1, 1, 4}));
    }
}
