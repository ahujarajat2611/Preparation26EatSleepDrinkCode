package BasicAlgorithms.Trie;

/**
 * Created by hadoop on 22/10/17.
 */
public class FindWord {
    int xdir[]={1,0,-1,0};
    int ydir[]={0,1,0,-1};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        if(m == 0 || n ==0){
            return false;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean [][] visited = new boolean[board.length][board[0].length];
                    visited[i][j] = true;
                    if(dfsApply(board,i,j,0,visited,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfsApply(char[][] board, int x, int y, int d, boolean[][] visited,String word) {
        if(d == word.length()-1){
            return true;
        }
        for(int k=0;k<4;k++){
            int newx = x+xdir[k];
            int newy = y+ydir[k];
            System.out.println("newx"+newx);
            System.out.println("newy"+newy);
            if(isValid(newx,newy)) {
                System.out.println(visited[newx][newy]);
            }
            if(isValid(newx,newy) && !visited[newx][newy] && board[newx][newy] == word.charAt(d+1)){
                visited[newx][newy] = true;
                if(dfsApply(board,newx,newy,d+1,visited,word) == true){
                    return true;
                }
                visited[newx][newy] = false;
            }
        }
        return false;
    }

    private boolean isValid(int newx, int newy) {
        if (newx >= 0 && newx < m && newy >= 0 && newy < n ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char [][]board = {{'A','B','C','E'},
                        {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";
        char [][]board1 = {{'a','a'}};
        String word1 ="aaa";
        FindWord findWord = new FindWord();
        System.out.println(findWord.exist(board1,word1));
    }
}
