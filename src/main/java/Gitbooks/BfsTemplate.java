package Gitbooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 12/9/17.
 */
public class BfsTemplate {
    public static void main(String args[]){
        BfsTemplate bfsTemplate = new BfsTemplate();
        int nums []={1,1,2,1,3};
        Arrays.sort(nums);
        System.out.println(bfsTemplate.subsets(nums));
        System.out.println(bfsTemplate.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsets(int [] nums){
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        return helper(0,list,ans,nums);
    }

    List<List<Integer>> helper(int index,List<Integer> ans, List<List<Integer>> result,int [] nums){

        result.add(new ArrayList<>(ans));
        for(int i=index;i<nums.length;i++){

            if(i-1>=index && nums[i] == nums[i-1] ) continue;
            ans.add(nums[i]);
            helper(i+1,ans,result,nums);
            ans.remove(ans.size()-1);
        }
        return result;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> rst = new ArrayList(path);
        if (nums == null || nums.length == 0) {
            return rst;
        }

        Arrays.sort(nums);
        helper(nums, path, 0, rst);

        return rst;
    }

    private void helper(int[] nums, List<Integer> path, int pos, List<List<Integer>> rst) {
        rst.add(new ArrayList(path));

        for (int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            helper(nums, path, i + 1, rst);
            path.remove(path.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}
