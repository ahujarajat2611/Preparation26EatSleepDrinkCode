package BasicAlgorithms.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class KsumUsingDFS {
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
			        // write your code here
			        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
			        ArrayList<Integer> item = new ArrayList<>();
			        Arrays.sort(A);
			        helper(A, 0, k, target, res, item);
			        return res;
			    }
			    
			    public void helper(int[] A,int start, int k, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item) {
			        if (target < 0) {
			            return;
			        }
			        if (target == 0 && item.size() == k) {
			            res.add(new ArrayList<>(item));
			            return;
			        }
			        for (int i = start; i < A.length; i++) {
			            item.add(A[i]);
			            helper(A, i + 1, k, target - A[i], res, item);
			            item.remove(item.size() - 1);
			        }
    }
}


 class KsumDFS{

	public int ksum(int []array,int k , int target){
		if(k<1||k >array.length){
			return 0;
		}
		return ksumhelper(array,k,target,0);
	}

	private int ksumhelper(int[] array, int k, int target, int index) {
		int totalways = 0;
		if(target<0){
			return 0;
		}
		if(k<0){
			return 0;
		}
		if(k == 0){
			if(target ==0) return 1;
			return 0;
		}
		for(int i=index;i<array.length;i++){
			target = target-array[i];
			totalways +=ksumhelper(array,k-1,target,i+1);
			target = target-array[i];
		}
		return totalways;
	}
}