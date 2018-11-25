package DSA.String;

public class RansomNote {

	public static void main(String[] args) {

		String mag = "Prithviraj Kumar Dasari";
		String note = "raj";

		System.out.println("Ransom note: " + note);
		System.out.println("Magazine contents: " + mag);
		System.out.println("Can construct ransom note from mag contents?");
		System.out.println(ransomNote1(note, mag));
	}

	/*
	 * You need to write a ransom note by cutting letters out of the available
	 * magazines and pasting
	  * them together to form a letter. Given an arbitrary
	 * ransom note string and another 
	 * string containing all the contents of all
	 * the magazines,
	  * write a function that will return true 
	  * if the ransom note
	 * can be made from the magazines; otherwise, it will return false. Every
	 * letter found in the magazine string can only be used once in your ransom
	 * note.
	 */
	public static boolean ransomNote1(String note, String mag) {
		int[] count = new int[256]; // Assumes only ASCII characters

		for (int i = 0; i < mag.length(); i++) {
			int c = mag.charAt(i);
			count[c]++;
		}

		for (int i = 0; i < note.length(); i++) {
			int c = note.charAt(i);
			count[c]--;

			if (count[c] < 0)
				return false;
		}

		return true;
	}
}