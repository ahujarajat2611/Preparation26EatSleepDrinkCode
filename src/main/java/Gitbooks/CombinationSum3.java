package Gitbooks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 12/9/17.
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.cominationsum3(3,9));
        System.out.println("ans"+combinationSum3.combinationSum4(new int[]{1, 2, 3},4));

    }
    List<List<Integer>> cominationsum3(int k , int n){
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(path,result,1,n,k);
        return result;
    }

    private void helper(List<Integer> path, List<List<Integer>> result, int index, int n, int k) {
    if(n<0 || k<0){
        return;
    }
    if(n ==0 && k ==0 ){
        result.add(new ArrayList<>(path));
        return;
    }

    for(int i= index;i<=9;i++){
        path.add(i);
        helper(path,result,i+1,n-i,k-1);
        path.remove(path.size()-1);
    }
    }
    public int combinationSum4(int nums[],int target){
        int cache[] = new int[target+1];
        cache[0]= 1;
        for(int i=0;i<=target;i++){
            for (int j=0;j<nums.length;j++){
                if(nums[j]<=i){
                    cache[i] = cache[i]+cache[i-nums[j]];
                }
            }
        }
        return cache[target];
    }
}
