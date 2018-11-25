package BasicAlgorithms.SegmentTree;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by hadoop on 24/10/17.
 */
public class MaxSumRectangleNoGreaterThanK {
//    public int[][] submatrixSumEasyMethod(int[][] matrix,int k) {

    public Integer submatrixSumEasyMethod(int[][] matrix,int k) {
    if (matrix.length == 0 || matrix == null) {
           // return new int[][]{};
            return 0;
        }
        int answer = 0;
        for(int i=0;i<matrix.length;i++){
            int []cumulativeRow = new int[matrix[0].length];
            for(int j=i;j<matrix.length;j++){

                for(int col =0;col<matrix[0].length;col++){
                    cumulativeRow[col] = cumulativeRow[col] + matrix[j][col];
                }
           //     int []ans = getAnsFromOneD(cumulativeRow);
              //  ConsoleWriter.printIntArray(cumulativeRow);
                int []ans = maxsumNoGreaterThanKAgain(cumulativeRow,k);
                if(ans!=null){
                    answer = Math.max(answer,ans[0]);
//                    return new int[][]{{i,ans[0]},{j,ans[1]}};
                }
            }
        }
        return answer;
     //   return new int[][]{{}};
    }

    private int[] getAnsFromOneD(int[] cumulativeRow) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0;
        for(int i=0;i<cumulativeRow.length;i++){
            sum = sum +cumulativeRow[i];
            if(hm.containsKey(sum)){
                return new int[]{hm.get(sum)+1,i};
            }
            hm.put(sum,i);
        }
        return null;
    }
    private int[] maxsumNoGreaterThanKAgain(int []cumulativeRow,int k) {
        int sum = 0;
        TreeSet<Integer> hm = new TreeSet<Integer>();
        int maxsumlessthank = Integer.MIN_VALUE;
        hm.add(0);
        for(int i=0;i<cumulativeRow.length;i++){
            sum = sum + cumulativeRow[i];
            //System.out.println(sum);
            if(hm.ceiling(sum-k)!=null) {
                maxsumlessthank = Math.max(maxsumlessthank, sum - hm.ceiling(sum - k));
            }
            hm.add(sum);
        }
        if(maxsumlessthank!=Integer.MIN_VALUE){
            return new int[]{maxsumlessthank};
        }
        return null;
    }

    private int[] maxsumNoGreaterThanK(int []cumulativeRow,int k){
        ConsoleWriter.printIntArray(cumulativeRow);
        int []left = new int[cumulativeRow.length];
        int []current = new int[cumulativeRow.length];
        int globalmaxsum = 0;
        int currentsum = 0;
        for(int i=0;i<cumulativeRow.length;i++){
            if(i ==0 ){
                left[i] = cumulativeRow[i];
                current[i] = cumulativeRow[i];
                globalmaxsum = cumulativeRow[i];
                currentsum = cumulativeRow[i];
            }
            else {
                currentsum = Math.max(currentsum + cumulativeRow[i],cumulativeRow[i]);
                System.out.println("current "+currentsum);
                current[i] = currentsum;
                globalmaxsum = Math.max(globalmaxsum,currentsum);
                left[i] = Math.max(left[i-1],currentsum);
            }
        }
        int ansagain=Integer.MIN_VALUE;
        ConsoleWriter.printIntArray(left);
        ConsoleWriter.printIntArray(current);
        for(int i=0;i<cumulativeRow.length;i++){
            if(current[i] <=k){
                ansagain = Math.max(current[i],ansagain);
            }
        }
        System.out.println("glo"+ansagain);
        if(ansagain<=k){
            return new int[]{ansagain};
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        MaxSumRectangleNoGreaterThanK maxSumRectangleNoGreaterThanK = new MaxSumRectangleNoGreaterThanK();
        int [][]matrix =
        {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};

        int p = 3;
        System.out.println(maxSumRectangleNoGreaterThanK.submatrixSumEasyMethod(matrix,8));
        //System.out.println(maxSumRectangleNoGreaterThanK.maxsumNoGreaterThanKAgain(new int[]{2, -3, 9, 1},8)[0]);
    }
}
