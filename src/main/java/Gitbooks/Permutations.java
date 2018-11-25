package Gitbooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 12/9/17.
 */
public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int nums[] = {2,1,2,3};
        Arrays.sort(nums);
        permutations.permute(nums);
    }

    List<List<Integer>> permute(int [] nums){
        boolean [] visited = new boolean[nums.length];

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(nums,path,result,visited);
        System.out.println(result);
        return result;
    }

    private void helper(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] visited) {
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            //if(i>0 && nums[i] == nums[i-1] ) continue;
            visited[i] = true;
            path.add(nums[i]);
            helper(nums,path,result,visited);
            visited[i]= false;
            path.remove(path.size()-1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}
