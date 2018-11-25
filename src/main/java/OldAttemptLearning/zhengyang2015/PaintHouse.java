package OldAttemptLearning.zhengyang2015;

/**
 * Created by hadoop on 23/8/17.
 */
public class PaintHouse {
    public static void main(String[] args) {
        int costs[][] =  {{14,2,11},
                {11,14,5},
                {14,3,10}};
            int ans = answer(costs);
        System.out.println(ans);
    }

    private static int answer(int[][] costs) {
        int numberofhouse = costs.length;
        int dp[][] = new int[costs.length+1][costs[0].length];
        for( int i=0;i<costs.length+1;i++){
            for ( int j=0;j<costs[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for ( int i=0;i<costs[0].length;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=costs.length;i++){
            for (int j=0;j<3;j++){
                for(int k =0;k<3  ;k++) {
                    if(k == j){
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i-1][j]);
                    System.out.println("ams i and j "+ i+" "+j+" "+k+ " "+dp[i][j]);
                }
            }
        }

        System.out.println(dp[costs.length][2]);
        System.out.println(dp[costs.length][1]);
        System.out.println(dp[costs.length][0]);

        return 1;
      //  return Math.min(Math.min(dp[costs.length][0],dp[costs.length][1]),dp[costs.length][2]);
    }
    //red green blue
}
