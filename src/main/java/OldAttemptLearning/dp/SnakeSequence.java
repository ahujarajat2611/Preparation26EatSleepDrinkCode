package OldAttemptLearning.dp;

import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 11/8/17.
 */
public class SnakeSequence {
    public static void main(String[] args) {
        int [][] grid = {{7, 5, 2, 3, 1},
                {3, 4, 1, 4, 4},
                {1,5,6,7,8},
                {3,4,5,8,9},
                {3,2,2,7,6}
        };
        int [][]Length = new int[grid.length+1][grid[0].length+1];
      //  Arrays.fill(Length,0);

        List<Point> points = getMaxSnakePath(grid,Length);
    }

    private static List<Point> getMaxSnakePath(int[][] grid, int[][] length) {

        length[0][0] = 1;
        int maxpath = 1;
        for( int k=1;k<grid.length;k++){
            if(Math.abs(grid[0][k-1] -grid[0][k])<=1) {
                length[0][k] = Math.max(length[0][k], length[0][k - 1] + 1);
            }
            else {
                length[0][k] = 1;
            }
        }
        for( int k = 1;k<grid.length;k++ ){
            if(Math.abs(grid[k-1][0]=grid[k][0])<=1){
                length[k][0] = Math.max(length[k][0],length[k-1][0]+1);
            }
            else{
                length[k][0] = 1;
            }
        }
        int max = 1;
        int maxi=0;
        int maxj=0;
        for( int i=1;i<grid.length;i++){
            for ( int j=1;j<grid.length;j++){
                if(Math.abs(grid[i-1][j]-grid[i][j])<=1){
                    length[i][j] = Math.max(length[i][j],length[i-1][j]+1);
                }
                else if (Math.abs(grid[i][j-1]-grid[i][j])<=1){
                    length[i][j] = Math.max(length[i][j],length[i][j-1]+1);
                }
                else{
                    length[i][j] = 1;
                }
                if(length[i][j]>max){
                    max = length[i][j];
                    maxi=i;
                    maxj = j;
                }

            }
        }
        int i= maxi;
        int j = maxj;
        Stack stack = new Stack();
        while (length[i][j]!=1){
            if(length[i][j] == length[i-1][j]+1 && Math.abs(grid[i][j]-grid[i-1][j])<=1){
                stack.push(new Point(i,j));
                i = i-1;
            }
            else if (length[i][j] == length[i][j-1]+1 && Math.abs(grid[i][j]-grid[i][j-1])<=1){
                stack.push(new Point(i,j));
                j = j-1;
            }
        }
        stack.push(new Point(i,j));
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println(stack.size());
        System.out.println("Max vlaue "+max);
        System.out.println("max i "+maxi);
        System.out.println("max j"+maxj);
        return null;
    }

    public static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x= x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
