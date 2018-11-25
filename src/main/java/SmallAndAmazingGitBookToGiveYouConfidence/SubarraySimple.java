package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hadoop on 22/9/17.
 */
public class SubarraySimple {
    public ArrayList<Integer> subarraySum(int[] nums,int sum) {
        HashMap<Integer,Integer> index = new HashMap<>();
        index.put(0,-1);
        int currsum = 0;
        for(int i =0;i<nums.length;i++){
            currsum = currsum + nums[i];
            if(index.containsKey(currsum-sum)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(index.get(currsum-sum)+1);
                list.add(i);
                return list;
            }
            index.put(currsum,i);
        }
        return null;
    }
}