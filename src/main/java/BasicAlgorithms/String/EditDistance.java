package BasicAlgorithms.String;

/**
 * Created by hadoop on 15/10/17.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int [][]dp = new int[word1.length()+1][word2.length()+1];

        dp[0][0] = 0;
        for(int i=0;i<=word1.length();i++){
            for(int j=0;j<=word2.length();j++){
                if(i==0 ){
                    dp[i][j] = j;
                }
                else if(j==0){
                    dp[i][j] = i;
                }
                else if(i==0 && j==0){
                    dp[0][0] = 0;
                }
                else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else {
                        System.out.println();
                        int replace = 1+dp[i-1][j-1];
                        int delete = 1 + dp[i][j-1]; // delete in i
                        int add = 1 + dp[i-1][j]; // delete in j
                        System.out.println(replace);
                        System.out.println(delete);
                        System.out.println(add);
                        dp[i][j]  = Math.min(Math.min(replace,delete),add);
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
    public static void main(String args[]){
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minDistance("a","b"));
    }
}