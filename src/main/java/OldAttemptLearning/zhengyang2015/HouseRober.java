package OldAttemptLearning.zhengyang2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hadoop on 23/8/17.
 */
public class HouseRober {
    public static void main(String[] args) {
        int array [] = {5, 3, 4,11, 2,5,6};
        int ans = new HouseRober().houserobber2(array);
        System.out.println(ans);
    }
    public int houserobber( int []array){
        if(array == null || array.length == 0){
            return 0;
        }
        int []dp = new int[array.length+1];
        dp[0] = 0;
        dp[1] = array[0];
        for ( int i=2;i<=array.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] +array[i-1]);
        }
        return dp[array.length];
    }
    public int houserobber2(int [] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int []dp = new int[array.length+1];
        int []last = new int[array.length+1];
        dp[0] = 0;
        last[0] = -1;
        dp[1] = array[0];
        last[1] = 0;
        for ( int i=2;i<=array.length;i++){
            if(dp[i-1] >dp[i-2]+array[i-1]){
                dp[i] = dp[i-1];
                last[i] = last[i-1];
            }
            else{
                dp[i] = dp[i-2]+array[i-1];
                last[i] = i-1;
                System.out.println("ans"+array[i-1]);
            }
        }
        for(int i=0;i<last.length;i++){
           // System.out.println(last[i]);
        }
       // printpath(dp.length-1,dp,array);
        //System.out.println(getPath(last,last.length-1));
        //pathagainprint(last.length-1,last);
        printpathbasic(dp,dp.length-1,array);
        return dp[array.length];
    }

    private void printpathbasic(int[] dp, int i,int array[]) {
        if(i<=0){
            return;
        }
        int prev ;
        if(i>=2){
            prev = dp[i-2];
        }
        else {
            prev = 0;
        }
        if (array[i - 1] + prev == dp[i]) {
                System.out.println(array[i - 1]);
                printpathbasic(dp, i - 2, array);
            } else {
                printpathbasic(dp, i - 1, array);
        }
    }

    public static void pathagainprint(int index,int []array){
        if(index == 0){
            return;
        }
        int newindex= array[index];
        if(newindex+1== index) {
            pathagainprint(newindex, array);
        }
        else {
            pathagainprint(newindex,array);
        }
    }
    public static void printpath(int index,int []dp,int []array){
        if(index<=1){
            return;
        }
        if(dp[index] == dp[index-2]+ array[index-1]){
            System.out.println("element" +array[index-1]);
            printpath(index-2,dp,array);
        }
        else {
            printpath(index-1,dp,array);
        }
    }

    public static List<Integer> getPath(int[] last, int destination) {
       // System.out.println("here"+destination);
        List<Integer> path = new ArrayList<Integer>();
        while (destination != -1 ) {
            path.add(destination);
            destination = last[destination];

         //   System.out.println(destination);
        }
        Collections.reverse(path);
        return path;
    }

    public int houserobber3(Treenode node){

        int [] ans = dp(node);
        return Math.max(ans[0],ans[1]);

    }

    private int[] dp(Treenode node) {
        if( node == null ){
            return new int[]{0,0};
        }

        //first value exclude . second value inclde root
        int [] left = dp(node.left);
        int [] right = dp(node.right);

        int array[] = new int[2];
        array[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        array[1] = node.val + left[0] + right[0];

        return array;
    }

    private class Treenode{
        public int val;
        public Treenode left;
        public Treenode right;
        }
}

// dp1 (v) include v
// dp2(v) exclude v

// dp1(v) = CV + summation ( dp2(vi)) vi childresn of v
// dp2(v)= summation (max ( dp1(vi), dp2(vi))) v1 chilren of v
// ans max ( dp1(v),dp2(v))



