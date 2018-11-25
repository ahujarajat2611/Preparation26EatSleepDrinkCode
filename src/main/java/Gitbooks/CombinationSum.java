package Gitbooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 12/9/17.
 */
public class CombinationSum {
    public static void main(String[] args) {
        int nums [] = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum combinationSum = new CombinationSum();
     //   System.out.println(combinationSum.combinationSum(nums,target));
      //  System.out.println(combinationSum.combination5(4,2));
        System.out.println(combinationSum.findSubsequences(new int []{4, 6, 7, 7}));
    }

    List<List<Integer>> combinationSum(int []nums, int target){
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
    List<List<Integer>> combination5(int n,int k ){
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helperCombination5(n,k,path,result,1);
        return result;
    }

    private void helperCombination5(int n, int k, List<Integer> path, List<List<Integer>> result, int i) {
        if(path.size() == k ){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int index = i;index<=n;index++){
            path.add(index);
            helperCombination5(n,k,path,result,index+1);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helperAgain(nums,0,path,result);
        return result;
    }

    private void helperAgain(int[] nums, int i, List<Integer> path, List<List<Integer>> result) {
        if(path.size()>=2){
            result.add(new ArrayList<>(path));
        }
        for( int index = i;index<nums.length;index++){
            System.out.println("check" +index);
            if (path.size()==0|| path.get(path.size()-1)<=nums[index]){
                path.add(nums[index]);
                helperAgain(nums,index+1,path,result);
                path.remove(path.size()-1);
            }
        }
    }
}
