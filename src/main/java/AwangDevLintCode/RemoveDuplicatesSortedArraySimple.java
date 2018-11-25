package AwangDevLintCode;

/**
 * Created by hadoop on 24/2/18.
 */
public class RemoveDuplicatesSortedArraySimple {
    public int removeDuplicates(int[] num) {

        if(num == null || num.length ==0){
            return 0;
        }

        int start =0;
        int tail=0;
        while(start <num.length){
            int number = num[start];
            // usual standard process that i follow
            int end = start +1;
            while(end <num.length  &&  num[end] == number){
                end = end + 1;
            }
            num[tail] = number;
            tail++;
            start = end;
        }
        return tail;
    }
}
