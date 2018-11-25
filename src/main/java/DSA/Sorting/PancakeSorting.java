/**
 * 
 */
package DSA.Sorting;

import BasicAlgorithms.utils.ConsoleWriter;

import static BasicAlgorithms.Array.PracticeArrays.swap;

/**
 * @author Raj
 *
 */
public class PancakeSorting {

	public int findMaxIndex(int a[], int l, int r) {
		int max_index = -1;
		for (int i = l; i <= r; i++) {
			if (max_index == -1) {
				max_index = i;
				continue;
			}
			if (a[i] > a[max_index]) {
				max_index = i;
			}
		}
		return max_index;
	}

	public void flip(int a[], int l, int r) {
		while (l < r) {
			swap(a, l++, r--);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 9, 6, 5, 0, 8, 2, 7, 1 };
		PancakeSorting obj = new PancakeSorting();
		// Time : O(n2), Space : O(1)
		obj.pancakeSort(a, a.length);
		ConsoleWriter.printArray(a);

		// Time : O(n2), Space : O(1)
		// obj.pancakeSortDescending(a, a.length);
		// CommonUtil.printArray(a);

	}

	// Time : O(n2), Space : O(1)
	public void pancakeSortDescending(int[] a, int n) {
		int max_index = -1;
		for (int i = 0; i < n - 1; i++) {
			max_index = findMaxIndex(a, i, n - 1);

			if (i != max_index) {
				flip(a, max_index, n - 1);
				flip(a, i, n - 1);
			}
			ConsoleWriter.printArray(a);
		}
	}

	// Time : O(n2), Space : O(1)
	public void pancakeSort(int[] a, int n) {
		int max_index = -1;
		ConsoleWriter.printArray(a);
		for (int i = n - 1; i > 0; i--) {
			max_index = findMaxIndex(a, 0, i);
			if (i != max_index) {
				flip(a, 0, max_index);
				flip(a, 0, i);
			}
			ConsoleWriter.printArray(a);
		}
	}

	public void panCakeSortin(int []a,int n ){

		int max_index = -1;
		for(int i=0;i<n;i++){
			max_index = findMaxIndex(a,0,n-i-1);
			flip(a,0,max_index);
			flip(a,0,n-i-1);
		}
	}
}
