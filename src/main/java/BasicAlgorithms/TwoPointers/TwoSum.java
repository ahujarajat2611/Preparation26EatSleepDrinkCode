package BasicAlgorithms.TwoPointers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by hadoop on 13/10/17.
 */
 class TwoSumAgain {
    public static void main(String[] args) {
        int nums[] = {3,2,4};
        int target = 6;
        int ans[] = twoSum(nums,target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                System.out.println(target-nums[i]);
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            else {
                hashMap.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] twoSumSort(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        while (start<end){
            if(numbers[start]+numbers[end] == target){
                return new int[]{start,end};
            }
            else if(numbers[start]+numbers[end] >target){
                end--;
            }
            else {
                start++;
            }
        }
        return new int[]{-1,-1};
    }


    }

    class TwoSum {
     Map<Integer,Integer> hashMap = new HashMap<>();

     public TwoSum() {

     }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if(hashMap.containsKey(number)){
                hashMap.put(number,2);
            }
            hashMap.put(number,1);
        }

        /** Find if there exists
         *  any pair of numbers which
         *  sum is equal to the value. */
        public boolean find(int value) {
            Set<Integer> set = hashMap.keySet();
            for(Integer x:set){
                if(value == 2*x) {
                    if(hashMap.get(x) ==2){
                        return true;
                    }
                    else return false;
                }
                else {
                    if (set.contains(value - x)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean findagain(int value){
            for(int key: hashMap.keySet()){
                if(hashMap.containsKey(value-key)){
                    if(hashMap.get(value-key)>=2 || hashMap.get(value-key) == 1 && key!=value-key){
                        return true;
                    }
                }
            }
            return false;
        }

    }
