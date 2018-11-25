package BasicAlgorithms.Greedy;

import java.util.*;
/**
 * Created by hadoop on 8/1/18.
 */
public class ReconstructQueueByHeight {
//    We first sort the people to make them stand from the highest to shortest.
//    For people with same height, sort them according to the count of people before them from small to big.
//
//    Then, we use the way similar to insert sorting to reorder the people. For a given person to insert, all the people already sorted are higher, so we just insert him in the “right” place to make the people before him as his “count” indicates. Since he is shorter than all the people in the sorted list, the “count” of the “existing” people does not be broken by the insertion.

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }

        return res;
    }
}
/*
vector<pair<int, int>> reconstructQueue(vector<pair<int, int>>& people) {
        int n = people.size();
        if (n == 0)
            return {};

        sort(people.begin(), people.end(), [](pair<int,int> p1, pair<int,int> p2) {
            return p1.first > p2.first || (p1.first == p2.first && p1.second < p2.second);
        });

        vector<pair<int,int>> res;
        dfs(people.size() - 1, res, people);
        return res;
    }

    void dfs(int index, vector<pair<int,int>>& res, const vector<pair<int, int>>& people) {
        const auto& p = people[index];

        if (index == 0) {
            res.push_back(p);
            return;
        }

        dfs(index - 1, res, people);
        res.insert(res.begin() + p.second, p);
    }
 */