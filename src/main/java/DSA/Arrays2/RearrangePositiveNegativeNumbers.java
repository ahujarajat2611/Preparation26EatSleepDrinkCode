package DSA.Arrays2;

import DSA.Common.CommonUtil;

/**
 * Created by hadoop on 21/2/18.
 */
public class RearrangePositiveNegativeNumbers {
    // A JAVA program to put positive numbers at even indexes
// (0, 2, 4,..) and negative numbers at odd indexes (1, 3,
// 5, ..)


        // The main function that rearranges elements of given
        // array.  It puts positive elements at even indexes (0,
        // 2, ..) and negative numbers at odd indexes (1, 3, ..).
        static void rearrange(int arr[], int n)
        {
            // The following few lines are similar to partition
            // process of QuickSort.  The idea is to consider 0
            // as pivot and divide the array around it.
            int i = -1, temp = 0;
            for (int j = 0; j < n; j++)
            {
                if (arr[j] < 0)
                {
                    i++;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // Now all positive numbers are at end and negative numbers at
            // the beginning of array. Initialize indexes for starting point
            // of positive and negative numbers to be swapped
            int pos = i+1, neg = 0;

            // Increment the negative index by 2 and positive index by 1, i.e.,
            // swap every alternate negative number with next positive number
            while (pos < n && neg < pos && arr[neg] < 0)
            {
                temp = arr[neg];
                arr[neg] = arr[pos];
                arr[pos] = temp;
                pos++;
                neg += 2;
            }
        }

        // A utility function to print an array
        static void printArray(int arr[], int n)
        {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + "   ");
        }

        /*Driver function to check for above functions*/
        public static void main (String[] args)
        {
            int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
            int n = arr.length;
            rearrange(arr,n);
           // rearrangeMy(arr,arr.length);
            System.out.println("Array after rearranging: ");
            printArray(arr,n);
        }
    static void rearrangeMy(int arr[], int n){

            int pos = 0;
            int neg = 1;

            while (pos<n && neg<n){

                while (pos<n && arr[pos]>=0){
                    pos = pos + 2;
                }
                while (neg<n && arr[neg]<0){
                    neg = neg +2;
                }
                if(pos <n && neg<n){
                    CommonUtil.swap(arr,pos,neg);
                    pos  = pos +2;
                    neg = neg + 2;
                }
            }
        /*
        2   -1   4   -3   5   -7   6   8   9

         */
    }


}
/*This code is contributed by Devesh Agrawal*/
