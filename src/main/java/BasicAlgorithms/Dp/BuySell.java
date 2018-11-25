package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 24/12/17.
 */
public class BuySell {
    public int maxProfit(int[] prices, int fee) {
        int pro=0;
        int start =0;
        int end = start+1;
        int coun =0;
        while (end<prices.length){
            coun++;
          //  if(coun>10){
             //   System.exit(1);
           //// }
           // System.out.println(publish);
            //System.out.println(end);
            //System.out.println();
            if(prices[end]>=prices[end-1]){
                end++;
               // System.out.println("e"+end);
            }
                pro +=prices[end-1]-prices[start]-fee;
               // System.out.println("end"+end);
                start = end;
                end = start+1;

        }
        return pro;
    }
    int profagain(int []prices, int fee) {
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];

        //VIMPPPP

        buy[0] = -prices[0];
        sell[0] = 0;
        //for each i .. either dont perform any operation
        // or buy it or sell it
        // buy[i] = Math.max(buy[i-1],sell[i-1]-prices[i]);
        // sell[i] = Math.max(sell[i-1],buy[i-1] +price[i] -fee)


        // if we need to put rest before we buy again
        //different question


        //WATTTTTTA SOLUTION
        //buy[i] = max(sell[i-2]-price, buy[i-1])
        //sell[i] = max(buy[i-1]+price, sell[i-1])


        for(int i=1;i<prices.length;i++){
            buy[i] = Math.max(buy[i-1],sell[i-1]-prices[i]);
            sell[i] = Math.max(sell[i-1],buy[i-1]+prices[i]-fee);
        }
        return sell[prices.length-1];

    }
        int prof(int []prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int start = 0;
        int peek = 0;
        while (start < prices.length - 1) {
            peek = start + 1;
            while (peek < prices.length && prices[peek - 1] <= prices[peek]) {
                peek++;
            }
            profit += prices[peek - 1] - prices[start]-fee;
            start = peek;
        }
        return profit;
    }
    public static void main(String[] args) {
        int arr[]={1, 3, 2, 8, 4, 9};
        int fee = 2;
        BuySell buySell = new BuySell();
        System.out.println(buySell.prof(arr,2));
        System.out.println(buySell.maxProfit(arr,2));

    }
}