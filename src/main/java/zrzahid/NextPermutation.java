package zrzahid;

/**
 * Created by hadoop on 12/9/17.
 */
public class NextPermutation {
    public static void main(String args[]){
        NextPermutation nextPermutation = new NextPermutation();
        int nums []= {6,8,7,4,3,2};
        nextPermutation.nextPermutation(nums);
        nextPermutation.previousPermutation(nums);
        for( Integer i :nums){
            System.out.print(i);
        }
    }
    public void nextPermutation(int [] nums){
        for(int i=nums.length-2;i>=0;i--) {
            if (nums[i] < nums[i + 1]) {
                int j;
                for(j=nums.length-1;j>i;j--){
                    if(nums[j]>nums[i]){
                        break;
                    }
                }
                swap(nums,i,j);
                reverse(nums,i+1,nums.length-1);
                return;
            }
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    private void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void previousPermutation(int [] nums){
        for( int i = nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                int j;
                for(j = nums.length-1;j>i;j--){
                    if(nums[j]<nums[i]){
                        break;
                    }
                }
                swap(nums,i,j);
                reverse(nums,i+1,nums.length-1);
                return;
            }
        }
    }

}
