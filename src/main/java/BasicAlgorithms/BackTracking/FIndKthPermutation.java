package BasicAlgorithms.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 22/10/17.
 */
public class FIndKthPermutation {
    String kthPermutation(List<Character> list ,int k){
        String out="";
        if(list.size() ==0){
            return out;
        }
        int size = list.size();
        int factValue = fact(size-1);

        int selectedValue = (k-1)/factValue;
        out = out +list.get(selectedValue);
        k = k -selectedValue*factValue;
        list.remove(selectedValue);
        return  out = out +kthPermutation(list,k);
    }

    private int fact(int i) {
        if(i ==0){
            return 1;
        }
        if(i ==1){
            return 1;
        }
        return i*fact(i-1);
    }
  //  public void nextPermutation(int [] nums){
//        for(int i=nums.length-2;i>=0;i--) {
//            if (nums[i] < nums[i + 1]) {
//                int j;
//                for(j=nums.length-1;j>i;j--){
//                    if(nums[j]>nums[i]){
//                        break;
//                    }
//                }
//                swap(nums,i,j);
//                reverse(nums,i+1,nums.length-1);
//                return;
//            }
//        }
//    }
//    public void nextPermutationAgain(int [] nums) {
//
//    }
        public static void main(String args[]){
        FIndKthPermutation kthPermutation  = new FIndKthPermutation();
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        System.out.println(kthPermutation.kthPermutation(list,5));
    }

}
