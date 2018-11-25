/**
 * 
 */
package DSA.Sorting;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @author Raj
 *
 */
public class SortArrayToFormBiggestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 34, 3, 98, 9, 76, 45, 4 };
		SortArrayToFormBiggestNumber obj = new SortArrayToFormBiggestNumber();
		int n = a.length;
		obj.sortArrayToFormBiggestNumber(a, n);
		ConsoleWriter.printIntArray(a);
	}

	public Comparator<String> customSorter = new Comparator<String>() {
		public int compare(String x, String y) {
			String xy = x + y;
			String yx = y + x;
			return yx.compareTo(xy);
		}
	};

	public void sortArrayToFormBiggestNumber(int[] a, int n) {
		String[] s = new String[n];
		for (int i = 0; i < n; i++)
			s[i] = Integer.toString(a[i]);
		Arrays.sort(s, customSorter);
		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(s[i]);

	}

}
