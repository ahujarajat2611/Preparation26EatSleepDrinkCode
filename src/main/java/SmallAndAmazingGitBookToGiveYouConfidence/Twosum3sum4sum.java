package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 22/9/17.
 */
public class Twosum3sum4sum {
    public int[] twoSum(int []numbers,int target){
        int start =0;
        int end = numbers.length-1;
        while(start<end){
            int sum = numbers[start]+numbers[end];
            if(sum>target){
                end--;
            }
            else if(sum<target){
                start++;
            }
            else {
                return new int []{start+1,end+1};
            }
        }
        return null;
    }
    //sum to zero all tripelest
    List<List<Integer>> threeSum(int []number){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(number);
        for(int i=0;i<number.length-2;i++){
            if(i>0 && number[i] == number[i-1])
                continue;
            int start = i+1;
            int end = number.length-1;
            while (start<end){
                while (start>i+1 && number[start] == number[start-1]){
                    start++;
                }
                while (end<number.length-2 && number[end] == number[end+1]){
                    end--;
                }
                // it coould happen that to reomove dupilivates it might end up going out of range hence there range check
                // after duplicates checck up !!
                if(start<end){
                    int sum = number[i]+number[start]+number[end];
                    if(sum<0){
                        start++;
                    }
                    else if(sum>0){
                        end--;
                    }
                    else {
                        List<Integer> trip = new ArrayList<>();
                        trip.add(number[i]);
                        trip.add(number[start]);
                        trip.add(number[end]);
                        list.add(trip);
                    }
                }

            }
        }
        return list;
    }
    public List<List<Integer>> threeSumWorking(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);
        int len = numbers.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {  /* avoid duplicates */
                continue;
            }
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
        /* avoid duplicates */
            // instead of putting if and else if .
                // better we should put coninue incase we encounte duplicaes
                // at publish position or end position !! so that while loop itself handles duplicaets condition
                if (start > i + 1 && numbers[start] == numbers[start - 1]) {
                    start++;
                } else if (end < len - 1 && numbers[end] == numbers[end + 1]) {
                    end--;
                } else {
                    int sum = numbers[i] + numbers[start] + numbers[end];  /* may overflow */
                    if (sum < 0) {
                        start++;
                    } else if (sum > 0) {
                        end--;
                    } else {
                        result.add(Arrays.asList(numbers[i], numbers[start++], numbers[end--]));
                    }
                }
            }
        }
        return result;
    }
   int threeSumTOtalTriplets(int []number,int k){
        int target =0;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(number);
        for(int i=0;i<number.length-2;i++){
            if(i>0 && number[i] == number[i-1])
                continue;
            int start = i+1;
            int end = number.length-1;
            while (start<end){
                while (start>i+1 && number[start] == number[start-1]){
                    start++;
                }
                while (end<number.length-2 && number[end] == number[end+1]){
                    end--;
                }
                if(start<end){
                    int sum = number[i]+number[start]+number[end];
                    if(sum<k){
                        target = target + end-start;
                        start++;
                    }
                    else if(sum>k){
                        end--;
                    }
                    else {
                        List<Integer> trip = new ArrayList<>();
                        trip.add(number[i]);
                        trip.add(number[start]);
                        trip.add(number[end]);
                        list.add(trip);
                    }
                }

            }
        }
        return target;
    }
}
