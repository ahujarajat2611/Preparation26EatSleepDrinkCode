package BasicAlgorithms.Array;

class Solution {
    public int solution(int[] A) {
        return missingnumber(A);
    }
    private static int missingnumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=i){
                swap(nums,nums[i]-1,i);
                i--;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1 !=nums.length){
                return i+1;
            }
        }
        return nums.length+1;
    }
     private static void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 3, 6, 4, 1, 2});
    }
}