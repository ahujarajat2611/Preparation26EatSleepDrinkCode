package BasicAlgorithms.Dp;/*
 * 描述：

在一个圆形操场的四周摆放着n堆石子(n<= 100)，现要将石子有次序地合并成一堆。规定每次只能选取相邻的两堆合并成新的一堆,并将新的一堆的石子数,记为该次合并的得分。

编一程序，读入石子堆数n及每堆的石子数(<=20)。选择一种合并石子的方案,使得做n－1次合并,得分的总和最小；

比如有4堆石子：4 4 5 9 则最佳合并方案如下：

4 4 5 9 score: 0
8 5 9 score: 8
13 9 score: 8 + 13 = 21
22 score: 8 + 13 + 22 = 43
 */

/*
 * 设dp[i][j]为从i到j的最小合并代价，要求的就是dp[1][n]。

可将(i,j)这个区间划分为(i , k) 和( k+1 ,j ) 两个区间合并而成，那么代价就为( i , j )这个区间的总的代价就为，dp[i][k]+dp[k+1][j]+sum[i][j]，sum[i][j]代表i到j石子的总代价。

那么dp[i][j] = min( dp[i][k]+dp[k+1][j] ) + sum[i][j]    { i<=k<j }

应为当计算i到j时，区间长度小于(i,j)的子区间必须被计算出来，那么递推顺序必须按照区间长度来枚举。

 */
/*
question starts with a counterexample, [6,4,4,6]. All of the examples given in the title are in line with the law of merger since childhood, but from this counterexample we know that the problem can not be greedy. Belongs to the dynamic class planning. First of all we can think of, to merge the n stones heap, the final step of the score must be the total number of all stones. So we think of, the final step is certainly the merger of two heaps. Through this thinking, we found that the problem of a large area was transformed into two small areas. That is, the problem of the heap interval of i ~ j is transformed into two sub-intervals of i ~ k and (k + 1) ~ j. The reason why this can be transformed because the idea that each step can only pick adjacent two heap merger. So our equation of state is there. See here to understand that there will be difficulties in the concrete realization. Note that the state transfer equation here obviously contains a for loop. In addition, this is certainly a memory search, because it is from big to small. The time complexity is O (N ^ 3).
 */

/*
Stone Game 1 & 2
There is a stone game.At the beginning of the game the player picks n piles of stones in a line.
The goal is to merge the stones in one pile observing the following rules:
At each step of the game,the player can merge two adjacent piles to a new pile.
The score is the number of stones in the new pile.
You are to determine the minimum of the total score.
Have you met this question in a real interview?
Yes
Example
For [4, 1, 1, 4], in the best solution, the total score is 18:
1. Merge second and third piles => [4, 2, 4], score +2
2. Merge the first two piles => [6, 4]，score +6
3. Merge the last two piles => [10], score +10
Other two examples:
[1, 1, 1, 1] return 8
[4, 4, 5, 9] return 43
 */
public class stoneMerge {
    //dp[i][j] = Math.min(dp[i][k] + dp[k+1][j])+sum(i, j);
	public int minScore(int[] A) {
		if (A == null || A.length < 2)
			return 0;
		int[] sum = new int[A.length];		
		for (int i = 1; i < A.length+1; i++) {
			sum[i] += A[i];
		}
		int[][] dp = new int[A.length+1][A.length+1];
		for (int len = 2; len <= A.length; len++) {
			for (int i = 1; i <= A.length - len + 1; i++) {
				int j = i + len -1;
				int w = sum[j] - sum[i-1];
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.max(dp[i][k]+dp[k+1][j]+w, dp[i][j]);
				}
			}
		}
		return dp[1][A.length];
	}
	public int stoneGame(int[] A) {
		if (A == null){
			return 0;
		}
		int l = A.length;
		if (l == 0){
			return 0;
		}
		int[][] dp = new int[l][l];
		int[] sum = new int[l];
		int currentSum = 0;
		for (int i = 0; i < l; i++){
			for (int j = i; j < l; j++){
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < l; i++){
			dp[i][i] = 0;
			sum[i] = currentSum + A[i];
			currentSum = sum[i];
		}
		return totalPick(0, l - 1, dp, sum);
	}

	// totalPick returns the minimum total pick score from publish to end
	// both inclusive
	// dp[i][j] = min(dp[i][k] + dp[k + 1][j] + sum[i][j]);
	public int totalPick(int start, int end, int[][] dp, int[] sum){
		if (dp[start][end] != Integer.MAX_VALUE){
			return dp[start][end];
		}
		int min = Integer.MAX_VALUE;
		// for a length of 2 (i.e. end = publish + 1)
		// must go into this for loop once and generate the sum
		for (int k = start; k < end; k++){
			int leftPick = totalPick(start, k, dp, sum);
			int rightPick = totalPick(k + 1, end, dp, sum);
			int finalPick = sum[end];
			if (start > 0){
				finalPick -= sum[start - 1];
			}
			min = Math.min(min, leftPick + rightPick + finalPick);
		}
		dp[start][end] = min;
		return min;
	}
	public int stoneGame2(int[] A) {
		if (A == null){
			return 0;
		}
		int l = A.length;
		if (l == 0){
			return 0;
		}
		int[][] dp = new int[2 * l][2 * l];
		int[] sum = new int[2 * l];
		int currentSum = 0;
		for (int i = 0; i <  2 * l; i++){
			for (int j = i; j < 2 * l; j++){
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < 2 * l; i++){
			dp[i][i] = 0;
			sum[i] = currentSum + A[i % l];
			currentSum = sum[i];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < l; i++){
			min = Math.min(min, totalPick(i, i + l - 1, dp, sum));
		}
		return min;
	}

	//dp[i][j] = min(dp[i][k] + dp[k + 1][j] + sum[i][j]);
	public int totalPickAgain(int start, int end, int[][] dp, int[] sum){
		if (dp[start][end] != Integer.MAX_VALUE){
			return dp[start][end];
		}
		int min = Integer.MAX_VALUE;
		for (int k = start; k < end; k++){
			int leftPick = totalPickAgain(start, k, dp, sum);
			int rightPick = totalPickAgain(k + 1, end, dp, sum);
			int finalPick = sum[end];
			if (start > 0){
				finalPick -= sum[start - 1];
			}
			min = Math.min(min, leftPick + rightPick + finalPick);
		}
		dp[start][end] = min;
		return min;
	}
}
