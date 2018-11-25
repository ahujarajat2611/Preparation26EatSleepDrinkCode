package BasicAlgorithms.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 15/10/17.
 */
public class Kadanes {
    public int maxSub2arrays(Integer []temp) {
        int size = temp.length;
        int[] left = new int[size];
        int[] right = new int[size];
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < temp.length; i++) {
            currentSum = Math.max(temp[i], currentSum + temp[i]);
            maxSum = Math.max(currentSum, maxSum);
            left[i] = maxSum;
        }
        for(int i=0;i<left.length;i++){
            System.out.print(left[i]+" ");
        }
        return -1;
    }
    public void kadan(Integer []temp){
        int maxSum = Integer.MIN_VALUE;
        int curretSum = 0;
        for(int num:temp){
            // publish of new or add to previouscurrent sum
            curretSum = Math.max(curretSum+num,num);
            // keep track of max as well
            maxSum = Math.max(curretSum,maxSum);
        }
        System.out.println("Max Sum" +maxSum);
    }
    public int maxSubArray(List<Integer> num){
        int len = num.size();
        int leftmax[]= new int[len];
        int leftmin[] = new int[len];
        int currentmax [] = new int[len];
        int currentmin [] = new int[len];
        int rightmax[] = new int[len];
        int rightmin[] = new int[len];
        int currentMax = 0;
        int currentMin = 0;
        for(int i=0;i<len;i++){
            currentMax = Math.max(currentMax+num.get(i),num.get(i));
            currentMin = Math.min(currentMin+num.get(i),num.get(i));
            currentmax[i] = currentMax;
            currentmin[i] = currentMin;
            if(i==0){
                leftmax[i] = currentMax;
                leftmin[i] = currentMin;
            }
            else {
                leftmax[i] = Math.max(leftmax[i - 1], currentMax);
                leftmin[i] = Math.min(leftmin[i - 1], currentMin);
            }
        }
        for(int i=0;i<len;i++){
            System.out.print(leftmax[i]+" ");
        }
        System.out.println();
        for(int i=0;i<len;i++){
            System.out.print(currentmax[i]+" ");
        }
        System.out.println();
        for(int i=0;i<len;i++){
            System.out.print(leftmin[i]+" ");
        }
        System.out.println();
        for(int i=0;i<len;i++){
            System.out.print(currentmin[i]+" ");
        }

        return 0;
    }

    public static void main(String[] args) {
        Integer nums[] = {-4,-5,-6,5,7,-2,4,5,-4,-14,-30,-10,10};
        Kadanes kadanes = new Kadanes();
        kadanes.maxSub2arrays(nums);
        kadanes.kadan(nums);
        kadanes.maxSubArray(Arrays.asList(nums));
    }
}
/*
for(int i = 0; i < N; i++){
max_ending_here += Number[i];

        if(max_ending_here > max_so_far)max_so_far = max_ending_here;

        if(max_ending_here < 0)max_ending_here = 0;

    }
 */