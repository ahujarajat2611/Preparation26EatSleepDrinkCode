package PracticeOneWeek26;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 7/12/17.
 */
public class BackPack {
    public int backPack(int m, int[] A) {
        int dp[][] = new int[A.length + 1][m + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] += dp[i - 1][j];
                if (A[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - A[i - 1]];
                }
            }
        }

        for (int k = m; k >= 0; k--) {
            if (dp[A.length][k] > 0) {
                return k;
            }
        }
        return 0;

    }
List<Integer> list = new ArrayList<Integer>();
    public int backPack(int m,int start, int[] A) {
        if(m == 0){
            System.out.println(list);
            return 1;
        }
        if(m<0 || start>=A.length){
            return 0;
        }

        int totalWays = 0;
        for(int i = start;i<A.length;i++){
           // if(m>=A[i]) {
                list.add(A[i]);
                totalWays += backPack(m - A[i], i + 1, A);
                list.remove(list.size()-1);
            //}
            //totalWays += backPack(m,i+1,A);
        }
        return totalWays;
    }


    public int backPackFront(int m,int start, int[] A,int total) {
        if(m == total){
            System.out.println(list);
            return 1;
        }
        if(m>total || start>=A.length){
            return 0;
        }

        int totalWays = 0;
        for(int i = start;i<A.length;i++){
            //if(m>=A[i]) {
                list.add(A[i]);
                totalWays += backPackFront(m +A[i], i + 1, A,total);
                list.remove(list.size()-1);
            //}
            //totalWays += backPack(m,i+1,A);
        }
        return totalWays;
    }


    public int backPackAgainMine(int m, int[] A) {
        int dp[][] = new int[m + 1][A.length + 1];

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] += dp[i][j-1];
                if (A[j - 1] <= i) {
                    dp[i][j] += dp[i - A[j - 1]][j-1];
                }
            }
        }

        for (int k = m; k >= 0; k--) {
            if (dp[k][A.length] > 0) {
                return k;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BackPack backPack = new BackPack();
        int ar[]=new int[]{2,1,1,3,4,3,9,10,11,3,2,4};
        //System.out.println(backPack.backPackTotalWays(7,ar));
        System.out.println(backPack.backPack(7,0,ar));
       // System.out.println(backPack.backPackFront(0,0,ar,7));

//        2,2,1
//                3,2 3 2
//                        2,3  2,3
//                                5
//                                        4 1
//



        int []arry = {828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388};
        int m = 5000;
    //    System.out.println(backPack.backPackTotalWays(5000,arry));
     //   System.out.println(backPack.backPack(5000,0,arry));
        //System.out.println(backPack.backPackAgainMine(m, arry));
        //System.out.println(backPack.backPack(m, arry));
        //System.out.println(backPack.backPackAgain(m, arry));

    }

    // no retptioion
    public int backPackAgain(int m, int[] A) {
        int []ways = new int[m+1];
        ways[0] = 1;
        for(int i=0;i<A.length;i++){
            for(int j = m;j>=0;j--){
                if(j>=A[i]){
                    ways[j] = ways[j]+ways[j-A[i]];
                }
            }
        }
        for(int k=m;k>=0;k--){
            if(ways[k]>0){
                return k;
            }
        }
        return 0;
    }
    public int backPackTotalWays(int m, int[] A) {
        int []ways = new int[m+1];
        ways[0] = 1;
        for(int i=0;i<A.length;i++){
            for(int j = m;j>=0;j--){
                if(j>=A[i]){
                    ways[j] = ways[j]+ways[j-A[i]];
                }
            }
        }

        return ways[m];
    }
}