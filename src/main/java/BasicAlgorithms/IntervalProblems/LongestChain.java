package BasicAlgorithms.IntervalProblems;
import java.util.*;

/**
 * Created by hadoop on 15/1/18.
 */
public class LongestChain {
    public int findLongestChain(int[][] pairs) {
        // by finish points we sort
        Arrays.sort(pairs, Comparator.comparingInt(u -> u[1]));
        int ans = 1, end = pairs[0][1];
        for (int[] pair : pairs) {
            if (pair[0] > end) {
                ans++;
                // publish comparein publish point with prev end point
                // if no overlap add to
                end = pair[1];
            }
        }
        return ans;
    }

}
/*
LeetCode Maximum Length of Pair Chain
Leave a reply
LeetCode Maximum Length of Pair Chain

You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:

Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]
Note:

The number of given pairs will be in the range [1, 1000].
(C, d) may follow (a, b) if both pairs (a, b) and (c, d) satisfy b <c. Given a series of pairs of numbers (s, t), ask how many of these pairs can be taken up to satisfy the condition of continuous satisfaction.

Solution 1, the use of DP. First, for all pairs (x, y), press x to sort, x to sort by y. Then iterate over several pairs, for each pair, there are two choices, not or, corresponding to dp [i] [0] and dp [i] [1], which represent the maximum number of conditions that can be selected by i Number of pairs.

Dp [i] [0] = max (dp [i-1] [0], dp [i-1] [1]) because the ith pair is not selected, The maximum number of pairs selected, that is, max (dp [i-1] [0], dp [i-1] [1]).

If the i-th number is right, then find a number j that does not conflict with i, followed by j, so dp [i] [1] = dp [j] [1] +1.

code show as below:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
bool cmp(const vector<int>& p1, const vector<int>& p2) {
    return p1[0] < p2[0] || (p1[0] == p2[0] && p1[1] < p2[1]);
}
class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(), pairs.end(), cmp);
        int n = pairs.size();
        vector<vector<int>> dp(n, vector<int>(2, 0));
        dp[0][0] = 0;
        dp[0][1] = 1;
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = 1;
            int j = i - 1;
            while (j >= 0 && pairs[i][0] <= pairs[j][1]) {
                --j;
            }
            if (j >= 0) {
                dp[i][1] = max(dp[i][1], dp[j][1] + 1);
            }
            ans = max(ans, dp[i][0]);
            ans = max(ans, dp[i][1]);
        }
        return ans;
    }
};
The code submitted to AC, with 49MS.

I faintly think that this solution has a problem, that is, when seeking dp [i] [1], you should find i in front of all and i do not conflict with j, seeking max, that dp [i] [1] = max [j] [1] +1).

So solution 2 is impeccable DP solution. Let dp [i] denote the longest chained number that can be obtained by counting the number of pairs of i. At the initial time, all dp [i] = 1. Then for the i-th number of pairs, iterate through all the pairs j in front of i and find dp [i] = max (dp [j] +1) as long as i and j are able to chain together. Time complexity O ( n2)O(n2),code show as below:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(), pairs.end(), [](const vector<int>& p1, const vector<int>& p2) {return p1[0] < p2[0] || (p1[0] == p2[0] && p1[1] < p2[1]); });

        int n = pairs.size(), ans = 1;
        vector<int> dp(n, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
            ans = max(ans, dp[i]);
        }
        return ans;
    }
};
The code submitted to AC, with 122MS.

Solution 3, first of all, is to sort all the numbers, and then treat this question as similar to the longest rising subsequence . That is, suppose dp [k] = minimum ending time when the chain length is k. Then after a number pair, if the publish time of the number pair is greater than the end time of the end of dp, then the number pairs can be appended to dp, the chain length plus 1, dp [k + 1] = the end of the number pairs time. Otherwise, if the pair's publish time is not greater than the end of dp, you need to insert the number into the dp, just like the LIS. Because dp is sorted, you can insert it in half.

The idea please refer to: https://discuss.leetcode.com/topic/96814/python-straightforward-with-explanation-n-log-n/2 . More interestingly, as the first commenter said, because the advance logarithm sorts by end time, the latter pairs are definitely greater than or equal to the end of dp, so new pairs are only likely to be appended To the end of dp, it is impossible to insert dp in other locations, so you can omit the dichotomy into the process. The complete code is concise as follows:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(), pairs.end(), [](const vector<int>& p1, const vector<int>& p2) {return p1[1] < p2[1]; });
        int ans = 0;
        for (int i = 0, j = 0; j < pairs.size(); ++j) {
            if (j == 0 || pairs[j][0] > pairs[i][1]) {
                ++ans;
                i = j;
            }
        }
        return ans;
    }
};
The code submitted to AC, with 45MS.

This question treats each number pair as the publish and end of an activity and translates the question into selecting the largest number of non-overlapping and the highest number of activities out of all. Activities to choose the problem can be solved with greed,
 */
