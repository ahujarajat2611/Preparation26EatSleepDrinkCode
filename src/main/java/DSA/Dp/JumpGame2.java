/**
 *
 */
package DSA.Dp;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author Raj
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.


 */

public class JumpGame2 {

    public int jump(int[] a) {
        // e: longest distance in current minimum step
        // steps: minimum steps for reaching e

        int steps = 0;
        int e = 0;
        int max = 0;
        // we don't need to calculate for last, because there is no point in jumping from last step
        for (int i = 0; i < a.length - 1; i++) {
            max = Math.max(max, i + a[i]);
            if (i == e) {
                steps++;
                e = max;
            }
        }
        return max>=a.length-1?steps:Integer.MAX_VALUE;
    }

    public int jump2(int[] a) {
        // e: longest distance in current minimum step
        // steps: minimum steps for reaching e


        int start =0;
        int end =0+a[0];
        int max=0;
        int steps = 0;
        TreeSet<String> set = new TreeSet<String>();
        while (start<a.length){
            for(int i=start;i<=end;i++){
                if(i>=a.length-1){
                    System.out.println("return form here "+steps);
                    return steps;
                }
                  max =  Math.max(max,start+a[i]);
            }
            steps++;
            start = end;
            end = max;
            if(!set.contains(start+""+end)){
                set.add(start+""+end);
            }
            else {
                return Integer.MAX_VALUE;
            }
        }
        System.out.println("return from here  last");
        return steps;

        // we don't need to calculate for last, because there is no point in jumping from last step
//        for (int i = 0; i < a.length - 1; i++) {
//            max = Math.max(max, i + a[i]);
//            if (i == e) {
//                steps++;
//                e = max;
//            }
//        }
      //  return max>=a.length-1?steps:Integer.MAX_VALUE;
    }



    
    
    public static void main(String[] args) {
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int b[] = {3, 2, 1, 0, 4 };
        int result = -1;
        JumpGame2 obj = new JumpGame2();

        result = obj.jump(b);

        System.out.println(result);
        result = obj.jump2(b);
        System.out.println(result);
//        int b[] = {3, 2, 1, 0, 4 };
//
//
//
//        result = obj.jump(b);
//        System.out.println(result);
//        result = obj.jump2(b);
//        System.out.println(result);
    }
    public int jumpGameBestAndCorrectSOlution(int[] A) {
        if (A == null || A.length == 0 || A.length ==1) {
            return 0;
        }
        int pStart = 0;
        int pEnd = 0 ;

        int steps = 0;
        int farthest = 0;
        while (pStart < A.length) {
            pEnd = Math.max(pStart,farthest);
            steps++;    //Cound step everytime when pEnd is moving to the farthest.
            //Find farest possible and see if reach the tail
            for (int i = pStart; i <= pEnd; i++) {
                farthest = Math.max(farthest, i + A[i]);
                if (farthest >= A.length - 1) {
                    return steps;
                }
            }
            //Re-select pointer position for publish and end
            pStart = pEnd ;
            pEnd = farthest;
        }
        return -1;  //This is the case where no solution can be found.
    }

}
