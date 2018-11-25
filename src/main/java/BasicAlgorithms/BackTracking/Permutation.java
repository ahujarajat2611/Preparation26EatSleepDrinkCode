package BasicAlgorithms.BackTracking;
import java.util.*;
public class Permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean [] visited = new boolean[nums.length];

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,path,result,visited);
       // System.out.println(result);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] visited) {
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
           // if(i>0 && nums[i] == nums[i-1] ) continue;
            visited[i] = true;
            path.add(nums[i]);
            helper(nums,path,result,visited);
            visited[i]= false;
            path.remove(path.size()-1);
            // removing duplicates after finish the permuatation of digit
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}