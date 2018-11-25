package DSA.Dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * http://algorithms.tutorialhorizon.com/print-all-paths-from-top-left-to-bottom-right-in-two-dimensional-array/
 */
public class MatrixPrintAllPathsToReachBottomRightFromTopLeft {

	public static void main(String[] args) {
		MatrixPrintAllPathsToReachBottomRightFromTopLeft obj = new MatrixPrintAllPathsToReachBottomRightFromTopLeft();
		int a[][] = {{1, 2, 3}, {4, 5, 6}};
		int m = a.length, n = a[0].length;
		obj.printAllPaths(a, m - 1, n - 1, "");
		List<String> path = new ArrayList<String>();
		List<List<String>> result = new LinkedList<>();
		obj.printAllPathsBack(a,0,0,result,path);
	}

	public void printAllPaths(int[][] a, int i, int j, String path) {
		if (i < 0 || j < 0)
			return;

		if (i == 0) {
			for (int k = j; k >= 0; k--)
				path = a[0][k] + "-" + path;
			System.out.println(path);
			return;
		}

		if (j == 0) {
			for (int k = i; k >= 0; k--)
				path = a[k][0] + "-" + path;
			System.out.println(path);
			return;
		}
		path = a[i][j] + "-" + path;
		printAllPaths(a, i, j - 1, path);
		printAllPaths(a, i - 1, j, path);
		printAllPaths(a, i - 1, j - 1, path);
	}

	public void printAllPathsBack(int[][] a, int i, int j, List<List<String>> result, List<String> path) {

		if(i>=a.length || j>=a[0].length){
			return;
		}

		if(i == a.length-1 && j ==a[0].length-1){
			path.add(""+a[i][j]);
			System.out.println(path);
			path.remove(path.size()-1);
			return;
		}

		path.add(""+a[i][j]);
		printAllPathsBack(a,i+1,j,result,path);
		printAllPathsBack(a,i,j+1,result,path);
		printAllPathsBack(a,i+1,j+1,result,path);
		path.remove(path.size()-1);

	}
}