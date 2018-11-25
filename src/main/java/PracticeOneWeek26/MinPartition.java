package PracticeOneWeek26;

/**
 * Created by hadoop on 10/12/17.
 */
public class MinPartition {
    boolean[][] isPal ;

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] cut = new int[length];
        isPal = new boolean[length][length];

        for (int j = 0; j < length; j++) {
            cut[j] = j;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (i > 0) {
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    } else {
                        cut[j] = 0;
                    }
                }
            }//end i_for
        }//end for j_for
        for(int i=0;i<"aabaa".length();i++){
            for(int j=0;j<"aabaa".length();j++){
               // if(i<j){
                    System.out.print(isPal[i][j]+ " ");
           //     }
            }
            System.out.println();
        }
        return cut[length - 1];
    }

    public static void main(String[] args) {
        MinPartition minPartition = new MinPartition();
        minPartition.minCut("aabaa");
    }
}
