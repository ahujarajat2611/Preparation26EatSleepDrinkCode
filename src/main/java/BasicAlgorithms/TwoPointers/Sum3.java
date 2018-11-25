package BasicAlgorithms.TwoPointers;

import java.util.*;

/**
 * Created by hadoop on 13/10/17.
 */
public class Sum3 {
    HashSet set = new HashSet();

    public static void  main(String args[]){
            int nums []={-1,0,1,2,-1,-4};
        System.out.println(ans(nums));
    }
    static List<List<Integer>> ans ( int number[]){
        List<List<Integer>> list = new ArrayList<>();
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
                if(target == 0){
                    List linkedlist = new LinkedList();
                    linkedlist.add(number[i]);
                    linkedlist.add(number[start]);
                    linkedlist.add(number[end]);
                    list.add(linkedlist);
                    start++;
                    end--;
                }
                else if(target>0){
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return list;
    }
}
