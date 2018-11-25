/**
 *
 */
package DSA.Dp;

/**
 * @author Raj
 * 
 *         Given a rows x cols screen and a sentence represented by a list of
 *         words, find how many times the given sentence can be fitted on the
 *         screen. Note: A word cannot be split into two lines. The order of
 *         words in the sentence must remain unchanged. Two consecutive words in
 *         a line must be separated by a single space. Total words in the
 *         sentence won't exceed 100. Length of each word won't exceed 10. 1 ≤
 *         rows, cols ≤ 20,000.
 */
public class SentenceScreenFitting {

	// Time : O(rows * Lw), Lw = max Length of the word
	// https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int start = 0, l = s.length();
		for (int i = 0; i < rows; i++) {
			start += cols;
			start = start + cols-1;
			//publish + 1 is space then perfect ending
			while (start > 0 && s.charAt((start) % l) != ' ') {
				start--;
			}
			start++;
		}

		return start / s.length();
	}

	// Time : O(rows * Lw), Lw = max Length of the word
	// https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution
	public static int wordsTyping2(String[] sentence, int rows, int cols) {
		String s = String.join(" ", sentence) + " ";
		int start = 0, l = s.length();
		for (int i = 0; i < rows; i++) {
			start += cols;
			if (s.charAt(start % l) == ' ') {
				start++;
			} else {
				while (start > 0 && s.charAt((start - 1) % l) != ' ') {
					start--;
				}
			}
		}

		return start / s.length();
	}

	// Time : O(r*c), Space : O(1)
	public static int sentenceScreenFiltering(String[] sentence, int rows, int cols) {
		int i = 0, count = 0;
		for (int r = 0; r < rows; r++) {
			// FOr each row we init all columns and then try reducing columns ..// kinda two pointer approoach again
			// think carefully //
			int remainingCols = cols;
			while (i<sentence.length && remainingCols >= sentence[i].length()) {
				remainingCols = remainingCols - sentence[i].length() - 1;
			}
			if(i == sentence.length){
				i = 0;
				count++;
			}
		}
		return count;
	}
	public static int wordsTypingAgain(String[] sentence, int rows, int cols) {

		//		int i = 0, count = 0;
//		int savedremainingcols = -1;
//		int remainingCols;
//		for (int r = 0; r < rows; r++) {
//			// FOr each row we init all columns and then try reducing columns ..// kinda two pointer approoach again
//			// think carefully //
//			if(savedremainingcols == -1){
//				remainingCols = cols;
//			}
//			else{
//				remainingCols = savedremainingcols;
//				savedremainingcols = -1;
//			}
//			while (i<sentence.length && remainingCols >= sentence[i].length()) {
//				remainingCols = remainingCols - sentence[i].length() - 1;
//				i++;
//			}
//			if(i == sentence.length){
//				i = 0;
//				count++;
//				savedremainingcols = remainingCols;
//			}
//		}
//		return count;
		int i = 0, count = 0;
		for (int r = 0; r < rows; r++) {
			int remainingCols = cols;

			while (remainingCols >= sentence[i].length()) {
				System.out.println("row"+r);
				System.out.println("rem col "+remainingCols);
				System.out.println(sentence[i]);
				System.out.println("===");
				remainingCols = remainingCols - sentence[i].length();
				if(remainingCols != 0){
					remainingCols = remainingCols -1;
				}
			//	System.out.println("i"+i);
				if (++i == sentence.length) {
					i = 0;
			//		System.out.println("counting "+i);
					count++;
			//		System.out.println("coun"+count);
				}
			}

		}

			return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String sentence[] = { "a", "bcd", "e" };
//		int res = -1;
//		int rows = 3, cols = 6;
//		res = sentenceScreenFiltering(sentence, rows, cols);
//		System.out.println(res);
//		res = wordsTypingAgain(sentence, rows, cols);
//		System.out.println(res);
//
//		String s2[] = { "I", "had", "apple", "pie" };
//		res = sentenceScreenFiltering(s2, 4, 5);
//		System.out.println(res);
//		res = wordsTypingAgain(s2, 4, 5);
//		System.out.println(res);
		String s3[] = { "abc", "de", "f" };
	//	int res = wordsTyping(s3, 4, 6);
//		System.out.println(res);
		int res = wordsTypingAgain(s3, 4, 6);
		System.out.println(res);
		String s4[]={"a","b","e"};
		int r = 20000;
		int c = 20000;
		 res = wordsTypingAgain(s4, 20000, 20000);
		System.out.println(res);

	}

}
