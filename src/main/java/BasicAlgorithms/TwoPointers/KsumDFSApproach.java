package BasicAlgorithms.TwoPointers;

import java.util.ArrayList;

/**
 * Created by hadoop on 13/10/17.
 */
public class KsumDFSApproach {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ksumhelper(0,k,A,target);
        return result;
    }

    private void ksumhelper(int index, int k, int[] a, int target) {
        if(target<0){
            return;
        }
        if(k<0){
            return;
        }
        if(target == 0 && k ==0){
            result.add(new ArrayList<>(path));
            return;
        }
        else {
            for(int i=index;i<a.length;i++){
                path.add(a[i]);
                ksumhelper(i+1,k-1,a,target-a[i]);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int nums []={1,2,3,4,5};
        int target = 5;
        int k =2;
        KsumDFSApproach ksumDFSApproach = new KsumDFSApproach();
        System.out.println(ksumDFSApproach.kSumII(nums,k,target));
    }
}