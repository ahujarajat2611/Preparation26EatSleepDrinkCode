package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 12/10/17.
 */
public class FindMissingRangeAgain {
    List<String> missing(int nums[],int lower,int after){
        List<String> list = new ArrayList<>();
        int  previous = lower-1;
        int higher = after;
        for(int i=0;i<nums.length;i++){
            higher = nums[i];
            if(higher-previous ==2){
                list.add(String.valueOf(previous+1));
            }
            else if(higher-previous>2){
                list.add(String.valueOf(previous+1)+"->"+String.valueOf(higher-1));
            }
            previous = nums[i];
            if(nums[i]>higher){
                break;
            }
        }
        higher = after;
        if(higher-previous==2){
            list.add(String.valueOf(previous+1));
        }
        else if(higher-previous>2){
            list.add(String.valueOf(previous+1)+"->"+String.valueOf(after));
        }
        return list;
    }
}
