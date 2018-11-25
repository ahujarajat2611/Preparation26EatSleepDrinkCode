package BasicAlgorithms.Greedy;

/**
 * Created by hadoop on 23/10/17.
 */
public class GasStation {
    // intermediate state becomes negative then restart
    // keep trak of total sum as well
    // if total sum goes less than 0 after whole loop not possible
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int intermediate = 0;
        for(int i=0;i<gas.length;i++){
            total = total + gas[i]-cost[i];
            intermediate = intermediate + gas[i]-cost[i];
            if(intermediate<0){
                start = i+1;
                intermediate = 0;
            }
        }
        if(total<0){
            return -1;
        }
        return start;
    }
}