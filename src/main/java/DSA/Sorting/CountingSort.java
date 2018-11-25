/**
 * 
 */
package DSA.Sorting;


import BasicAlgorithms.utils.ConsoleWriter;

/**
 * @author Raj
 *
 */
public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 3, 2, 3, 3, 0, 5, 2, 4 };
		CountingSort obj = new CountingSort();

		int n = a.length;
		int m = 6; // values of are ranging from (0 to 5)

		// Time : O(n+m), Space : O(n+m)
		// this is stable version of count sort
		ConsoleWriter.printArray(a);
		a = obj.countSort(a, n, m);
		ConsoleWriter.printArray(a);

		int b[] = { 0, 3, 2, 3, 3, 0, 5, 2, 4 };
		// this is not stable but can be done in in-place
		obj.countSortInplace(b, n, m);
		ConsoleWriter.printArray(b);

	}

	public void countSortInplace(int[] a, int n, int m) {
		int count[] = new int[m];
		for (int i = 0; i < n; i++) {
			count[a[i]]++;
		}
		int j = 0, k;
		for (int i = 0; i < m; i++) {
			k = count[i];
			while (k > 0) {
				a[j++] = i;
				k--;
			}
		}
	}

	public int[] countSort(int[] a, int n, int m) {
		// m Denotes the rangeeee of counting sort .. 
		// array length 
		int count[] = new int[m];
		int result[] = new int[n];

		for (int i = 0; i < n; i++) {
			count[a[i]]++;
		}
		for (int i = 1; i < m; i++) {
			count[i] = count[i] + count[i - 1];
		}
		ConsoleWriter.printArray(count);

		for (int i = n - 1; i >= 0; i--) {
			result[count[a[i]] - 1] = a[i];
			count[a[i]]--;
		}
		return result;
	}

}
