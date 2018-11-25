/**
 * 
 */
package DSA.Bit;

/**
 * @author Raj
 *
 */
public class FindNumberOccuringOddNumberOfTimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindNumberOccuringOddNumberOfTimes obj = new FindNumberOccuringOddNumberOfTimes();
		int result = -1;
		int a[] = { 1, 2, 3, 2, 3, 1, 3 };

		// Time :O(n2)
		result = obj.findNumberOccuringOddNumberOfTimesBruteForce(a, a.length);
		System.out.println(result);
		// Time :O(n)
		result = obj.findNumberOccuringOddNumberOfTimesUsingXOR(a, a.length);
		System.out.println(result);

	}

	public int findNumberOccuringOddNumberOfTimesBruteForce(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			count = 0;
			for (int j = 0; j < n; j++) {
				if (a[i] == a[j]) {
					count++;
				}
			}
			if (count % 2 != 0)
				return a[i];
		}
		return -1;
	}

	public int findNumberOccuringOddNumberOfTimesUsingXOR(int[] a, int n) {
		if (n <= 0)
			return -1;
		if (n == 1)
			return a[0];

		int x = a[0];

		for (int i = 1; i < n; i++) {
			x = x ^ a[i];
		}
		return x;
	}

}
