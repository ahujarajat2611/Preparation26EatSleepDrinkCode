/**
 * 
 */
package DSA.Arrays2;


import BasicAlgorithms.utils.ConsoleWriter;
import DSA.Common.CommonUtil;

/**
 * @author Raj
 *
 */
public class Segregate0s1s2sInSinglePass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		int b[] = { 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0 };

		Segregate0s1s2sInSinglePass obj = new Segregate0s1s2sInSinglePass();
		// Of course O(n)
		int indexOfPivot = obj.segregate0s1s2sInSinglePass(b, a.length);
		System.out.println(indexOfPivot);
		ConsoleWriter.printArray(b);
	}

	public int segregate0s1s2sInSinglePass(int[] a, int n) {
		int low = 0, mid = 0, high = n - 1;

		// high points to n-1 but you are still not sure whether whteher that position is correct or not
		// low points to zero but position might be incorrect ...
		while (mid <= high) {
			switch (a[mid]) {
			case 0:
				CommonUtil.swap(a, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				CommonUtil.swap(a, mid, high);
				high--;
			}
		}
		return low;
	}

}
