//package BasicAlgorithms.QuickSelect;
//
///**
// * Created by hadoop on 15/1/18.
// */
//public class minmovestomakearrraysorted {
//}
//
///*
//Given an array arr[] of non negative integers
// . We can perform a swap operation on any two adjacent elements in the array.
// Find the minimum number of swaps needed to sort the array in ascending order.
//
// */
///*
//Given an array arr[] of non negative integers. We can perform a swap operation on any two adjacent elements in the array.
// Find the minimum number of swaps needed to sort the array in ascending order.
//
//Examples:
//
//Input  : arr[] = {3, 2, 1}
//Output : 3
//We need to do following swaps
//(3, 2), (3, 1) and (1, 2)
//
//Input  : arr[] = {1, 20, 6, 4, 5}
//Output : 5
//)
//There is an interesting solution to this problem. It can be solved using the fact that number of swaps needed is equal to number of inversions. So we basically need to count inversions in array.
//
//The fact can be established using below observations:
//1) A sorted array has no inversions.
//2) An adjacent swap can reduce one inversion. Doing x adjacent swaps can reduce x inversions in an array.
//
//Below is C++ implementation based on idea. The code is simply copied from here.
//
//// C++ program to count number of swaps required
//// to sort an array when only swapping of adjacent
//// elements is allowed.
//#include <bits/stdc++.h>
//
///* This function merges two sorted arrays and returns inversion
//   count in the arrays.*/
///*
//int merge(int arr[], int temp[], int left, int mid, int right)
//{
//    int inv_count = 0;
//
//    int i = left; /* i is index for left subarray*/
//    int j = mid;  /* i is index for right subarray*/
//    int k = left; /* i is index for resultant merged subarray*/
//    while ((i <= mid - 1) && (j <= right))
//    {
//        if (arr[i] <= arr[j])
//            temp[k++] = arr[i++];
//        else
//        {
//            temp[k++] = arr[j++];
//
//            /* this is tricky -- see above explanation/
//              diagram for merge()*/
//            inv_count = inv_count + (mid - i);
//        }
//    }
//
//    /* Copy the remaining elements of left subarray
//     (if there are any) to temp*/
//    while (i <= mid - 1)
//        temp[k++] = arr[i++];
//
//    /* Copy the remaining elements of right subarray
//     (if there are any) to temp*/
//    while (j <= right)
//        temp[k++] = arr[j++];
//
//    /*Copy back the merged elements to original array*/
//    for (i=left; i <= right; i++)
//        arr[i] = temp[i];
//
//    return inv_count;
//}
//
//    /* An auxiliary recursive function that sorts the input
//       array and returns the number of inversions in the
//       array. */
//    int _mergeSort(int arr[], int temp[], int left, int right)
//    {
//        int mid, inv_count = 0;
//        if (right > left)
//        {
//        /* Divide the array into two parts and call
//          _mergeSortAndCountInv() for each of the parts */
//            mid = (right + left)/2;
//
//        /* Inversion count will be sum of inversions in
//           left-part, right-part and number of inversions
//           in merging */
//            inv_count  = _mergeSort(arr, temp, left, mid);
//            inv_count += _mergeSort(arr, temp, mid+1, right);
//
//        /*Merge the two parts*/
//            inv_count += merge(arr, temp, left, mid+1, right);
//        }
//
//        return inv_count;
//    }
//
//    /* This function sorts the input array and returns the
//       number of inversions in the array */
//    int countSwaps(int arr[], int n)
//    {
//        int temp[n];
//        return _mergeSort(arr, temp, 0, n - 1);
//    }
//
//    /* Driver progra to test above functions */
//    int main(int argv, char** args)
//    {
//        int arr[] = {1, 20, 6, 4, 5};
// /*
// */