package BasicAlgorithms.Dp;

/**
 * Created by hadoop on 7/1/18.
 */
public class JikaiDp {
}

/*
Description:
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

Hint:
Use a two-dimensional dp array to record the edit distance. dp[i][j] means edit distance of word1[0...i] and word2[0...j].

Python:
class Solution:
    # @param {string} word1
    # @param {string} word2
    # @return {integer}
    def minDistance(self, word1, word2):
        m = len(word1)
        n = len(word2)

        dp = [[0] * (n + 1) for x in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = i

        for j in range(n + 1):
            dp[0][j] = j

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1

        return dp[m][n]
 */






/*

Question:
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

Hints:
Dynamic Programming
dp[i][j] = max(1, min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])

Python:
class Solution:
    # @param {integer[][]} dungeon
    # @return {integer}
    def calculateMinimumHP(self, dungeon):
        m = len(dungeon)
        n = len(dungeon[0])


/// WATTTAAAA SOLUTION
        dp = [[-1] * n for x in range(m)]
        for i in reversed(range(m)):
            for j in reversed(range(n)):
                if i == m - 1 and j == n - 1:
                    dp[i][j] = max(1, 1 - dungeon[i][j])
                elif i == m - 1:
                    dp[i][j] = max(1, dp[i][j + 1] - dungeon[i][j])
                elif j == n - 1:
                    dp[i][j] = max(1, dp[i + 1][j] - dungeon[i][j])
                else:
                    dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j])

        return dp[0][0]
Complexity:
O(mn) time
O(mn) space
 */

/*
Description:
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.

Hints:
Dynamic Programming
For index i, if s[i] != 0, dp[i] += dp[i - 1]; if int(s[i - 1] + s[i]) is between 10 and 26, dp[i] += dp[i - 2].

Python:
class Solution:
    # @param {string} s
    # @return {integer}
    def numDecodings(self, s):
        n = len(s)

        if not s and n <= 0:
            return 0

        dp = [0] * (n + 1)
        dp[0] = 1
        if s[0] == '0':
            dp[1] = 0
        else:
            dp[1] = 1

        for i in range(2, n + 1):
            one = int(s[i - 1])
            two = int(s[i - 2] + s[i - 1])

            if two >= 10 and two <= 26:
                dp[i] += dp[i - 2]

            if one != 0:
                dp[i] += dp[i - 1]

        return dp[n]
 */


/*


Description:
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

Hints:
Dynamic Programming
Given an example, n = 4
 Picture
We only draw BST with root of 1 as shown below. We find the right child of 1 has 5 unique sub-BST (equals dp[3]), left child of 1 is empty(equals dp[0]). Then we can find dp[4] = dp[0]*dp[3]+dp[1]*dp[2]+dp[2]*dp[1]+dp[3]*dp[0].

Python:
class Solution:
    # @param {integer} n
    # @return {integer}
    def numTrees(self, n):
        if n <= 0:
            return 0

        dp = [0] * (n + 1)
        dp[0] = 1

        for i in range(1, n + 1):
            for j in range(i):
                dp[i] += dp[j] * dp[i - j - 1]

        return dp[n]
 */

/*


Method 2: Dynamic Programming
We could use an array to record maximum subarray at each index.

Python:
class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maxSubArray(self, nums):
        n = len(nums)
        if not nums or n == 0:
            return 0

        dp = [0] * n
        dp[0] = nums[0]
        maxSum = nums[0]

        for i in range(1, n):
            dp[i] = max(dp[i - 1] + nums[i], nums[i])
            maxSum = max(maxSum, dp[i])
        return maxSum
 */

/*


Description:
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Hints:
Dynamic Programming
We can use an two-dimensional array to record the minimum sum at each position of grid, finally return the last element as output.

Python:
class Solution:
    # @param {integer[][]} grid
    # @return {integer}
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])

        dp = [[0] * n for x in range(m)]

        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    dp[i][j] = grid[0][0]
                elif i == 0:
                    dp[i][j] = dp[i][j - 1] + grid[i][j]
                elif j == 0:
                    dp[i][j] = dp[i - 1][j] + grid[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        return dp[-1][-1]
Complexity:
O(n^2) time
O(n^2) space
 */


/*


This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.

For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as ‘D’ and right as ‘R’, following is one of the path :-

D R R R D R R R

We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-

Total permutations = (m+n)! / (m! * n!)

Following is my code doing the same :-

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        m--;
        n--;
        if(m < n) {              // Swap, so that m is the bigger number
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++){       // Instead of taking factorial, keep on multiply & divide
            res *= i;
            res /= j;
        }

        return (int)res;
    }
}


 public class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }
}
The assumptions are

When (n==0||m==0) the function always returns 1 since the robot
can’t go left or up.
For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
Therefore I populated the edges with 1 first and use DP to get the full 2-D array.

Please give any suggestions on improving the code.
 */

