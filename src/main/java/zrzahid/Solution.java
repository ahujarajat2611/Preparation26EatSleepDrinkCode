package zrzahid;



/*



/*
If recursion
    if there is no operations point then return false ;
1) Find all starting points
2) Find all options
      if(recursion())
   return false


 */

// Find all starting pointss and then operations from those points
//Find how many starting points i need in my answer !!!
// Find Starting points  !!!
// Find operations  !!!
//  if(Recursion ())
// return false !!!!

// To sum up recursion and dp
// Options and operations that you need to deal with
// all options frmo that point and operations you


import BasicAlgorithms.utils.ConsoleWriter;

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    // differrnt approach
    // here for backtackaing
    // another approach couldd have been return keep a track of filled positions //
    // if we tried all positions nd still unable to find corect number for that positions
    // means we have done mistakes previously go back !!!!
    // first of all we dont know if options kya hai hamare
    // pass thats why we are iterating again and again from i=0 to length
    // better solutions would be to have another functions to provide
    // you all options to keep things clear of backtracking logic !!!!!



    // Rule

    // always look for all options and recursion from all options and get ans
    // if all options in loop ( loop beaause you dont want to manually type options
    // usually you get your options in your loop
    // and iterate in recursion and get the ans  from all possible thinsg
    //   again againd getting options in loop and putting in recursion ...
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        // check for validity
                        if(isValid(board, i, j, c)){
                         // make mode
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            // unmake move
                            board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        /// very imp point
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
/*


const int MAX = 8;

int ithRowQueen[MAX];
bool visited_col[MAX], diag_right[2*MAX+1], diag_left[2*MAX+1];

int sols = 1;

void Queens8(int r) 	// Recursion guarantee no same rows taken
{
	if(r == 8) //So we reach the end
	{
		// Print
		return;
	}

	for(int c=0; c<8; c++)			// j represent the column
	{
		if(!visited_col[c] && !diag_right[c+r] && !diag_left[MAX+c-r]) 	// Guarantee no repeated cols or diagonals
		{
			ithRowQueen[r] = c;

			visited_col[c] = diag_right[c+r] = diag_left[MAX+c-r] = 1;	// Do
			Queens8(r+1);
			visited_col[c] = diag_right[c+r] = diag_left[MAX+c-r] = 0;	//Undo
		}
	}
 */





class SudokuSolver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SudokuSolver obj = new SudokuSolver();
        int[][] a = new int[][] { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

        boolean result = false;
        int m = a.length, n = a[0].length;
        ConsoleWriter.printArray(a);
        result = obj.solveSudoku(a, m, n);
        System.out.println(result);
        ConsoleWriter.printArray(a);

    }

    // Watta a clean art it is !!!!
    public boolean solveSudoku(int[][] a, int m, int n) {
        Cell cell = getUnassignedLocation(a, m, n);
        if (cell == null) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (safeToPlace(a, cell.x, cell.y, i)) {
                a[cell.x][cell.y] = i;
                if (solveSudoku(a, m, n))
                    return true;
                a[cell.x][cell.y] = 0;
            }
        }

        return false;
    }

    private boolean safeToPlace(int[][] a, int x, int y, int val) {
        return isSafeRow(a, x, y, val) && isSafeColumn(a, x, y, val) && isSafeBlock(a, x - x % 3, y - y % 3, x, y, val);
    }

    public boolean isSafeRow(int[][] a, int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (a[x][i] == val)
                return false;
        }
        return true;
    }

    public boolean isSafeColumn(int[][] a, int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (a[i][y] == val)
                return false;
        }
        return true;
    }

    public boolean isSafeBlock(int[][] a, int startBlockX, int startBlockY, int x, int y, int val) {
        for (int i = startBlockX; i < startBlockX + 3; i++) {
            for (int j = startBlockY; j < startBlockY + 3; j++) {
                if (a[i][j] == val)
                    return false;
            }
        }
        return true;
    }

    class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public Cell getUnassignedLocation(int a[][], int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }
}








