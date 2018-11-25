package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 19/9/17.
 */
public class SubarraySum0 {
    public ArrayList<Integer> subarraySum(int []nums){
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            // to check sum s
            // check for sum-s in hashmap

            if(map.containsKey(sum)){
                int startIndex = map.get(sum)+1;
                int endIndex = i;
                result.add(startIndex);
                result.add(endIndex);
                return result;
            }
            map.put(sum,i);
        }
        return result;
    }
}
