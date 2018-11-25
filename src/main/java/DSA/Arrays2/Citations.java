package DSA.Arrays2;

/**
 * Created by hadoop on 4/2/18.
 */
/*
/*
Given an array of citations (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers
have at least h citations each,
and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and
each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?
A faster approach is to use extra space.

Google Facebook
Hide Tags Hash Table Sort
Hide Similar Problems (M) H-Index II

*/
/*
Thoughts:O(nlogn)
	N = 5, so max of h = 5. min of h = 0.
		1. h = 5, loop through the array and count the # of citations that are >= h.
		2 .h = 4 ... h=1, h=0.
		=> O(n^2).

	If sort it : 0,1,3,5,6
		Find find index x = N - h, and arr[x] >= h
		that becomes find index x that arr[x] >=h ,where h = N - x.
			Foor loop on h, O(n)
				pick x = N - h, and check if arr[x] >= h
		h = 5, x = 5 -5 = 0. arr[x] = 0 < h. not working
		h = 4, x = 5 - 4 = 1. arr[x] = 1. no.
		h=3,x=5-3 =2,arr[x]=3  3>=3, okay.
	nLogn + N = O(nlogn)

 */
import java.util.*;
public class Citations {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        for (int h = citations.length; h > 0; h--) {
            int x = citations.length - h;
            if (citations[x] >= h) {
                return h;
            }
        }
        return 0;
    }
    public int hIndexIfSortedArray(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int start = 0;
        int end = len - 1;
        while (start<end){
            int mid = start+ (end-start)/2;
            if(citations[mid] >= citations.length-mid){
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return citations.length-start;
    }
}
