package BasicAlgorithms.Paritition;

import java.util.*;
public class partitionArray0And1 {
    //Same as partition array. Two pointer, one from head, one from tail.
	public static void partition(int[] A) {
		if (A == null || A.length == 0)
			return;
		int l = 0;
		int r = A.length-1;
		while (l < r) {
			if (A[l] == 1 && A[r] == 0)
				swap(A, l, r);
			else if (A[l] == 0)
				l++;
			else if (A[r] == 1)
				r--;
		}
	}

	public static void mypartition(int []A){
		int l =0;
		int e = A.length-1;
		int m = l;
		while (m<=e){
			if(A[m]<0){
				swap(A,m,l);
				m++;
				l++;
			}
			else if(A[m] == 0){
				m++;
			}
			else if(A[m] == 1){
				swap(A,m,e);
				e--;
			}
		}
	}
	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,1,1,1,1,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,0};
		mypartition(A);
		System.out.println(Arrays.toString(A));
	}
}
