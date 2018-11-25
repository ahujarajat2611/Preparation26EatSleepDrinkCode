package BasicAlgorithms.Graph;

import static OldAttemptLearning.dp.Keypad.isValid;

/**
 * Created by hadoop on 7/1/18.
 */
public class SurroundedRegions {
    public class Solution {
        public void solve(char[][] board) {
            int m = board.length;
            if (m <= 2){
                return;
            }
            int n = board[0].length;
            if (n <= 2){
                return;
            }
            for (int i = 0; i < m; i++){
                if (i != 0 && i != m - 1){
                    dfs(board, i, 0);
                    dfs(board, i, n - 1);
                } else {
                    for (int j = 0; j < n; j++){
                        dfs(board, i, j);
                    }
                }
            }
            boolean [][]visited = new boolean[board.length][board[0].length];

            for (int i=0;i<m;i++){
                if(board[i][0] == 'O') {
                    dfsMine(board, i, 0, visited);
                }
                if(board[i][n-1] == 'O') {
                    dfsMine(board, i, n - 1, visited);
                }
            }

            for(int i=0;i<n;i++){
                if(board[0][i] == 'O') {
                    dfsMine(board, 0, i, visited);
                }
                if(board[m-1][i] == 'O') {
                    dfsMine(board, m - 1, i, visited);
                }
            }

            for(int i=0;i<m;i++){
                for(int j =0;j<n;j++){
                    if(visited[i][j]){
                        board[i][j] = 'O';
                    }
                    else{
                        board[i][j] = 'X';
                    }
                }
            }

            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '#'){
                        board[i][j] = 'O';
                    }
                }
            }
        }
        int []dx = {1,0,-1,0};
        int []dy = {0,1,0,-1};
        private void dfsMine(char[][] board, int i, int j,boolean [][]visited ) {
            visited[i][j] = true;
            for(int k =0;k<dx.length;k++){
                int newx = i + dx[k];
                int newy = i + dy[k];
                if(isValidMine(newx,newy,board.length,board[0].length) && !visited[newx][newy] && board[newx][newy] == 'O'){
                    dfsMine(board,newx,newy,visited);
                }
            }
        }
        boolean isValidMine(int x, int y,int m, int n){
            if(x >=0 && x<m && y>=0 && y<n ){
                return true;
            }
            return false;
        }

        public void dfs(char[][] board, int i, int j){
            if (board[i][j] == 'O'){
                board[i][j] = '#';
                if (i - 1 >= 1){
                    dfs(board, i - 1, j);
                }
                if (i + 1 < board.length - 1){
                    dfs(board, i + 1, j);
                }
                if (j - 1 >= 1){
                    dfs(board, i, j - 1);
                }
                if (j + 1 < board[0].length - 1){
                    dfs(board, i, j + 1);
                }
            }
        }
    }
}
