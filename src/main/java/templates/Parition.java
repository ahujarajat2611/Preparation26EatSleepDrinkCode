package templates;

/**
 * Created by hadoop on 23/10/17.
 */
import java.util.*;
public class Parition {
    void partition(List<Integer> nums,List<Integer> pivots){
        Integer []boundaries = new Integer[pivots.size()];
        Arrays.fill(boundaries,0);
        for(int k=0;k<nums.size();k++){

            for(int i=0;i<pivots.size();i++) {
                if(nums.get(k)<pivots.get(i)){
                    Collections.swap(nums,k,boundaries[pivots.get(i)]);
                }
            }
            for(int i=1;i<pivots.size();i++){
                boundaries[i] = Math.max(boundaries[i],boundaries[i-1]);
            }

        }

    }

}
/*
void partition(vector<int> & nums, vector<int> const & pivots)
{
    vector<int> boundaries(pivots.size());
    for (auto &n : nums)
    {
        for (int i = 0; i < pivots.size(); ++ i)
            if (n < pivots[i])
                swap(n, nums[boundaries[i] ++]);
        for (int i = 1; i < pivots.size(); ++ i)
            boundaries[i] = max(boundaries[i], boundaries[i - 1]);
    }
}
 */