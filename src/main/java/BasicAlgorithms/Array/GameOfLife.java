package BasicAlgorithms.Array;

/**
 * Created by hadoop on 11/10/17.
 */
public class GameOfLife {
    public static void main(String args[]){

    }
    public void gameOfLife(int [][]board){
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int []xdir = {1,-1,-1,1,0,-1,1,0};
        int []ydir = {1,-1,1,-1,-1,0,0,1};
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live =0;
                for(int k=0;k<xdir.length;k++){
                    int newi = i+xdir[k];
                    int newj = j+ydir[k];
                    if(newi>=0 && newi <m && newj>=0 && newj<n) {
                        // 2 value denotes there is life but it will be dead in new generation
                        // since it has either vey less or quie high value
                        if (board[newi][newj] == 1 || board[newi][newj] == 2) {
                            live++;
                        }
                    }
                }
                if(board[i][j] == 1 && (live<2 || live>=4)){
                    // we have to choose different values here so that we can determine as how many
                    // lives were present in original state
                    board[i][j] = 2;
                }
                if(board[i][j] == 0 && live == 3){
                    // we need to see as how many dead state initially
                    board[i][j] = 3;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]%=2;
            }
        }
    }
}
