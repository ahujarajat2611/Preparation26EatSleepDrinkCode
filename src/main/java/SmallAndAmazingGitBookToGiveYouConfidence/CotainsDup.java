package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hadoop on 22/9/17.
 */
public class CotainsDup {
    public boolean containsDup(int []nums){
        Set<Integer> hashSet = new HashSet<>();
        for(int num:nums){
            if(hashSet.contains(num)){
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
    public boolean containDupInRange(int [] nums,int k){
        Set<Integer> hashset = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(hashset.contains(nums[i])){
                return true;
            }
            if(i>=k){
                hashset.remove(nums[i-k]);
            }
            hashset.add(nums[i]);
        }
        return false;
    }
}
