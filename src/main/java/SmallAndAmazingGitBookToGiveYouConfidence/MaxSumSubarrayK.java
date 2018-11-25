package SmallAndAmazingGitBookToGiveYouConfidence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 21/9/17.
 */
public class MaxSumSubarrayK {

    public int maxSubArray(ArrayList<Integer> list ,int k){

        int [][]sum = new int[k+1][list.size()+1];
        for(int i=1;i<=k;i++){
            for(int j=i-1;j<list.size();j++){
                int currentSum=0;
                int max = Integer.MIN_VALUE;
                for(int partition = j;partition>=i;partition--){
                    currentSum = Math.max(currentSum+list.get(partition),list.get(partition));
                    max = Math.max(max,currentSum);
                    sum[i][j] = Math.max(sum[i][j],sum[i-1][partition-1] +max);
                }
            }
        }
        return sum[k][list.size()-1];

    }
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(4);
        list.add(-2);
        list.add(3);
        list.add(-2);
        list.add(3);
        MaxSumSubarrayK maxSumSubarrayK = new MaxSumSubarrayK();
        System.out.println(maxSumSubarrayK.maxSubArray(list,2));
    }
}
