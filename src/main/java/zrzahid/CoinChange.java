package zrzahid;

/**
 * Created by hadoop on 9/9/17.
 */
public class CoinChange {
    public static void main(String[] args) {

    }
    // X IS THE STARTING POSITIONS
    // COINS HAS ALL THE OPTIONS
    /// LOOKS LIKE THATS THE DEAL !! THATS HOW I AM GOING TO TINK
    /// STARTING POSIRIONS ANDD OPTIONS FROM THAT STARTING POSITIONS !!!!


    public int change (int x, int []coins){
        if(x ==0 ) return 0;
        int min = Integer.MAX_VALUE;
        for( int i=0;i<coins.length;i++){
            if(x-coins[i]>=0){
                // normal flow of DP
                // go thrugh all and get the min ans possible for
                // this case
                min = Math.min(min,1+change(x-coins[i],coins));
            }
        }
        return min;
    }
}
