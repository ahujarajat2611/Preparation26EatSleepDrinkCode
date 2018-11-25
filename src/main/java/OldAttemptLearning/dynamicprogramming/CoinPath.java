package OldAttemptLearning.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 7/8/17.
 */
public class CoinPath {

    public static void main(String[] args) {


        CoinPath coinPath = new CoinPath();

        int array[] = {1, 2, 4, -1, 2};
        int arrayagain[] ={1,2,4,-1,2};
        //System.out.println(coinPath.cheapestJump(array,2));


        int basearray[] ={1,-1,3,4};
        int index[] = new int[array.length+1];

        int B = 2;

        index[1] =0;
        System.out.println();
        int mincoint = mincoin(0, array, B,index);
        System.out.println("co"+mincoint);

       // System.out.println(cheapestJump(array,B));
        System.out.println("try");

        printpath(index,array.length);

        System.exit(1);
        int pathagain = array.length;
        System.out.println(pathagain);

        while (pathagain!=-1){
            pathagain = index[pathagain];
            System.out.println(pathagain);
        }
        for( int i=0;i<index.length;i++){
            System.out.println("final index atrray "+i+" is "+index[i]);
        }

    }

    private static int mincoin(int i, int[] array, int b,int []index) {
        if(i == array.length-1 && array[i]!=-1){
            return array[i];
        }
        int min = Integer.MAX_VALUE;
        int minindex=-1;
        for(int path = i+1;path<=array.length-1  && path<=i+b;path++){
            if(array[path] == -1){
                continue;
            }
            if(min>array[i]+mincoin(path,array,b,index)){
                minindex = path;
                min = array[i]+mincoin(path,array,b,index);
            }
        }
        if(minindex != -1) {
            System.out.println("path is and min value ");
            index[minindex + 1] = i+1;
        }
        return min;
    }
    public static List<Integer> cheapestJump(int[] A, int B) {
        int []index = new int[A.length+1];
        int [] memo = new int [A.length+1];
        Arrays.fill(memo,-1);
        List<Integer> returnedList = new ArrayList<Integer>();
        if(A==null || A.length == 0){
            return returnedList;
        }
        index[0] = -1;
        int mincost = cheapestJumpHelper(0,A,B,index,memo);
        System.out.println("min cost "+mincost);
        if(mincost ==0){
            return returnedList;
        }
        else{
            int pathagain = index[A.length];
            returnedList.add(pathagain);
           // System.out.println(pathagain);
            while (pathagain!=-1){
                System.out.println(A[pathagain]);
                pathagain = index[pathagain];
                returnedList.add(pathagain);
            }
            return returnedList;
        }
    }

    private static int cheapestJumpHelper(int i,int[] array, int b, int[] index, int []memo) {
        if(i == array.length-1 && array[i]!=-1){
            return array[i];
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        int min = Integer.MAX_VALUE;
        int minindex=-1;
        for(int path = i+1;path<=array.length-1  && path<=i+b;path++){
            if(array[path] == -1){
                continue;
            }
            if(min>array[i]+cheapestJumpHelper(path,array,b,index,memo)){
                minindex = path;
                min = array[i]+cheapestJumpHelper(path,array,b,index,memo);
            }
        }
        if(minindex != -1) {
            index[minindex + 1] = i+1;
        }
        memo[i] = min;
        return min;
    }
    static void printpath(int []array,int startindex){
        if(startindex == 0){
            return;
        }
        printpath(array,array[startindex]);
        System.out.println(startindex);
    }
}
