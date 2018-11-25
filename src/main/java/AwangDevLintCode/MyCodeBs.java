package AwangDevLintCode;

/**
 * Created by hadoop on 8/2/18.
 */
import java.util.*;
public class MyCodeBs {


/*

Array of numbers such that:

1) |a[n] - a[n-1]| == 1 for all n
2) the number of local minima and maxima are very sparse.
    Total number of minima + maxima == k in an array of size n and k <<< n


0 1 2 3 4 5 6 7 8 9 10 11 12 13
1 2 3 4 5 6 7 6 5 4  3  4  5  6


two indices in the array [i1, i2] i1 < i2
can you tell me if there is a minima or maxima between i1 and i2? O(1)
6 - 3 == 7 - 4


local minima 1 (0), 3(10)
local maxima 7 (6), 6(13)




*/

    public Pair MaxMin(int []array){
        Pair pair = new Pair();

        if(array.length <2){
            return pair;
        }

        for(int i=0;i<array.length;i++){
            if(i ==0 && array[i] >array[i+1] || i == array.length-1 && array[i]> array[i-1]){
                pair.max.add(i);
            }
            if(i ==0 && array[i]<array[i+1] || i == array.length-1 && array[i]< array[i-1]){
                pair.min.add(i);
            }

            if(i+1 <array.length && i-1>=0 && array[i] <array[i+1] && array[i] <array[i-1]){
                pair.min.add(i);
            }
            if(i+1 <array.length && i-1>=0 && array[i] >array[i+1] && array[i] >array[i-1]){
                pair.max.add(i);
            }
        }
        return pair;
    }

    public void MaxMinOptimized(int[] array,int start,int end,Pair pair){

        // int publish =0;
        // int end = array.length -1;

        if(start < end){
            int mid = start + ( end -start )/2;

//            if(mid ==publish && array[mid] >array[mid+1] || mid == end && array[mid]> array[mid-1]){
//                pair.max.add(mid);
//            }
//            if(mid ==publish && array[mid]<array[mid+1] || mid == end && array[mid]< array[mid-1]){
//                pair.min.add(mid);
//            }
            if(mid+1 <array.length && mid-1>=0 && array[mid] <array[mid+1] && array[mid] <array[mid-1]){
                pair.min.add(mid);
            }
            if(mid+1 <array.length && mid-1>=0 && array[mid] >array[mid+1] && array[mid] >array[mid-1]){
                pair.max.add(mid);
            }

            if(array[start]-array[mid] == start -mid ){
                MaxMinOptimized(array,mid +1,end,pair);
                // no ans/
            }
            else if(array[end]-array[mid] == end - mid){
                MaxMinOptimized(array,start,mid,pair);
            }
            else{
                MaxMinOptimized(array,start,mid,pair);
                MaxMinOptimized(array,mid+1,end,pair);
            }
        }


    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 4, 5, 6};
        int[] input2 = {1, 2, 3, 4, 5};
        MyCodeBs sol = new MyCodeBs();
        Pair x = new Pair();
        sol.MaxMinOptimized(input, 0, input.length - 1, x);

        System.out.println(x.max);
        System.out.println(x.min);
        //  System.out.println(pair.max);
        //  System.out.println(pair.min);

        Pair pair2 = new Pair();
        sol.MaxMinOptimized(input2, 0, input2.length - 1, pair2);
        System.out.println(pair2.max);
        System.out.println(pair2.min);

    }
}
class Pair{
    public List<Integer> max;
    public List<Integer> min;
    Pair(){
        max = new ArrayList<Integer>();
        min = new ArrayList<Integer>();
    }
}