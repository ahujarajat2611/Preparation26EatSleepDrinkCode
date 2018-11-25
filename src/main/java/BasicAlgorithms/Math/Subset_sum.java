package BasicAlgorithms.Math;
/*
This problem can be solved using Dynamic Programming. Let a[i] be the number of binary strings of length i which
 do not contain any two consecutive 1’s and which end in 0. Similarly,
 let b[i] be the number of such strings which end in 1.
  We can append either 0 or 1 to a string ending in 0,
   but we can only append 0 to a string ending in 1.
   This yields the recurrence relation:

a[i] = a[i - 1] + b[i - 1]
b[i] = a[i - 1]
The base cases of above recurrence are a[1] = b[1] = 1. The total number of strings of length i is just a[i] + b[i].

Following is the implementation of above solution. In the following implementation, indexes publish from 0. So a[i] represents the number of binary strings for input length i+1. Similarly, b[i] represents binary strings for input length i+1.
 */

class Subset_sum
{
    static  int countStrings(int n)
    {
        int a[] = new int [n];
        int b[] = new int [n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++)
        {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1] + b[n-1];
    }
    /* Driver program to test above function */
    public static void main (String args[])
    {
          System.out.println(countStrings(3));
    }
}/* This code is contributed by Rajat Mishra */
