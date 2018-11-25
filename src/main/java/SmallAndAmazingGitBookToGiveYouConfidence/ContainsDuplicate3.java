package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.TreeSet;

/**
 * Created by hadoop on 21/9/17.
 */
public class ContainsDuplicate3 {
    boolean containsNearbyAlmostDuplicate(int []nums,int k,int t){
        final TreeSet<Integer> values = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer potentialNum = values.ceiling(nums[i] - t);

            if (potentialNum != null && potentialNum <= (long)nums[i] + t) {
                return true;
            }
//            Integer floorCheck = values.floor(nums[i]+t); // floor means neeche
 //           Integer ceilCheck = values.ceiling(nums[i]-t);// ceil means upar ...
            values.add(nums[i]);
            if(i>=t){
                values.remove(nums[i-t]);
            }
        }
        return false;
    }
}
