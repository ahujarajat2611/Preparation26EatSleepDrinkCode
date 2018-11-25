/**
 * 
 */
package DSA.Arrays2;

import BasicAlgorithms.utils.ConsoleWriter;

/**
 * @author Raj
 *
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseArray obj = new ReverseArray();
		int a[] = { 1, 2, 3, 4, 5 };
		obj.reverse(a);
		ConsoleWriter.printArray(a);
		obj.reverseRecursive(a, 0, a.length - 1);
		ConsoleWriter.printArray(a);
	}

	public void reverseRecursive(int[] a, int l, int r) {
		if (l > r)
			return;
		ConsoleWriter.swap(a, l, r);
		reverseRecursive(a, ++l, --r);
	}

	public void reverse(int[] a) {
		int l = 0, r = a.length - 1;

		while (l < r) {
			ConsoleWriter.swap(a, l, r);
			l++;
			r--;
		}

	}

}
