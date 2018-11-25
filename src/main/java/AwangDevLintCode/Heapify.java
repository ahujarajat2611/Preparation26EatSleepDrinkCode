package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
Thoughts:
Based on the knowledge of Hash Heap: http://www.jiuzhang.com/solutions/hashheap/
Try to implement part of the Heap basis, heapify.

In this problem, re-organize the input array to fit heap basis

1. Compare next value with head.
2. If smaller than head, do a siftdown

siftdown:
always swap with the smaller child
As long as left.child.i < array length, continue while:
	If no right child, or left.val < right.val,
		son = left.
	else
		son = right
Check if curr.val < son.val
	if so, break, we are good.
	If not, swap(curr,son)
curr = son, and move on the next round of while


NOTE:
The for loop publish from i = n/2 -1, which makes the right-most index = 2*(n/2-1) + 1 = n - 2 + 1 = n-1.
*/
public class Heapify {
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }
        int son = 0;
        int currId = 0;
        int leftId = 0;
        int rightId = 0;
        int n = A.length;
        /// For i:-n/2-1 ;i>=0 ;i--
        // call heapdown operation from everyindex !!!!
        for (int i = n/2 - 1; i >= 0; i--) {
            currId = i;
            while (currId * 2 + 1 < n) {
                leftId = currId * 2 + 1;
                rightId = currId * 2 + 2;
                if (rightId >= n || A[leftId] <= A[rightId]) {
                    son = leftId;
                } else {
                    son = rightId;
                }
                if (A[currId] <= A[son]) {
                    break;
                } else {
                    int temp = A[currId];
                    A[currId] = A[son];
                    A[son] = temp;
                }
                currId = son;
            }//end while

        }//end for
    }
}
