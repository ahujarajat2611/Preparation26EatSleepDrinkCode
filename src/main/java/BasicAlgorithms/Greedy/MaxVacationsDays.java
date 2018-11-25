package BasicAlgorithms.Greedy;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by hadoop on 8/1/18.
 */
public class MaxVacationsDays {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = days.length, K = days[0].length;
        int[][] f = new int[K + 1][N];
        for (int[] row : f)
            Arrays.fill(row, -Integer.MAX_VALUE / 2);

        f[0][0] = 0;
        // for all possible weeek consider all posile thinsg
        for (int i = 1; i <= K; i++)
            for (int v = 0; v < N; v++)
                for (int u = 0; u < N; u++)
                    if (u == v || flights[u][v] == 1)
                        f[i][v] = Math.max(f[i][v], f[i - 1][u] + days[v][i - 1]); // index shifted by 1 for days array
        return IntStream.of(f[K]).max().getAsInt();
    }
}

/*
class Solution {
public:
    int maxVacationDays(vector<vector<int>>& flights, vector<vector<int>>& days) {
        int N = flights.size();
        int K = days[0].size();

        vector<vector<int>> dp(K, vector<int>(N, 0));
        vector<vector<bool>> reach(K, vector<bool>(N, false));

        // first week, no guesses for the previous city
        for (int city = 0; city < N; ++city)
            if (city == 0 || flights[0][city]) {
                dp[0][city] = days[city][0];
                reach[0][city] = true;
            }


        // topological order (week)
        for (int week = 1; week < K; ++week) {
            // current city
            for (int city = 0; city < N; ++city) {
                // Subproblem: guess a previous city
                for (int prevCity = 0; prevCity < N; ++prevCity) {
                    if (reach[week - 1][prevCity] && (city == prevCity || flights[prevCity][city])) {
                        dp[week][city] = max(dp[week][city], dp[week - 1][prevCity] + days[city][week]);
                        reach[week][city] = true;
                    }
                }
            }
        }

        int res = 0;
        for (int city = 0; city < N; ++city)
            res = max(res, dp[K - 1][city]);

        return res;

    }

};
 */
/*
class Solution {
public:
    int maxVacationDays(const vector<vector<int>>& flights, const vector<vector<int>>& days) {
        int N = flights.size();
        int K = days.size();
        int res = 0;
        dfs(flights, days, 0, 0, 0, N, K, res);
        return res;
    }

    void dfs(const vector<vector<int>>& flights, const vector<vector<int>>& days, int city, int week, int sum, int N, int K, int& res) {
        if (week == K) {
            res = max(res, sum);
            return;
        }

        for (int nextCity = 0; nextCity < N; ++nextCity) {
            if (city == nextCity || flights[city][nextCity]) {
                dfs(flights, days, nextCity, week + 1, sum + days[nextCity][week], N, K, res);
            }
        }

    }
};
 */