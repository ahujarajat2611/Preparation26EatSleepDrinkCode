/**
 * 
 */
package DSA.Arrays2;

import BasicAlgorithms.utils.ConsoleWriter;
import DSA.Common.CommonUtil;


import java.io.Console;

/**
 * @author Raj
 *
 */
public class Segregate0s1sInSinglePass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };

		Segregate0s1sInSinglePass obj = new Segregate0s1sInSinglePass();
		// Of course O(n)
		// obj.segregate0s1sInSinglePass(a, a.length);
		// CommonUtil.printArray(a);
		int x= obj.segregate0s1sInSinglePass(a, a.length);
		System.out.println(x);
		ConsoleWriter.printArray(a);
	}

	public int seg(int a[], int n) {
		int l = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				CommonUtil.swap(a, l++, i);
			}
		}
		return l;
	}

	public int segregate0s1sInSinglePass(int[] a, int n) {
		int left = 0, right = n - 1;
		while (left < right) {
			while (a[left] == 0 && left < right) {
				left++;
			}
			while (a[right] == 1 && left < right) {
				right--;
			}
			if (left < right) {
				a[left] = 0;
				a[right] = 1;
				left++;
				right--;
			}
		}
		return left;
	}
	public int segregate0s1sInSinglePassAnother(int[] a, int n) {
		int left = 0, right = n - 1;
		while (left <= right) {
			while (a[left] == 0 && left <= right) {
				left++;
			}
			while (a[right] == 1 && left <= right) {
				right--;
			}
			if (left <= right) {
				a[left] = 0;
				a[right] = 1;
				left++;
				right--;
			}
		}
		return left;
	}

}
