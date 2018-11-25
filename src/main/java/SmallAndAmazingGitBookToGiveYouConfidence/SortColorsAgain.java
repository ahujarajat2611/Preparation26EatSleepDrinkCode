package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 22/9/17.
 */
public class SortColorsAgain {
    public void sortColors(int []array){
        int start =0;
        int index =0;
        int end = array.length-1;
        while(index<=end){
            if(array[index] ==0){
                swap(array,start,index);
                start++;
                index++;
            }
            else if(array[index] == 1){
                index++;
            }
            else {
                swap(array,end,index);
                end--;
            }
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
