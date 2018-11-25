/**
 * 
 */
package DSA.Arrays2;

import BasicAlgorithms.utils.ConsoleWriter;
import DSA.Common.CommonUtil;

import java.util.Random;

/**
 * @author Raj
 *
 */
public class ShuffleArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShuffleArray obj = new ShuffleArray();
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = a.length;
		// Time :O(n)
		// Fisher-Yates Shuffle Modern Algorithm
		ConsoleWriter.printArray(a);
		obj.shuffle(a, n);
		ConsoleWriter.printArray(a);

	}

	public void shuffle(int[] a, int n) {
		int rand, curSize = n;
		for (int i = n - 1; i > 0; i--) {
			// instead of curSize you can use (i+1) for optimized logic
			//
			Random random = new Random();
			System.out.println(random.nextInt(1));
			rand = (int) (Math.random() * curSize);
			curSize--;
			CommonUtil.swap(a, rand, i);
		}
	}

}
