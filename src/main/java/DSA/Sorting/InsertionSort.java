/**
 * 
 */
package DSA.Sorting;


import BasicAlgorithms.utils.ConsoleWriter;

/**
 * @author Raj
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 9, 6, 5, 0, 8, 2, 7, 1 };
		InsertionSort obj = new InsertionSort();
		obj.insertionSort(a, a.length);
		ConsoleWriter.printArray(a);
		obj.insertionSortDescending(a, a.length);
		ConsoleWriter.printArray(a);
	}

	public void insertionSort(int[] a, int n) {
		int key, j;
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	public void insertionSortDescending(int[] a, int n) {
		int key, j;
		for (int i = 1; i < n; i++) {
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] < key) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	public void insertionSortAgain(int[] a, int n) {

		for(int i=1;i<n;i++){
			
			int key = a[i];
			int k = i-1;
			while(k>=0 && key<a[k]){
				a[k+1] = a[k];
			}
			a[k+1] = key;
		}
	}























	}
