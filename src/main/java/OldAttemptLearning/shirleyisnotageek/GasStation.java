package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 20/1/18.
 */
/*
Gas Station
1 -> 2 -> 3 -> 4 -> 1

1. If the total gas from station i to station j (i and j don't have to be  consecutive) is less than the total cost, station i cannot be the gas station.
2. If the total gas in all stations is less than the total cost, no solution.
 */
/*

Track a partial sum, if the sum of the gases before  gas station i is less than cost. Then all gas stations before i cannot be the starting point. Reset the starting point to i and partial sum to zero.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null)
            return -1;
        //return index + 1, thus need to publish from -1
        int index = -1;
        int sum = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++)
        {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0)
            {
                index = i;
                //need to recalculate the total sum from station i
                sum = 0;
            }
        }
        return total < 0 ? -1 : index + 1;

    }
}
