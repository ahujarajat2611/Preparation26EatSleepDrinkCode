package Algorithms6hourTraining;
import java.util.*;




/*
Starting state andd what options you have from starrting satet ( tahts thee key )

 */
/*
How many options you have two options to add or to subtract ...
no need of while loop for options ..
// usually we have while loop to checck if options are valid or not like the case of frog jump
// we had to see out of options available which one are valid.

If you keep things simple, it will become simpler going forwatrd m

Now comes ( a way, total number of ways , max state among ways, min state among ways ))
depending upon question here it is total number oof ways .. sometimes you have to deal with one way then
if(recursion) true comes into picture
// sometimes max then again all statest needs to be scanned here again like total ways required
from end we are returning 1 once we reach at the end !!!1
 */
public class TargetSum {

    int count = 0;

    public int findTargetSumWays2(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    // starting state is i and post that you have to pick other states and remember there is no ordering
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }


    public int findTargetSumWays3(int[] nums, int S) {
        Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
        return calculate(nums, 0, 0, S, mem);
    }

    // two D array could have been better as well here
    // like cache[i][sum] = number of ways to consider elements until i and sum
    public int calculate(int[] nums, int i, int sum, int S, Map<Integer, Map<Integer, Integer>> mem) {
        if (mem.containsKey(i) && mem.get(i).get(sum) != null) {
            return mem.get(i).get(sum);
        }
        // two 2 array also would have been enoughr
        // like cache[nums.lenght][sum]
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {

            // Starting states and all valid options frmo that starting states ( thats the mantra)
            // there are actually two options hence two options written in such a way
            /// we need to pick all elemtns in one order be it positive and negative
            // order does not matter since additive subtract commuttavite operatopn
            //
            int add = calculate(nums, i + 1, sum + nums[i], S, mem);
            int sub = calculate(nums, i + 1, sum - nums[i], S, mem);
            if (!mem.containsKey(i)) {
                mem.put(i, new HashMap<>());
            }
            mem.get(i).put(sum, mem.get(i).getOrDefault(sum, 0) + add + sub);
            return add + sub;
        }
    }
}