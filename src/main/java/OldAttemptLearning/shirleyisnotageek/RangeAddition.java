package OldAttemptLearning.shirleyisnotageek;// Java program to get updated array after
// many array range add operation
import java.io.*;
  
class RangeAddition
{
    // Utility method to add value val,
    // to range [lo, hi]
    static void add(int arr[], int N, int lo,
                           int hi, int val)
    {
        arr[lo] += val;
        if (hi != N - 1)
           arr[hi + 1] -= val;
    }
     
    // Utility method to get actual array from 
    // operation array
    static void updateArray(int arr[], int N)
    {
        // convert array into prefix sum array
        for (int i = 1; i < N; i++)
            arr[i] += arr[i - 1];
    }
      
    // method to print final updated array
    static void printArr(int arr[], int N)
    {
        updateArray(arr, N);
        for (int i = 0; i < N; i++)
            System.out.print(""+arr[i]+" ");
        System.out.print("\n");
    }
      
    // Driver code to test above methods
    public static void main (String[] args) 
    {
        int N = 6;
  
        int arr[] = new int[N];
      
        // Range add Queries
        add(arr, N, 0, 2, 100);
        add(arr, N, 1, 5, 100);
        add(arr, N, 2, 3, 100);
      
        printArr(arr, N);
    }
}