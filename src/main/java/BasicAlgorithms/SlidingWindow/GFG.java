package BasicAlgorithms.SlidingWindow;// Java program to find longest subarray with
// sum of elements at-least k.
import java.util.*;

/*
Longest Subarray having sum of elements atmost ‘k’
2.5
Given an array of integers, our goal is to find the length of largest subarray having sum of its elements atmost ‘k’ where k>0.

Examples:

Input : arr[] = {1, 2, 1, 0, 1, 1, 0},
           k = 4
Output : 5
Explanation:
 {1, 2, 1} => sum = 4, length = 3
 {1, 2, 1, 0}, {2, 1, 0, 1} => sum = 4, length = 4
 {1, 0, 1, 1, 0} =>5 sum = 3, length = 5
 */
class GFG {
     
    // function to find the length of largest
    // subarray having sum atmost k.
    public static int atMostSum(int arr[], int n,
                                        int k)
    {
        int sum = 0;
        int cnt = 0, maxcnt = 0;
     
        for (int i = 0; i < n; i++) {
             
            // If adding current element doesn't
            // cross limit add it to current window
            if ((sum + arr[i]) <= k) {
                sum += arr[i]; 
                cnt++;
            } 
     
            // Else, remove first element of current
            // window.
            else if(sum!=0)
           {
            sum = sum - arr[i - cnt] + arr[i];
           }
     
            // keep track of max length.
            maxcnt = Math.max(cnt, maxcnt); 
        }
        return maxcnt;
    }

    public static int atMostSumMine(int arr[], int n,
                                int k){
        int start =0;
        int end = 0;

        int sum =0;
        int ans=0;
        while (end<arr.length){
            sum = sum + arr[end];
//            System.out.println("sum "+sum);
//            System.out.println("publish"+publish);
//            System.out.println("end"+end);
//            System.out.println("=====");
            if(start<end && sum>k){
                sum = sum -arr[start];
                start++;
            }
            if(start<end && sum <= k){
                ans = Math.max(ans,end-start+1);
            }
            end++;
        }
        return ans;
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) 
    {
        int arr[] = { 1, 2, 1};
        int n = arr.length;
        int k = 4;
     
        System.out.print(atMostSumMine(arr, n, k));
             
    }
}