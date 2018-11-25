package BasicAlgorithms.Graph;

import BasicAlgorithms.utils.ConsoleWriter;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.*;
/**
 * Created by hadoop on 24/12/17.
 */
// Dijkstra
public class NetworkDelay {
    int []edgeTo;
    int []distTo;
    boolean []marked;
    int INFINITY = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int N, int K) {
        // graph has been changed to set of pair with distance as well
        Map<Integer,Set<Pair<Integer,Integer>>> graph = new HashMap<>();
        for(int []row:times) {
            if (!graph.containsKey(row[0])) {
                graph.put(row[0], new HashSet<>());
            }
            if (!graph.containsKey(row[1])) {
                graph.put(row[1], new HashSet<>());
            }
            graph.get(row[0]).add(new Pair<>(row[1], row[2]));
        }
       // System.out.println(graph);
        edgeTo = new int[N+1];
        distTo = new int[N+1];
        marked = new boolean[N+1];
        for(int i=0;i<N+1;i++){
            distTo[i] = INFINITY;
        }
        distTo[K] = 0;
       // marked[K] = true;

        // we will makr visited once we fetch frmo the queue // thts how dijkstra works
        // once polled means it can nt have shorter distance .... poll it it and make it visited
        // while pushing to queue making it visited is wrong in case of dijkstra
        // since we might get shortest path in this case !!!!!
        // queue has been changed to priority queue
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        pq.add(new Pair<>(K,0));
        while (!pq.isEmpty()){
            Pair<Integer,Integer> polled = pq.poll();
            if(marked[polled.getKey()])
                continue;
            marked[polled.getKey()] = true;
            for(Pair<Integer,Integer> w:graph.get(polled.getKey())){
                if(marked[w.getKey()])
                    continue;
                if(distTo[polled.getKey()] +w.getValue() <distTo[w.getKey()] ){
                  //  System.out.println("ans");
                    distTo[w.getKey()] = distTo[polled.getKey()] +w.getValue();
                   // System.out.println(distTo[w.getKey()]);
                    edgeTo[w.getKey()] = polled.getKey();
                    pq.add(new Pair<>(w.getKey(),distTo[polled.getKey()] +w.getValue()));
                }
            }
        }
        //ConsoleWriter.printIntArray(distTo);
        int ans =-1;
        for(int i=1;i<N+1;i++){
            if(marked[i]){
                ans = Math.max(ans,distTo[i]);
            }
            else{
                return -1;
            }
        }
        // if(ans == Integer.MAX_VALUE){
        //     return -1;
        // }
        return ans;
    }

    public static void main(String[] args) {
        NetworkDelay networkDelay = new NetworkDelay();
        int [][]array = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelay.networkDelayTime(array,4,2));

    }
    /*
    http://zxi.mytechroad.com/blog/graph/leetcode-743-network-delay-time/



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
}