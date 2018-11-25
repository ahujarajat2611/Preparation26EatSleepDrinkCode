package OldAttemptLearning.zhengyang2015;

/**
 * Created by hadoop on 23/8/17.
 */
public class Backpack {
    //The second method dp [i] [j] that the first i pieces
    //
    //
    // of goods can fill the capacity of j backpack.
    // In the case of the first case, the dp [i] [J] = dp [i-1] [j - A [j]],
    // but this condition requires j - A [j]> 0.
    // Take two cases inside the larger value as dp [i] [j].+


    public int backpack(int m , int []array){
        if(m ==0 || array == null || array.length == 0){
            return 0;
        }
        int n = array.length;
        int [][] fillpack = new int[n+1][m+1];
        for( int i=0;i<=n;i++){
            fillpack[i][0] = 1;
            // one way to not to selecct any item
        }

        for(int j=0;j<=n;j++){
            fillpack[0][j] = 0;
            // with o items we can fill up
        }
        fillpack[0][0] = 1;


        for ( int i=1;i<=n;i++){
            // all items
            for (int j=1;j<=m;j++)
                // all size of backpack
                if(array[i-1]<=j){
                // if we can fill backup with i-1 elementts
                fillpack[i][j] = fillpack[i-1][j] | fillpack[i-1][j-array[i-1]];
                }
                else{
                    fillpack[i][j] = fillpack[i-1][j];
                }
        }
        for(int i=m;i>=0;i--){
            if(fillpack[n][i] == 1){
                // mmax amout we can fill
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int [] array = { 2, 3, 5, 7};
        int m = 10;
        int []value = {1,5,2,4};
        Backpack backpack = new Backpack();

        System.out.println(backpack.backpackdifferentwhereorderchangeswithrelationship(array,10));
        System.out.println(backpack.onedvaluetotalwayswithoutreptitions(10,array));
        System.exit(1);
        int ksumarray[] = {1,4,7,10,12,15,16,18,21,23,24,25,26,29};
        int k = 5;
        int sum = 113;
        System.out.println( backpack.kSum(ksumarray,k,sum));
        System.out.println(backpack.kSumAgain(ksumarray,k,sum));
        System.out.println(backpack.kSumshort(ksumarray,k,sum));

        System.exit(1);








        int ans = backpack.backpack(m,array);
        int ansvalue = backpack.backpackvalue(m,array,value);
        int valueagain = backpack.onedvaluereptitions(m,array,value);
        System.out.println(ansvalue);
        System.out.println(valueagain);
        int []arrayagain = {1,2,4};
        int targetagain = 4;
        int totalways = backpack.onedvaluetotalwaysreptitions(targetagain,arrayagain);
        System.out.println("totalways"+totalways);
        int arrayagainagain[] = {1,2,3,3,7};
        int totalwayswithoutreptition = backpack.onedvaluetotalwayswithoutreptitions(targetagain,arrayagainagain);
        System.out.println("total ways without reptitions"+totalwayswithoutreptition);
    }

    private int onedvaluetotalwayswithoutreptitions(int m, int[] array) {
        int f[] = new int[m+1];
        f[0] = 1;

        for( int i=0;i<array.length;i++){
            for( int j = m;j>=array[i];j--){
                f[j] = f[j]+f[j-array[i]];
            }
        }
        return f[m];
    }

    public int backpackvalue(int m , int []array,int []value){
        if(m ==0 || array == null || array.length == 0){
            return 0;
        }
        int n = array.length;
        int [][] fillpack = new int[n+1][m+1];
        for( int i=0;i<=n;i++){
            fillpack[i][0] = 0;
        }

        for(int j=0;j<=n;j++){
            fillpack[0][j] = 0;
        }
        fillpack[0][0] = 0;

        // max we can get frmo backpacklk
        for ( int i=1;i<=n;i++){
            for (int j=1;j<=m;j++)
                if(array[i-1]<=j){
                    fillpack[i][j] = Math.max(fillpack[i-1][j] ,fillpack[i][j-array[i-1]] +value[i-1]);
                }
                else{
                    fillpack[i][j] = fillpack[i-1][j];
                }
        }
        return fillpack[n][m];
    }

    int onedvalue( int m, int []array, int[] value){

        int f[] = new int[m+1];

        for( int i=0;i<array.length;i++){
            for( int j = m;j>=array[i];j--){
                // travese in reverse direction if takin 1 d array
                f[j] = Math.max(f[j],f[j-array[i]]+value[i]);
            }
        }
        return f[m];

    }
    int onedvaluereptitions( int m, int []array, int[] value){

        int f[] = new int[m+1];

        for( int i=0;i<array.length;i++){
            for( int j = array[i];j<=m;j++){
                // travsse in forward directions if repritions allowed
                f[j] = Math.max(f[j],f[j-array[i]]+value[i]);
            }
        }
        return f[m];

    }

    int onedvaluetotalwaysreptitions( int m, int []array){
        int f[] = new int[m+1];
        f[0] = 1;

        for( int i=0;i<array.length;i++){
            for( int j = array[i];j<=m;j++){
                // here also repitions alooswd in forward direction
                f[j] = f[j]+f[j-array[i]];
            }
        }
        return f[m];

    }
    public int backpackdifferentwhereorderchangeswithrelationship(int [] nums, int target){
        int dp[] = new int[target+1];
        dp[0] = 1;
        for( int i=1;i<= target;i++){
            for( int j=0;j<nums.length;j++){
                if(i-nums[j]>=0){
                    dp[i] = dp[i] + dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
    public int kSum(int A[], int k, int target) {
        int[][] dp = new int[k + 1][target + 1];
        dp[0][0] = 1;
            for (int i = 1; i<=A.length; i++) {
                    for (int m = target; m >= 1; m--) {
                        for (int j = 1; j <=k; j++) {
                            if (m - A[i - 1] >= 0) {
                        dp[j][m] += dp[j - 1][m - A[i - 1]];
                    }
                }
            }
        }
        return dp[k][target];
        /*
           for (int i = 1; i <= len; i++) {
            for (int t = target; t > 0; t--) {
                for (int j = 1; j <= k; j++) {
                    if (t - A[i - 1] >= 0) {
                        dp[j][t] += dp[j - 1][t - A[i - 1]];
                    }
                }
            }
        }
         */
    }
    public int kSumAgain(int A[], int k, int target) {

         int[][] dp = new int[k + 1][target + 1];
         dp[0][0] = 1;
         for (int i = 1; i <= A.length; i++) {
             for (int j = Math.min(k, i); j >= 1; j--) {
                 for (int m = target; m >= 1; m--) {
                     if (m - A[i - 1] >= 0) {
                         dp[j][m] += dp[j - 1][m - A[i - 1]];
                     }
                 }
             }
         }
         return dp[k][target];
    }
    int kSumshort(int A[], int k, int target) {
        if (target < 0) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[k + 1][target + 1];
 // very imp iniitlizaton here
        dp[0][0] = 1;
        // treat it as backup sum
        // and later add kth layer that aobolutely make sens e

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
}
