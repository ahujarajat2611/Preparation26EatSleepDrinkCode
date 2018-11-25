/**
 * 
 */
package DSA.Arrays2;

/**
 * @author Raj
 *
 */
public class FindMaxInBitonic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {1, 3, 50, 10, 9, 7, 6};
		int n = a.length, result = -1;
		FindMaxInBitonic obj = new FindMaxInBitonic();
		// Time : O(n)
		result = obj.findMaxInBitonic(a, n);
		System.out.println(result);

		// Time : O(logn)
		result = obj.findMaxInBitonicUsingBinarySearch(a, 0, n - 1);
		System.out.println(result);

		// Time : O(logn)
		result = obj.findMaxInBitonicUsingBinarySearch2(a, 0, n - 1);
		System.out.println(result);

		result = obj.findMaxInBitonicUsingBinarySearchMy(a,0,n-1);
		System.out.println("my "+result);


	}

	public int findMaxInBitonicUsingBinarySearch(int[] a, int l, int r) {
		int mid;

		while (l <= r) {
			// if there is only one element
			if (l == r) {
				return a[l];
			}
			// if there are only two elements
			if (l + 1 == r) {
				return a[l] > a[r] ? a[l] : a[r];
			}

			mid = l + (r - l) / 2;
			if (a[mid] > a[mid + 1] && a[mid] > a[mid - 1]) {
				return a[mid];
			} else if (a[mid] > a[mid + 1]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public int findMaxInBitonicUsingBinarySearch2(int[] a, int l, int r) {
		int mid;
		int n = r - l + 1;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if ((mid == n - 1 || a[mid] > a[mid + 1]) && (mid == 0 || a[mid] > a[mid - 1])) {
				return a[mid];
			}
			if (a[mid] > a[mid - 1] && a[mid + 1] > a[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

	public int findMaxInBitonic(int[] a, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}

	public int findMaxInBitonicUsingBinarySearchMy(int[] a, int l, int r) {

		while (l < r) {
			int mid = l + (r - l) / 2;
			if (a[mid] > a[mid+1]) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return a[l];
	}
}
