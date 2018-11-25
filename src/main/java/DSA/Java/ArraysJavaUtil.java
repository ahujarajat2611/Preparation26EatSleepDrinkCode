package DSA.Java;

import java.util.Arrays;

/**
 * Created by hadoop on 19/2/18.
 */
public class ArraysJavaUtil {
    void ArraysBinarySearchTesting(){
        int dp []= {1,4,5,};
        int i = Arrays.binarySearch(dp, 0, dp.length-1, 2);
        System.out.println("index "+i);
        i = binarySearch(dp,0,dp.length-1,2);
        System.out.println("index again "+i);
    }

    public static void main(String[] args) {
        ArraysJavaUtil util = new ArraysJavaUtil();
        util.ArraysBinarySearchTesting();
    }
    int binarySearch(int []a,int start,int end,int element){
        while (start<end){
            int mid = (start + end)/2;
            if(a[mid] < element){
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}
