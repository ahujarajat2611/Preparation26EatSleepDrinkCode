/**
 * 
 */
package DSA.Mathematical;

/**
 * @author Raj
 *
 *         Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6,
 *         7, 8, 9, 10, 11, ...
 * 
 *         Note: n is positive and will fit within the range of a 32-bit signed
 *         integer (n < 231).
 * 
 *         Example 1:
 * 
 *         Input: 3
 * 
 *         Output: 3 Example 2:
 * 
 *         Input: 11
 * 
 *         Output: 0
 * 
 *         Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8,
 *         9, 10, 11, ... is a 0, which is part of the number 10.
 * 
 */
public class NthDigitInSequence {

	/*
	 * find the length of the number
	 * where the nth digit is from
	 * 
	 * find the actual number where the
	 * nth digit is from
	 * 
	 * find the nth digit and return
	 */
	public static int nthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int res = -1;
		res = nthDigit(12);
		System.out.println(res);
		res = nthDigit(5);
		System.out.println(res);

	}

}
