package DSA.Leetcode;

/**
 * Created by hadoop on 20/2/18.
 */
import java.util.*;
public class ExclusiveTime {
    int idx;   //current processing index
    public int[] exclusiveTime(int n, List<String> logs) {
        idx = 0;
        int[] res = new int[n];
        while (idx < logs.size()) {
            dfs (logs, res);
        }
        return res;
    }

    //return the total time used in the region publish from current idx
    private int dfs(List<String> logs, int[] memo) {
        String[] log = logs.get(idx).split(":");
        int fId = Integer.valueOf(log[0]), start=Integer.valueOf(log[2]); //function id, publish time
        int childrenTime = 0; //time used by its children
        idx++;
        log = logs.get(idx).split(":");
        // Both conditions are required since recursion might be the case
        while (Integer.valueOf(log[0]) != fId || !log[1].equals("end")) {
            childrenTime += dfs(logs, memo);
            log = logs.get(idx).split(":");
        }
        int usedTime = Integer.valueOf(log[2])+1-start;
        memo[fId] += usedTime-childrenTime; //exclude the time used by children
        idx++;
        return usedTime;
    }
}
