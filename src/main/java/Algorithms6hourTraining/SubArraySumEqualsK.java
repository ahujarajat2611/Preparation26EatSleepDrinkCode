package Algorithms6hourTraining;
import java.util.*;


/**
 * Created by hadoop on 21/12/17.
 */
// first you check and then add into ur DDS
    // thats the usual Trend we see always !!
    // so thats how you  can deal with things !!
    // usual structure before addding check in ur DS and then see how are things !!!


    // here asking how many subarrays now
    // the way it works that you store ans before handd so that if you get same thing then you have the ans in ur map
    // like you are adding predix sum // andd you check for prefisum-k exisit if yes get the ans and add it
    // later you addd in ur ds this prefix sum ( like how many times you have got this prefix sum )


public class SubArraySumEqualsK {
    int totalSubarrays(int []nums,int k ){
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int result = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum-k)){
                result = result + map.get(sum-k);
            }
            // push all possible sum values in the map .......
            // sum - that look out for that value !!!
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
