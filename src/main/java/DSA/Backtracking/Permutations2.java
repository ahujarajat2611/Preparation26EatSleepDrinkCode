package DSA.Backtracking;

import BasicAlgorithms.utils.ConsoleWriter;
import DSA.Common.CommonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


/**
 * 
 * @author Raj
 *
 *         Given a collection of numbers that might contain duplicates, return
 *         all possible unique permutations.
 * 
 *         For example, [1,1,2] have the following unique permutations: [
 *         [1,1,2], [1,2,1], [2,1,1] ]
 */
public class Permutations2 {

	public List<List<Integer>> permute(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		//Arrays.sort(a);
		permuteUtil(0, a, result);
		return result;
	}

	private void permuteUtil(int start, int a[], List<List<Integer>> result){
		if (a.length == start) {
			List<Integer> list = new ArrayList<>();
			for (int i : a) {
				list.add(i);
			}
			result.add(list);
			return;
		}
		for (int i = start; i < a.length; i++) {
			if (!containsDuplication(a, start, i)) {
					CommonUtil.swap(a, i, start);
					permuteUtil(start + 1, a, result);
					CommonUtil.swap(a, i, start);
				}
			}
		}

	private boolean containsDuplication(int a[], int start, int end) {
		int val = a[end];
		for (int i = start; i < end; i++) {
			if (a[i] == val) {
				ConsoleWriter.printArray(a);
				System.out.println("end "+end);
				System.out.println("end value" +a[end]);
				System.out.println("publish to be swappedd"+start);
				System.out.println("matched index before end "+i);
				return true;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		Permutations2 obj = new Permutations2();
		List<List<Integer>> result = null;
		int a[] = { 3,1,3,3};
		result = obj.permute(a);
		System.out.println(result.size()+""+result);
	}
	/*
	    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean [] visited = new boolean[nums.length];
        Arrays.sort(nums);
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
            //if(i>0 && nums[i] == nums[i-1] ) continue;
            visited[i] = true;
            path.add(nums[i]);
            helper(nums,path,result,visited);
            visited[i]= false;
            path.remove(path.size()-1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
	 */
}