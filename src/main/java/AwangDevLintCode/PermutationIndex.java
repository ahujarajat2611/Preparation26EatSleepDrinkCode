package AwangDevLintCode;

/**
 * Created by hadoop on 9/2/18.
 */
/*
Given a permutation which contains no repeated number, find its index in all the permutations of these numbers,
which are ordered in lexicographical order. The index begins at 1.


Example
Given [1,2,4], return 1.
*/

/*
	Thoughts:
	Given some thoughts online:
	Take one example 4,2,1 (totally reversed, worse case)
	Assume array length = n
	1. If sorted, it should be 1,2,4. In permutation, when does 4 appear? It appears after 1xx,2xx. That is, it appears after all of the smaller ones show up.
	2. For each number smaller than 4 in later indexes, each of them all have (n-1)! mutations. n -1 is actaully: current 0-based index of 4.
	Therefore, for head number 4, there are:
		#ofSmallerNumber * (curr 0-base index)!
	3. For loop on each num, calculate
		SUM {#ofSmallerNumber * (index i)!}
	4. To store #ofSmallerNum, put hashmap<num, index>. For example, for number 4, with index 2: There are 2 numbers smaller than 4, which are 1 and 2.

	O(n^2)
*/

import java.util.*;
public class PermutationIndex {
    public long permutationIndex(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = A.length;
        long rst = 0;
        //O(n^2)
        //Count: in A, after A[i], how many smaller nums are left behind.
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[i]) {
                    count++;
                }
            }
            map.put(A[i], count);
        }
        //O(n^2)
        for (int i = 0; i < n; i++) {
            long fact = 1;
            for (int j = (n - i - 1); j >= 1; j--) {
                fact *= j;
            }
            // at each index number of smaller elements * fact(n-index-1)
            rst += map.get(A[i]) * fact;
            // rest + = map.get(A[i]) * fact(n-i-1);
        }
        return rst + 1;
    }
}
