package DSA.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 12/2/18.
 */
public class GreedyCoins {
    public void findMinCoinsGeeksForGeeks(int n, int[] coins, List<Integer> denominiations) {
        Arrays.sort(coins);
        for(int i=coins.length-1;i>=0;i--){
            while (n>=coins[i]){
                n = n-coins[i];
                denominiations.add(coins[i]);
            }
        }
    }

    public static void main(String[] args) {
        int coins[] = {1, 5, 6, 9};
        int n = 11;
        List<Integer> denominiations = new ArrayList<Integer>();
        GreedyCoins obj = new GreedyCoins();
        obj.findMinCoinsGeeksForGeeks(n,coins,denominiations);
        if(denominiations.size() == 0)
            System.out.println("No denominations to form given :"+n);
        else
            System.out.println(denominiations);
    }
}