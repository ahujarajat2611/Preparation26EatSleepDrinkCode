package BasicAlgorithms.Dp;

import java.util.Stack;

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		// if matrix[i][j] == '1', dp[j] = dp[j]+1; else dp[j] = 0;
		int[] dp = new int[matrix[0].length];
		int max = 0;
		int[] maxIndices = new int[4];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					dp[j] = dp[j] + 1;
				} else {
					dp[j] = 0;
				}
			}
			int[] indices = getMax(dp);
			if (indices[0] * indices[1] > max) {
				maxIndices[0] = indices[0];
				maxIndices[1] = indices[1];
				maxIndices[2] = indices[2];
				maxIndices[3] = i;
				max = maxIndices[0] * maxIndices[1];
			}
		}
		int i = maxIndices[3];
		int j = maxIndices[2];
		int h = maxIndices[1];
		int w = maxIndices[0];
		System.out.println("Max area is " + max);
		System.out.println("Indices of the corners are "
				+ printPoint(i - h + 1, j - w + 1) + printPoint(i - h + 1, j)
				+ printPoint(i, j - w + 1) + printPoint(i, j));
		System.out.println();
		return max;
	}

	private int[] getMax(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int[] res = new int[3];
		for (int i = 0; i <= height.length; i++) {
			int curHeight = i == height.length ? -1 : height[i];
			while (!stack.isEmpty() && curHeight < height[stack.peek()]) {
				int index = stack.pop();
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				int h = height[index];
				if (max < w * h) {
					res[0] = w;
					res[1] = h;
					res[2] = i - 1;
					max = w * h;
				}
			}
			stack.push(i);
		}
		return res;
	}

	private String printPoint(int i, int j) {
		return "(" + i + "," + j + ")";
	}

	public static void main(String[] args) {
		int numTestCases = Integer.parseInt(args[0]);
		int start = 1;
		while (numTestCases-- > 0) {
			int rowNum = Integer.parseInt(args[start++]);
			int colNum = Integer.parseInt(args[start++]);
			char[][] matrix = new char[rowNum][colNum];
			char[] matrixArr = args[start++].toCharArray();
			int k = 0;
			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {
					matrix[i][j] = matrixArr[k++];
				}
			}
			maximalRectangle obj = new maximalRectangle();
			obj.maximalRectangle(matrix);
		}
	}
}
