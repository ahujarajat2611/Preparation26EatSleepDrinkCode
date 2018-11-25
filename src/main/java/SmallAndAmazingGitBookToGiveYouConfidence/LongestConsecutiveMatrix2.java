package SmallAndAmazingGitBookToGiveYouConfidence;

/**
 * Created by hadoop on 22/9/17.
 */
public class LongestConsecutiveMatrix2 {
    public static int DIRS[][]={{1,0},{-1,0},{0,1},{0,-1}};
    private int [][]cache;
    int maxlenth = Integer.MIN_VALUE;
    public int longestIncreasingContinuous(int [][]matrix){
        boolean [][]visited = new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                visited[i][j] = true;
                maxlenth = Math.max(maxlenth,dfs(i,j,visited,matrix));
                visited[i][j] = false;
            }
        }
        return maxlenth;
    }

    private int dfs(int i, int j, boolean[][] visited,int [][]matrix) {

        int maxlength = 1;

        for (int k = 0; k < DIRS.length; k++) {
            if(isValid(i+DIRS[k][0],j+DIRS[k][1],matrix,matrix[i][j])){
                    visited[i+DIRS[k][0]][j+DIRS[k][1]] = true;
                    maxlength = Math.max(maxlength,1 + dfs(i+DIRS[k][0],j+DIRS[k][1],visited,matrix));
                    visited[i+DIRS[k][0]][j+DIRS[k][1]] = false;
                }
        }
        return maxlength;

    }

    private boolean isValid(int row, int column, int [][]matrix,int matrixvalue) {
        if(row<0 || column<0 || row>=matrix.length ||column>=matrix[0].length || matrix[row][column] <matrixvalue){
            return false;
        }
        return true;
    }
    public static void main(String []args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                {16, 17, 24, 23, 6},
                {15, 18, 25, 22, 7},
                {14, 19, 20, 21, 8},
                {13, 12, 11, 10, 9}};
        LongestConsecutiveMatrix2  longestConsecutiveMatrix2 = new LongestConsecutiveMatrix2();
        System.out.println(longestConsecutiveMatrix2.longestIncreasingContinuous(matrix));
        System.out.println("LOngest");
    }
}
