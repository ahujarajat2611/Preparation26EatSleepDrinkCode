package zrzahid;

/**
 * Created by hadoop on 6/9/17.
 */
public class Permutation {
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(nextpermutation(nums));
        System.out.println("permutt");
        for( int i=0;i<nums.length;i++) {
            System.out.print(nums[i]);
        }
    }
    public static int[] nextpermutation(int []nums){
        int k=-1;
            for( int i=nums.length-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    k =i;
                    break;
                }
            }
            if(k ==-1){
                reverse(nums,0,nums.length-1);
                return nums;
            }
            int index= nums.length-1;
            while (nums[index]<=nums[k]){
                index--;
            }
            swap(nums,index,k);
            System.out.println("k"+k);
            reverse(nums,k+1,nums.length-1);
            return nums;
    }

    private static void swap(int[] nums, int index, int k) {
        int temp= nums[index];
        nums[index] = nums[k];
        nums[k] = temp;
    }
    private static void reverse(int nums[],int i,int j){
        System.out.println("i"+i);
        System.out.println("j"+j);
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

}
