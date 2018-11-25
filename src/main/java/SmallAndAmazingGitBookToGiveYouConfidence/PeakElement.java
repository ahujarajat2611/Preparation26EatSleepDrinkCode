package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 21/9/17.
 */
public class PeakElement {
    int findPeak(int  []nums){
        int start=0;
        int end = nums.length-1;
        while (start<end){
            int mid = start + end-start/2;
            if(nums[mid] <nums[mid+1]){
                start= mid+1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}
