package OldAttemptLearning.ksum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 7/8/17.
 */
public class Solution  {
    static List<Integer> returnedList = new ArrayList<Integer>();

    public List<Integer> cheapestJump(int[] A, int B) {

        int []index = new int[A.length+1];
        if(A==null || A.length == 0){
            return returnedList;
        }
        index[1] = 0;
        int [] memo= new int[A.length+1];
        Arrays.fill(memo,-1);

        int mincost = cheapestJumpHelper(0,A,B,index,memo);
        if(mincost <0 || mincost == Integer.MAX_VALUE){
            System.out.println("mincost"+mincost);

            return returnedList;
        }
        else{
            System.out.println("mincost"+mincost);
            // System.out.println(pathagain);
            printpath(index,A.length);
            return returnedList;
        }
    }
    private static int cheapestJumpHelper(int i,int[] array, int b, int[] index,int []memo) {
        if(i == array.length-1 && array[i]!=-1){
            return array[i];
        }
        int min = Integer.MAX_VALUE;
        int minindex=-1;
        if(memo[i] !=-1) return memo[i];
        for(int path = i+1;path<=array.length-1  && path<=i+b;path++){
            if(array[path] == -1){
                continue;
            }
            if(min>=array[i]+cheapestJumpHelper(path,array,b,index,memo)){
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
        System.out.println("loop");
        printpath(array,array[startindex]);
        returnedList.add(startindex);
    }

    public static void main(String[] args) {
        int array[]={0, -1, -1, -1, 0,0};
        int B = 1;
        Solution solution = new Solution();
        System.out.println(solution.cheapestJump(array,B));

    }
}
