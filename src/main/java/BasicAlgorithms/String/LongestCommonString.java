package BasicAlgorithms.String;

/**
 * Created by hadoop on 14/10/17.
 */
public class LongestCommonString {
    public int longestCommonSubstring(String A, String B) {
        int [][]a = new int[A.length()+1][B.length()+1];
        for(int i=0;i<=A.length();i++){
            for(int j=0;i<=B.length();j++){
                if(i== 0 || j ==0){
                    a[i][j] = 0;
                    continue;
                }
                if(A.charAt(i-1)==B.charAt(j-1)){
                    a[i][j] = a[i-1][j-1]+1;
                }
                else {
                    a[i][j] = 0;
                }
            }
        }
        return a[A.length()][B.length()];
    }
}