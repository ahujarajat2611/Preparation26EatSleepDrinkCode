package DSA.Array;

/**
 * Created by hadoop on 10/2/18.
 */
public class LargestSumContinous {
    int largestContiguousSumUsingDp(int a[], int n) {
        int sum[] = new int[n];
        sum[0] = a[0];
        int max = sum[0];
        for (int i = 1; i < n; i++) {
            sum[i] = Math.max(sum[i - 1] + a[i], a[i]);
            max = Math.max(sum[i], max);
        }
        return max;
    }
    public void kadanAgain(int []temp){
        int maxSum = Integer.MAX_VALUE;
        int curretSum = 0;
        for(int num:temp){
            curretSum = Math.max(curretSum+num,num);
            maxSum = Math.max(curretSum,maxSum);
        }
        System.out.println("Max Sum" +maxSum);
    }
    public int kadanSimplest(int []temp) {
        int []current = new int[temp.length];
        int []max = new int[temp.length];

        current[0] = Math.max(0,temp[0]);
        max[0] = Math.max(0,temp[0]);

        int ans = 0;
        for(int i=1;i<temp.length;i++){
            current[i] = Math.max(current[i-1]+temp[i],temp[i]);
            max[i] = Math.max(max[i-1],current[i]);
            ans = Math.max(ans,max[i]);
        }

        return ans;
    }
}
