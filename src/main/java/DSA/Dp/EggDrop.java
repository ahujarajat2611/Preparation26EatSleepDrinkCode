/**
 * 
 */
package DSA.Dp;

import BasicAlgorithms.utils.ConsoleWriter;

import java.util.Arrays;

/**
 * @author Raj
 *
 */
public class EggDrop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EggDrop obj = new EggDrop();
		// Find min no. of attemts to know whether egg break from nth floor
		// m = no.of eggs and n = number of floors
		int result = -1, m = 3, n = 36;
		result = obj.findMinAttemptsForStatusOfEggBreak(m, n);
		System.out.println(result);
		result = obj.minAttempts(3,36);
		System.out.println("result "+result);
	}

	public int findMinAttemptsForStatusOfEggBreak(int m, int n) {
		int t[][] = new int[m + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			t[0][i] = 0;
			t[1][i] = i;
		}

		for (int i = 2; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (j >= i) {
					int val = Integer.MAX_VALUE;
					for (int k = 1; k <= j; k++) {
						int a, b;
						// if egg breaks at 'kth' floor
						a = (k == 1) ? 0 : t[i - 1][k - 1];
						// if egg doens't break at kth floor
						b = (k == j) ? 0 : t[i][j - k];
						int s = 1 + Math.max(a, b);
						val = Math.min(val, s);
					}

					t[i][j] = val;
				}
				// if j is less than i
				// what would be that case !!!!
				else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		ConsoleWriter.printArray(t);
		return t[m][n];
	}

	static int counter = 0;
	static int cache[][] = new int[100][100];
	static {
		for(int i=0;i<100;i++){
			Arrays.fill(cache[i],-1);
		}

	}
	// min attempts for N eggs and K floors to get answers
	int minAttempts(int n,int k){
		if(k ==1 || k ==0){
			return k;
		}
		if(n ==1){
			return k;
		}
		if(cache[n][k]!=-1){
			return cache[n][k];
		}
		//counter++;
		//if(counter>10000){
		//	System.exit(1);
		//}
		//System.out.println("n "+n);
		//System.out.println("p "+k);
		int min = Integer.MAX_VALUE;
		for(int p = 1;p<=k;p++){

			// very imp imp lession learn
			// when you dvide such questions
			// take min but you have to consider max case here as well from both sidex
			min = Math.min(min,Math.max(1 +
			minAttempts(n-1,p-1),1+minAttempts(n,k-p)
			));
		}
		System.out.println("min "+min);
		cache[n][k] = min;
		return min;
	}
	//A Dynamic Programming based Python Program for the Egg Dropping Puzzle

		// A utility function to get maximum of two integers
		static int max(int a, int b) { return (a > b)? a: b; }

		/* Function to get minimum number of trials needed in worst
        case with n eggs and k floors */
		static int eggDropBottomUp(int n, int k)
		{
       /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
			int eggFloor[][] = new int[n+1][k+1];
			int res;
			int i, j, x;

			// We need one trial for one floor and0 trials for 0 floors
			for (i = 1; i <= n; i++)
			{
				eggFloor[i][1] = 1;
				eggFloor[i][0] = 0;
			}

			// We always need j trials for one egg and j floors.
			for (j = 1; j <= k; j++)
				eggFloor[1][j] = j;

			// Fill rest of the entries in table using optimal substructure
			// property
			for (i = 2; i <= n; i++)
			{
				for (j = 2; j <= k; j++)
				{
					eggFloor[i][j] = Integer.MAX_VALUE;
					for (x = 1; x <= j; x++)
					{
						res = 1 + max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
						if (res < eggFloor[i][j])
							eggFloor[i][j] = res;
					}
				}
			}

			// eggFloor[n][k] holds the result
			return eggFloor[n][k];
	}
}
