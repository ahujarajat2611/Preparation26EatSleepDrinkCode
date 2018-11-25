package BasicAlgorithms.BackTracking;

/**
 * Created by hadoop on 22/10/17.
 */
import java.util.*;
public class CombinationSum2 {
    List<List<Integer>> combinationSum2(int []nums, int target){
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,path,list,0,target);
        return list;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> list, int index, int target) {
        if(target<0) return ;
        if(target == 0){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,path,list,i+1,target-nums[i]);
            path.remove(path.size()-1);
            while (i<nums.length-1 && nums[i] == nums[i+1])i++;
        }
    }
}
