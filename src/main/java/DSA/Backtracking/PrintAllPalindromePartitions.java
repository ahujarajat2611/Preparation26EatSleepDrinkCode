package DSA.Backtracking;
/**							
* 							
*/							
							
import java.util.ArrayList;							
import java.util.HashSet;							
import java.util.List;							
import java.util.Set;							
							
/**							
* @author Raj							
* 							
* 							
*         http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/							
* 							
*         Given a string s, partition s such that every substring of the							
*         partition is a palindrome.							
* 							
*         For example, given s = "aab", Return							
* 							
*         [ ["aa","b"], ["a","a","b"] ]							
* 							
*/
// NOt the solution we are expecting in this case ...
public class PrintAllPalindromePartitions {							
							
	private List<String> printAllPalindromePartitions(String s) {						
							
		List<String> result = new ArrayList<String>();					
							
		if (s == null)					
			return result;				
							
		if (s.length() <= 1) {					
			result.add(s);				
			return result;				
		}					
							
		int length = s.length();					
							
		int[][] table = new int[length][length];					
							
		// l is length, i is index of left boundary, j is index of right					
		// boundary					
		for (int l = 1; l <= length; l++) {					
			for (int i = 0; i <= length - l; i++) {				
				int j = i + l - 1;			
				if (s.charAt(i) == s.charAt(j)) {			
					if (l == 1 || l == 2) {		
						table[i][j] = 1;	
					} else {		
						table[i][j] = table[i + 1][j - 1];	
					}		
					if (table[i][j] == 1) {		
						result.add(s.substring(i, j + 1));	
					}		
				} else {			
					table[i][j] = 0;		
				}			
			}				
		}					
							
		return result;					
	}						
							
	public static void main(String[] args) {						
		String str = "abcbb";					
							
		List<String> result = null;					
		PrintAllPalindromePartitions obj = new PrintAllPalindromePartitions();					
		result = obj.printAllPalindromePartitions(str);					
		System.out.println(result);					
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

		if (s == null || s.length() == 0) {
			return result;
		}

		ArrayList<String> partition = new ArrayList<String>();//track each possible partition
		addPalindrome(s, 0, partition, result);

		return result;
	}

	private void addPalindrome(String s, int start, ArrayList<String> partition,
							   ArrayList<ArrayList<String>> result) {
		//stop condition
		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
				partition.add(str);
				addPalindrome(s, i, partition, result);
				partition.remove(partition.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}
							
}	