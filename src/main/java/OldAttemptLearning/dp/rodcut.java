package OldAttemptLearning.dp;

/**
 * Created by hadoop on 12/8/17.
 */
public class rodcut {
    public static void main(String[] args) {
        int length[] = {1,2,3,4,5,6,7,8};
        int prices[]= {1,5,8,9,10,17,17,2000};
        int rodlength = 8;
        int ans = rodcutprice(rodlength,length,prices);
        System.out.println("ans"+ans);
    }

    private static int rodcutprice(int rodlength, int[] length, int[] prices) {
        if(rodlength==0){
            return 0;
        }
        if(rodlength<0){
            return 0;
        }

        int price = Integer.MIN_VALUE;
        for(int i=1;i<=rodlength;i++){
            price = Math.max(price,prices[i-1]+rodcutprice(rodlength-i,length,prices));
        }
        return price;
    }
}
