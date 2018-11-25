package BasicAlgorithms.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 13/10/17.
 */
public class Sum3Smaller {
    static int ans (int number[],int k){
        int count = 0;
        Arrays.sort(number);
        for(int i=0;i<number.length-2;i++){
            if(i>0 && number[i] == number[i-1]){
                continue;
            }
            int start = i+1;
            int end = number.length-1;
            while (start<end){
                if(start>i+1 && number[start] == number[start-1]){
                    start++;
                    continue;
                }
                if(end<number.length-1 && number[end] == number[end+1]){
                    end--;
                    continue;
                }
                int target = number[i]+number[start]+number[end];
                if(target <k){
                    count = count+end-start;
                    start++;
                }
                else if (target>=k){
                    end--;
                }
            }
        }
        return count;
    }
}
