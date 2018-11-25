/**
 * 
 */
package DSA.Arrays2;

/**
 * @author Raj
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseInteger obj = new ReverseInteger();
		int result = -1;
		int n = 4;

		result = obj.reverse(n);
		System.out.println(result);

	}

	public int reverse(int n) {
		int rev = 0;
		while (n != 0) {
			rev = rev * 10 + (n % 10);
			n = n / 10;
		}
		return rev;
	}

}
