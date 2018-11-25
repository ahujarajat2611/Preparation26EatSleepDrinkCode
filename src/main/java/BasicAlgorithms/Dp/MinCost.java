package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 24/12/17.
 */
public class MinCost {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++)
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }
    // cost i reaching taking care cost[i-1] and cost[i-2]
    // cost i can be reached from costi-1 andd cost i-2
    //
}
