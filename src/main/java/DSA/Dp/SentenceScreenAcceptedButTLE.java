package DSA.Dp;

/**
 * Created by hadoop on 18/2/18.
 */
public class SentenceScreenAcceptedButTLE {
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
}