/*
Description:
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Hints:
Dynamic Programming
dp[i][j] tracks the number of subsequence of T[:j] in S[:i]
1. S[i-1] == T[j-1]: dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
Including the number of subsequence of T[:j-1] in S[:i-1] since S[i]==T[j] and number of subsequence of T[:j] in S[:i-1]
2. S[i-1] != T[j-1]: dp[i][j] = dp[i-1][j]


Python:
 class Solution:
    # @param {string} s
    # @param {string} t
    # @return {integer}
    def numDistinct(self, s, t):
        m = len(s)
        n = len(t)

        dp = [[0] * (n + 1) for x in range(m + 1)]

        for i in range(m + 1):
            for j in range(n + 1):
                if j == 0:
                    dp[i][j] = 1
                elif i > 0 and j > 0:
                    if s[i - 1] == t[j - 1]:
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                    else:
                        dp[i][j] = dp[i - 1][j]

        return dp[-1][-1]
Complexity:
O(mn) time
O(mn) space
 */

/*


Description:
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Hints:
Dynamic Programming
dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]


Python:
Complexity:
O(n^2) time
O(n^2) space
class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        n = len(triangle)

        dp = [[0] * n for x in range(n)]

        dp[0][0] = triangle[0][0]

        for i in range(1, n):
            for j in range(i + 1):
                if j == 0:
                    dp[i][j] = dp[i - 1][j] + triangle[i][j]
                elif i == j:
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]
                else:
                    dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]

        return min(dp[-1])
We can reduce space complexity to O(n).
 */
/*
Description:
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Hints:
Dynamic Programming
- Rob first one not last one
- Rob last one not first one
The maximum amount of the above is result.

Python:
class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def rob(self, nums):
        n = len(nums)
        if not nums or n == 0:
            return 0

        if n == 1:
            return nums[0]

        dp1 = [0] * (n + 1)
        dp2 = [0] * (n + 1)

        dp1[1] = nums[0]

        for i in range (2, n):
            dp1[i] = max(dp1[i - 1], dp1[i - 2] + nums[i - 1])
            dp2[i] = max(dp2[i - 1], dp2[i - 2] + nums[i - 1])

        dp2[-1] = max(dp2[-2], dp2[-3] + nums[-1])

        return max(dp1[-2], dp2[-1])
Complexity:
O(n) time
O(n) space
 */
/*
Question:
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:
1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
Return 4.

Hint:
Dynamic Programming
dp[i][j] tracks the side length of the maximum square ending at (i,j).
If (i,j)=1, dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1

Finally, find the maximum side length from the whole dp array.
class Solution:
    # @param {character[][]} matrix
    # @return {integer}
    def maximalSquare(self, matrix):
        if not matrix or len(matrix) == 0:
            return 0

        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                matrix[i][j] = int(matrix[i][j])
                if i > 0 and j > 0 and matrix[i][j]:
                    matrix[i][j] = min(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i][j - 1]) + 1

        return max(map(max, matrix)) ** 2
 */

/*

Description:
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

Hint:
Use a two-dimensional dp array to record the edit distance. dp[i][j] means edit distance of word1[0...i] and word2[0...j].

Python:
class Solution:
    # @param {string} word1
    # @param {string} word2
    # @return {integer}
    def minDistance(self, word1, word2):
        m = len(word1)
        n = len(word2)

        dp = [[0] * (n + 1) for x in range(m + 1)]

        for i in range(m + 1):
            dp[i][0] = i

        for j in range(n + 1):
            dp[0][j] = j

        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1

        return dp[m][n]
 */

/*
Description:
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Hints:
Dynamic Programming

 Picture
Source: http://blog.csdn.net/u011095253/article/details/9248073

dp[i][j] track s3[:i+j] is formed by interleaving of s1[:i] and s2[:j].

dp[i][j] = (s1[i - 1] == s3[i + j - 1] && dp[i - 1][j]) || (s2[j - 1] == s3[i + j - 1] && dp[i][j - 1])


Python:
class Solution:
    # @param {string} s1
    # @param {string} s2
    # @param {string} s3
    # @return {boolean}
    def isInterleave(self, s1, s2, s3):
        m = len(s1)
        n = len(s2)
        p = len(s3)

        if m + n != p:
            return False

        dp = [[False] * (n + 1) for x in range(m + 1)]

        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 and j == 0:
                    dp[i][j] = True
                elif i == 0:
                    dp[i][j] = s2[:j] == s3[:j]
                elif j == 0:
                    dp[i][j] = s1[:i] == s3[:i]
                else:
                    dp[i][j] = (dp[i - 1][j] and s1[i - 1] == s3[i + j - 1]) or (dp[i][j - 1] and s2[j - 1] == s3[i + j - 1])

        return dp[-1][-1]
 */