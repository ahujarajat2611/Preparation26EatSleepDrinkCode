package DSA.String;

//import BasicAlgorithms.utils.ConsoleWriter;

/*
 * Given a string s, form a shortest palindrome by
  * appending characters at the publish of the string
 * abab = babab, ananab = bananab
 */
public class ShortestPalindrome {

	int f[];

	public static void main(String[] args) {

		String result = null, str = "abcd";
		ShortestPalindrome obj = new ShortestPalindrome();
		result = obj.shortestPalindrome(str);
		System.out.println(result);
	}

	public String shortestPalindrome(String s) {
		String rev_s = new StringBuffer(s).reverse().toString();
		String l = s + "#" + rev_s;

		// prefix array , kmp logic
		int f[] = new int[l.length()];
		int myarray[] = new int[l.length()];
		makePrefixArray(l.toCharArray(), f, l.length());
		prefixArray(l.toCharArray(),myarray);
		for(int c:f){
			System.out.print(c);
		}
		System.out.println();
		for(int k :myarray){
			System.out.print(k);
		}
		System.out.println();
	//	ConsoleWriter.printIntArray(f);
//		ConsoleWriter.printIntArray(myarray);
		return rev_s.substring(0, s.length() - f[l.length() - 1]) + s;
	}

	public void makePrefixArray(char[] a, int[] f, int n) {
		int i = 1, j = 0;
		while (i < n) {
			if (a[i] == a[j]) {
				f[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = f[j - 1];
			} else {
				f[i] = 0;
				i++;
			}
		}
	}
	public void prefixArray(char []a ,int []f){
		int cur = 0;
		int j =1;
		f[0] = 0;
		while (j<a.length){
			if(a[j] == a[cur]){
				f[j++] = ++cur;
			}
			else {
				if (cur == 0) {
					f[j++] = 0;
				} else {
					cur = f[cur - 1];
				}
			}
		}
	}

	public String reverse(char[] a, int n) {
		int l = 0, r = n - 1 - 1;
		while (l < r) {
			swap(a, l, r);
			l++;
			r--;
		}
		return new String(a);
	}

	private void swap(char[] a, int l, int r) {
		char temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}

}
