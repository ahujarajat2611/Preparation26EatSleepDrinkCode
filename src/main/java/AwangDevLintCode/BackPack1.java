package AwangDevLintCode;

/*
Given n items with size Ai, an integer m denotes the size of a backpack.
How full you can fill this backpack?

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5],
so that the max size we can fill this backpack is 10.
If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

Note
You can not divide any item into small pieces.

Challenge
O(n x m) time and O(m) memory.

O(n x m) memory is also acceptable if you do not know how to optimize memory.

Tags Expand
LintCode Copyright Dynamic Programming Backpack

 */
/**
 * Created by hadoop on 3/2/18.
 */
/*
    Thoughts: Recap on 12.02.2015
    State
    DP[i][j]: i is the index of Ai, and j is the size from (0 ~ m).
        It means: depending if we added A[i-1], can we full-fill j-space? Return ture/false.
        Note: that is, even j == 0, and I have a item with size == 0. There is nothing to add, which means the backpack can reach j == 0. True.
        However, if we have a item with size == 2, but I need to fill space == 1.
        I will either pick/not pick item of size 2; either way, can't fill a backpack with size 1. False;
    Function:
    // here we are reduciing i to i-1 in case of dulicates we would have avoided that !!!

        DP[i][j] = DP[i - 1][j] || DP[i - 1][j - A[i - 1]];   // based on if previous value is true/false: 1. didn't really add A[i-1] || 2. added A[i-1].
    Init:
        DP[0][0] = true; // 0 space and 0 items, true.
        All the rest are false;

    Return the very last j that makes dp[A.length][j] true.
*/
public class BackPack1 {
    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0 || m <= 0) {
            return 0;
        }
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        dp[0][0] = true;

        // i number of elements and j is sum
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                //j is large enough:
                if (j - A[i - 1] >= 0) {
                    //not added A[i - 1] or added A[i - 1]
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                } else {// j not large enough, ofcourse not adding A[i-1]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //Largest possible size with dp[j] == true
        for (int j = m; j >= 0; j--) {
            if (dp[A.length][j]) {
                return j;
            }
        }
        return 0;
    }
    public int backPackRecursive(int m, int[] A,int i,int j) {
        if( j==m){
            return 1;
        }
        if(j>m){
            return 0;
        }
        if(i >=A.length){
            return 0;
        }

        int totalWays = 0;
        // starting point --> options whether to pick that element or not to pick that elements // thats how it is is
        totalWays = totalWays + backPackRecursive(m,A,i+1,j);
        totalWays = totalWays + backPackRecursive(m,A,i+1,j+A[i]);

        return totalWays;
    }

    public int backPackRecursiveAnother(int m, int[] A,int i,int j) {
        if( j==m){
            return 1;
        }
        if(j>m){
            return 0;
        }
        if(i >=A.length){
            return 0;
        }
        int totalWays = 0;
        // here ordering of array elements does not
        /// matter hence we can follow one sqeuencee
        // starting points --->> options ---> backtracck onn sum variable ( thats how simple it is )

        for(int index = i;index<A.length;index++) {
            j = j + A[index];
            totalWays = totalWays + backPackRecursive(m, A, index + 1, j);
            j = j -A[index];
        }
        return totalWays;
    }
/*
1D array: memory mxn, space m. Tricky tho ...

Looking at the 2D version, we are really just checking the DP with fixed i=A.length.

DP[j]: can we fit i items into j?
DP[j] == false || DP[j - A[i - 1]].
Similar two cases:
1. Can't fit in, set false;
2. Can fit in, then just return if (j - A[i - 1]) works

Core difference: only set the DP[j] when (j - A[i - 1] >= 0 && DP[j - A[i - 1]]): since we are running from m ~ 0, we don't want to override some existing values
*/
public int backPackAgain(int m, int[] A) {
    if (A == null || m == 0) {
        return 0;
    }

    boolean[] DP = new boolean[m + 1];
    DP[0] = true;
    for (int i = 1; i <= A.length; i++) {
        for (int j = m; j >= 0; j--) {
            // very imp if condition, just look at it again and again !!!
            if (j - A[i - 1] >= 0 && DP[j - A[i - 1]]) {
                DP[j] = true;
            }
        }
    }

    for (int j = m; j >= 0; j--) {
        if (DP[j]) {
            return j;
        }
    }
    return 0;
}
public static void main(String args[]){
    BackPack1 backPack1 = new BackPack1();
    System.out.println(backPack1.backPackRecursive(4,new int[]{1,1,2,3,4},0,0));
    System.out.println(backPack1.backPackRecursiveAnother(4,new int[]{1,1,2,3,4},0,0));
}
}
