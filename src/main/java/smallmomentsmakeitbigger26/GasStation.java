package smallmomentsmakeitbigger26;

/**
 * Created by hadoop on 15/12/17.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int start = 0;
        int remain = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                remain = 0;
                // update start point to i+1 since that could be the point
                //
                start = i + 1;
            }
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }
        return start;
    }
}
