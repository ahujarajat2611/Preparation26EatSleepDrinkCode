package BasicAlgorithms.Dp;
import java.util.*;

/**
 * Created by hadoop on 17/12/17.
 */
public class KnapSack {
    private static int[][] getItemsToPick(int[] price, int[] weights, int sackCapacity) {
        int nItems = price.length;
        //dp[i][w] - the maximum value of sub problem with i items and with w sack capacity.
        //no need to initialize with zeros as in java, the defalt values are 0 for int premitive type.
        //dpTable index starts at 1, so dpTable[0][..] = 0 and dpTable[..][0] = 0
        int[][] dpTable = new int[nItems + 1][sackCapacity + 1];

        //iterate through all of the items
        for (int i = 1; i <= nItems; i++) {
            //calculate sub problem for all weights
            for (int w = 1; w <= sackCapacity; w++) {
                if (weights[i - 1] > w) {
                    // we cannt take this weight as it exceeds sub problem with weight w and i items
                    dpTable[i][w] = dpTable[i - 1][w];
                } else {
                    dpTable[i][w] = Math.max(price[i - 1] + dpTable[i - 1][w - weights[i - 1]], dpTable[i - 1][w]);
                }
            }
        }
        //printing dpTable
        Arrays.asList(dpTable).stream().forEach(e -> System.out.println(Arrays.toString(e)));
        return dpTable;
    }

}
