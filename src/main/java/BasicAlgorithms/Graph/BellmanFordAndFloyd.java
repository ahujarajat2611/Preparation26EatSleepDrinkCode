package BasicAlgorithms.Graph;

/**
 * Created by hadoop on 6/1/18.
 */
public class BellmanFordAndFloyd {
}
//http://zxi.mytechroad.com/blog/graph/leetcode-743-network-delay-time/

/*

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
29
30
// Author: Huahua
// Runtime: 92 ms
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        vector<vector<int>> d(N, vector<int>(N, -1));

        for (auto time : times)
            d[time[0] - 1][time[1] - 1] = time[2];

        for (int i = 0; i < N; ++i)
            d[i][i] = 0;

        for (int k = 0; k < N; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    if (d[i][k] >= 0 && d[k][j] >= 0)
                        if (d[i][j] < 0 || d[i][j] > d[i][k] + d[k][j])
                            d[i][j] = d[i][k] + d[k][j];

        int ans = INT_MIN;

        for (int i = 0; i < N; ++i) {
            if (d[K - 1][i] < 0) return -1;
            ans = max(ans, d[K - 1][i]);
        }

        return ans;
    }
};
Solution3:

C++ / Floyd-Warshall

Time complexity: O(n^3)

Space complexity: O(n^2)
 */

/*


C++ / Bellman-Ford

Time complexity: O(ne)

Space complexity: O(n)

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
// Author: Huahua
// Runtime: 92 ms
class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        constexpr int MAX_TIME = 101 * 100;
        vector<int> dist(N, MAX_TIME);
        dist[K - 1] = 0;
        for (int i = 1; i < N; ++i)
            for (const auto& time : times) {
                int u = time[0] - 1, v = time[1] - 1, w = time[2];
                dist[v] = min(dist[v], dist[u] + w);
            }
        int max_dist = *max_element(dist.begin(), dist.end());
        return max_dist == MAX_TIME ? -1 : max_dist;
    }
};
 */