package DSA.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by hadoop on 12/2/18.
 */
public class GreedyKnapsack {
    public double greedyKnapsack(List<Knapsack> kss, int m) {

        for (int i = 0; i < kss.size(); i++) {
            double p = (double) kss.get(i).profit / kss.get(i).weight;
            // p = Math.round(p * 10);
            // p = p / 10;
            kss.get(i).profitweight = p;
        }
        double totalProfit =0;
        Comparator<Knapsack> comparator = new Comparator<Knapsack>() {
            @Override
            public int compare(Knapsack o1, Knapsack o2) {
                return (int)(o2.profitweight-o1.profitweight);
            }
        };


        Collections.sort(kss,comparator);
        System.out.println(kss);

        for(int i=0;i<kss.size();i++){
            Knapsack knapsacknode = kss.get(i);
            if(m> 0 && knapsacknode.weight<=m){
                m = m-knapsacknode.weight;
                totalProfit = totalProfit + knapsacknode.profit;
            }
            else {
                if(m >0 && knapsacknode.weight>m){
                    totalProfit = totalProfit + knapsacknode.profitweight*(m);
                    m =0;
                    break;
                }
            }
        }
        return totalProfit;
    }
    public static void main(String args[]){
        int wt[] = { 7, 8, 9, 11, 12 };
        int profits[] = { 13, 15, 16, 23, 24 };
        Knapsack k1 = new Knapsack(13, 7);
        Knapsack k2 = new Knapsack(15, 8);
        Knapsack k3 = new Knapsack(16, 9);
        Knapsack k4 = new Knapsack(23, 11);
        Knapsack k5 = new Knapsack(24, 12);

        List<Knapsack> kss = new ArrayList<Knapsack>();
        kss.add(k1);
        kss.add(k2);
        kss.add(k3);
        kss.add(k4);
        kss.add(k5);
GreedyKnapsack obj = new GreedyKnapsack();
        System.out.println(obj.greedyKnapsack(kss, 26));

    }
}

class Knapsack {
    int weight;
    int profit;
    double profitweight;

    public Knapsack(int profit, int weight) {
        super();
        this.weight = weight;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Knapsack [weight=" + weight + ", profit=" + profit + ", profitweight=" + profitweight + "]";
    }

}

