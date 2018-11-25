package zrzahid;

/**
 * Created by hadoop on 7/9/17.
 */
import java.text.DecimalFormat;

public class KnightTour {

    int[][] solution;
    //int path = 0;

    public KnightTour(int N) {
        solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = -1;
            }
        }
    }

    // starting postion is given
    // we need to try out all otopns from startinng positions !!!
    public void solve() {
        solution[0][0] = 0;
        if (findPath(0, 0, 1, solution.length)) {
            print();
        } else {
            System.out.println("NO PATH FOUND");
        }
    }

    public boolean findPath(int row, int column, int index, int N) {
        // check if current is not used already
        // mark the current cell is as used
        //solution[row][column] = path++;
        // if (column == 50) {
        if (index == N * N ) {
            // if we are here means we have solved the problem
            return true;
        }
        //System.out.println("column"+column);
        for (int k = 0; k < N; k++)
        {

            int next_x = row + xMove[k];
            int next_y = column + yMove[k];
            if (canMove(next_x, next_y,N))
            {
                solution[next_x][next_y] = index;
                if (findPath(next_x, next_y, index + 1,N))
                    return true;
                solution[next_x][next_y] = -1;
            }
        }
        // like cleanup work afterr loop
        // after trying out all options you have to return false or number of paths
        // what ever question demands !!
        return false;
        //System.out.println("path previous"+path);
        //if(path>100) System.exit(1);
        // try to solve the rest of the problem recursively

        // go down and right
        //System.out.println("row"+row);
        //System.out.println("column"+column);
//        if (canMove(row + 2, column + 1, N)) {
//            solution[row+2][column+1] = column;
//            boolean result = findPath(row + 2, column + 1, column + 1, N);
//            if(result) return true;
//            //path--;
//            solution[row+2][column+1]=-1;
//        }
//        if (canMove(row + 2, column - 1, N)) {
//            solution[row+2][column-1] = column;
//            boolean result = findPath(row + 2, column - 1, column + 1, N);
//            if(result) return true;
//            //path--;
//            solution[row+2][column-1]=-1;
//        }
//        if (canMove(row - 2, column + 1, N)) {
//            solution[row-2][column+1] = column;
//            boolean result = findPath(row - 2, column + 1, column + 1, N);
//            if(result) return true;
//            //path--;
//            solution[row-2][column+1]=-1;
//        }
//        if (canMove(row - 2, column - 1, N)) {
//            solution[row-2][column-1] = column;
//            boolean result = findPath(row - 2, column - 1, column + 1, N);
//            if(result) return true;
//            //path--;
//            solution[row-2][column-1]=-1;
//        }
//        if (canMove(row + 1, column + 2, N)) {
//            solution[row+1][column+2] = column;
//            boolean result = findPath(row + 1, column + 2, column + 1, N);
//            if(result) return true;
//           // path--;
//            solution[row+1][column+2]=-1;
//        }
//        if (canMove(row + 1, column - 2, N)) {
//            solution[row+1][column-2] = column;
//            boolean result = findPath(row + 1, column -2, column + 1, N);
//            if(result) return true;
//            //path--;
//            solution[row+1][column-2]=-1;
//        }
//        if (canMove(row - 1, column + 2, N)) {
//            solution[row-1][column+2] = column;
//            boolean result = findPath(row - 1, column + 2, column + 1, N);
//            if(result) return true;
//            //path--;
//            solution[row-1][column+2]=-1;
//        }
//        if (canMove(row - 1, column - 2, N)) {
//            solution[row-1][column-2] = column;
//            boolean result = findPath(row - 1, column - 2, column + 1, N);
//            if(result) return true;
//            //path--;
//            solution[row-1][column-2]=-1;
//        }
//        //System.out.println("path"+path);
//       // System.out.println("not found path for "+row);
//        //System.out.println("column"+column);
//        // go right and down
////        if (canMove(row + 1, column + 2, N)
////                && findPath(row + 1, column + 2, column + 1, N)) {
////            return true;
////        }
////        // go right and up
////        if (canMove(row - 1, column + 2, N)
////                && findPath(row - 1, column + 2, column + 1, N)) {
////            return true;
////        }
////        // go up and right
////        if (canMove(row - 2, column + 1, N)
////                && findPath(row - 2, column + 1, column + 1, N)) {
////            return true;
////        }
////        // go up and left
////        if (canMove(row - 2, column - 1, N)
////                && findPath(row - 2, column - 1, column + 1, N)) {
////            return true;
////        }
////        // go left and up
////        if (canMove(row - 1, column - 2, N)
////                && findPath(row - 1, column - 2, column + 1, N)) {
////            return true;
////        }
////        // go left and down
////        if (canMove(row + 1, column - 2, N)
////                && findPath(row + 1, column - 2, column + 1, N)) {
////            return true;
////        }
////        // go down and left
////        if (canMove(row + 2, column - 1, N)
////                && findPath(row + 2, column - 1, column + 1, N)) {
////            return true;
////        }
//        // if we are here means nothing has worked , backtrack
//        //solution[row][column] = 0;
//        //path--;
//        return false;

    }

    public boolean canMove(int row, int col, int N) {
        if (row >= 0 && col >= 0 && row < N && col < N && solution[row][col] == -1) {
            return true;
        }
        return false;
    }

    public void print() {
        DecimalFormat twodigits = new DecimalFormat("00");
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                System.out.print("   " + twodigits.format(solution[i][j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int N = 8;
        KnightTour i = new KnightTour(N);
        i.solve();
    }
    int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

}