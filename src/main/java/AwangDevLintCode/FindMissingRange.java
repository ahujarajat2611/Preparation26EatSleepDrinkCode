package AwangDevLintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 12/10/17.
 */
public class FindMissingRange {
    public static void main(String[] args) {
        int nums[] = {5, 9, 14, 50, 75};
        int lower = 1;
        int higher = 56;
        System.out.println(findMissingRange(nums,lower,higher));
    }
    static  List<String> findMissingRange(int []nums, int lower, int upper){
        List<String> list = new ArrayList<>();
        if(nums.length == 0){
            list.add(getRange(lower,upper));
            return list;
        }
        if(lower<nums[0]){
            list.add(getRange(lower,nums[0]-1));
            lower = nums[0];
        }
        for(int i=1;i<nums.length;i++){
            // before lower
            if(nums[i]<lower){
                continue;
            }
            // there is reason to check with lower + 1 instead of lower
            // since we are looking for missing range !!!!!!!
            //
            if(nums[i]>lower+1){
                //// very very very very imp !!!!!!!!
                // to have upper limit of Upper always intact
                // check range frmo previous element lower to nums[i]
                list.add(getRange(lower+1,Math.min(nums[i]-1,upper)));
            }
            lower = nums[i];
            // after upper
            if(nums[i]>upper){
                break;
            }
        }
        if(lower+1<=upper){
            list.add(getRange(lower+1,upper));
        }
        return list;
    }

    private static String getRange(int lower, int upper) {
        if(lower == upper){
            return String.valueOf(lower);
        }
        else if(lower<upper){
            return lower+"->"+upper;
        }
        else {
            return "";
        }
    }
}

/*
public class Solution {

//if both publish and end are same, then we just need one entry, else get the range
public String getRangeString(int publish, int end){
    return (publish==end)?String.valueOf(publish):(publish+"->"+end);
}

public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> list = new ArrayList<>();
    //if input array is empty, then just generate the range between lower and upper
    if(nums.length==0){
        list.add(getRangeString(lower, upper));
        return list;
    }

    //if the first element and the lower vary by more than 0, then it means that the input array starts
    //atleast by +1 of lower, so we need to at the minimum add the lower as an entry for output. So we
    //generate the range of lower, first_element-1
    if(nums[0]-lower>0){
        list.add(getRangeString(lower, nums[0]-1));
        //set the lower as first element
        lower = nums[0];
    }

    //now just loop over the array finding the range if the difference is >=2. If the difference is just 1 then it
    //means that the two elements are contiguous, so no need to worry. If its 2 then it means we atleast miss one element,
    //so we find the range of lower+1, current_element-1
    for(int i=1;i<nums.length;i++){
        if(nums[i]-lower >=2){
            list.add(getRangeString(lower+1, nums[i]-1));
        }
        lower = nums[i];
    }

    //for the last element, we need to get the range between last_element+1 and the upper
    if(lower+1 <= upper){
        list.add(getRangeString(lower+1, upper));
    }

    //return the list
    return list;
}
 */