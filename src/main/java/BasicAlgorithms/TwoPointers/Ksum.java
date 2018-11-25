package BasicAlgorithms.TwoPointers;

import SmallAndAmazingGitBookToGiveYouConfidence.KsumDP;

/**
 * Created by hadoop on 13/10/17.
 */
public class Ksum {
    int ksumtotal(int []num,int k ,int target) {
        int ans [][][] = new int[k+1][target+1][num.length];

        for(int p=0;p<num.length;p++){
            ans[0][0][p]++;
        }

        for(int i=0;i<num.length;i++){
            ans[1][num[i]][i]++;
        }
        System.out.println("k "+k);

        for(int i=2;i<k+1;i++){
            for(int j=0;j<target+1;j++){
                for(int y=1;y<num.length;y++){
                    if(y+1<k){
                        continue;
                    }
                    if(j>=num[y]) {
                        ans[i][j][y] += ans[i - 1][j - num[y]][y - 1];
                    }
                        ans[i][j][y] += ans[i][j][y-1];
                }
            }
        }
        return ans[k][target][num.length-1];
    }
    public static void main(String[] args) {
        Ksum  ksum = new Ksum();
        int []num = {1,2,3,4};
        int target = 5;
        int k =2;
        System.out.println(ksum.ksumtotal(num,2,8));
        System.out.println(ksum.kSum(num,2,8));
        System.out.println(ksum.ksumtotalagain(num,2,5));


    }
    public int kSum(int A[], int k, int target) {
        // write your code here
        if (target < 0) {
            return 0;
        }
        int len = A.length;
        int[][][] dp = new int[k + 1][len + 1][target + 1];
        dp[0][0][0] = 1;

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= len; j++) {
                for (int t = 0; t <= target; t++) {
                    if (i == 0 && t == 0) {
                        dp[i][j][t] = 1;
                    } else if (!(i == 0 || j == 0 || t == 0)) {
                        dp[i][j][t] = dp[i][j-1][t];
                        if (t - A[j - 1] >= 0) {
                            dp[i][j][t] += dp[i - 1][j - 1][t - A[j - 1]];
                        }
                    }
                }
            }
        }
        return dp[k][len][target];
    }
     int kSumshort(int A[], int k, int target) {
        if (target < 0) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[k + 1][target + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int t = target; t > 0; t--) {
                for (int j = 1; j <= k; j++) {
                    if (t - A[i - 1] >= 0) {
                        dp[j][t] += dp[j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        return dp[k][target];
    }

    int ksumtotalagain(int []A,int k ,int target) {
        if(target<0){
            return 0;
        }
        int count [][][] = new int[k+1][A.length+1][target+1];
        count[0][0][0] = 1;
        for(int i=0;i<k+1;i++){
            for(int j=0;j<A.length+1;j++){
                for(int t=0;t<target+1;t++){
                    if(i ==0 && t ==0){
                        count[i][j][t] =1;
                        continue;
                    }
                    if(i!=0 && j!=0 && t!=0){
                        count[i][j][t] = count[i][j-1][t];
                        if(t>=A[j-1]){
                            count[i][j][t]+= count[i-1][j-1][t-A[j-1]];
                            }
                        }
                    }
                }
            }
            return count[k][A.length][target];
        }




    public int kSumBitDifferentInit(int A[], int k, int target) {
        if (k < 1 || target <= 0) {
            return 0;
        }
        int len = A.length;
        int count[][][] = new int[k + 1][len + 1][target + 1];
        for (int i = 1; i <= len; i++) {
            if (A[i - 1] <= target) {
                for (int j = i; j <= len; j++) {
                    count[1][j][A[i - 1]]++;
                }
            }
        }
        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= len; j++) {
                for (int v = 1; v <= target; v++) {
                    count[i][j][v] += count[i][j - 1][v];
                    if (v - A[j - 1] >= 0) {
                        count[i][j][v] += count[i - 1][j - 1][v - A[j - 1]];
                    }
                }
            }
        }

        return count[k][len][target];
    }

    }

    /*


    Method 2: DP
Analysis

count[i][j][v] means choosing i numbers from the first j numbers, which sum up to v. We can update it by:

    count[i][j][v] += count[i][j - 1][v] which means not choosing the new number.
    count[i][j][v] += count[i - 1][j - 1][v - nums[j]] which means choosing the new number.

Complexity

Time: O(len k target)

Space: O(len k target)
Code
Java
     */





