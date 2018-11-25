package BasicAlgorithms.Math;

// * Given an integer n, return the number of trailing zeroes in n!.

//Note: Your solution should be in logarithmic time complexity.
 //*/
public class factorialTrailingZeroes {
    //10 made by 2 * 5
	// 2 always more than 5
	// 25, 125,... contains more 5
	public int trailingZeroes(int n) {
		int count = 0;
		long divider = 5;
		long x = n;
		// divide by 5 until divider becomes more than n
		while (x >= divider) {
			count += n/divider;
			divider *= 5;
		}
		return count;
    }
	
	// Just count how many 5 ocurs.
	public int trailingZeroes2 (int n) {
		int count = 0;
		while (n/5 >= 1) {
			count += n/5;
			n /= 5;			
		}
		return count;
	}
}
