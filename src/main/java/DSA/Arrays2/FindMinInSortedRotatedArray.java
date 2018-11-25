package DSA.Arrays2;

public class FindMinInSortedRotatedArray {

	public static void main(String[] args) {
		int a[] = { 5, 1, 2, 3, 4 };
		// int a[] = { 5,5,5,0,1,2,5};
		int result = -1, n = a.length;
		FindMinInSortedRotatedArray obj = new FindMinInSortedRotatedArray();
		result = obj.findMinInSortedRotatedArray(a, n);
		System.out.println(result);
		result= obj.findPivotMy(a,0,n-1);
		System.out.println(result);
	}

	public int findMinInSortedRotatedArray(int[] a, int n) {
		int pivot = findPivot(a, 0, n - 1);

		return pivot != -1 ? a[pivot] : -1;
	}

	int findPivot(int a[], int l, int r) {
		if (l > r)
			return -1;
		if (a[l] <= a[r])
			return l;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] > a[m + 1])
				return m + 1;
			if (a[m] > a[l]) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return -1;
	}
	int findPivotMy(int a[], int l, int r) {

		while (l < r) {
			int m = l + (r - l) / 2;

			if (a[r] > a[m]) {
				r = m;
			} else {
				l = m + 1;
			}
		}
		return l;
	}
}
