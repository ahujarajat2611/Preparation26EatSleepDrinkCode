package BasicAlgorithms.Graph;
/*
We are given a map of cities connected with each other via cable lines such that there is no cycle between any two cities. We need to find the maximum length of cable between any two cities for given city map.

Input : n = 6
        1 2 3  // Cable length from 1 to 2 (or 2 to 1) is 3
        2 3 4
        2 6 2
        6 4 6
        6 5 5
Output: maximum length of cable = 12
 */

// longest path between any pair of vertices !!
/**
 * Created by hadoop on 14/1/18.
 */
public class LongestPathBetweenPairVertices {
}

/*
We create undirected graph

for given city map and do DFS
from every city to find maximum length of cable.
 While traversing, we look for total cable length to
  reach the current city and if it’s adjacent city is
  not visited then call DFS for it but if all
  adjacent cities are visited for current node,
  then update the value of max_length if previous value of max_length is less
   than current value of total cable length.
// C++ program to find the longest cable length
// between any two cities.
#include<bits/stdc++.h>
using namespace std;

// visited[] array to make nodes visited
// src is starting node for DFS traversal
// prev_len is sum of cable length till current node
// max_len is pointer which stores the maximum length
// of cable value after DFS traversal
void DFS(vector< pair<int,int> > graph[], int src,
         int prev_len, int *max_len,
         vector <bool> &visited)
{
    // Mark the src node visited
    visited[src] = 1;

    // curr_len is for length of cable from src
    // city to its adjacent city
    int curr_len = 0;

    // Adjacent is pair type which stores
    // destination city and cable length
    pair < int, int > adjacent;

    // Traverse all adjacent
    for (int i=0; i<graph[src].size(); i++)
    {
        // Adjacent element
        adjacent = graph[src][i];

        // If node or city is not visited
        if (!visited[adjacent.first])
        {
            // Total length of cable from src city
            // to its adjacent
            curr_len = prev_len + adjacent.second;

            // Call DFS for adjacent city
            DFS(graph, adjacent.first, curr_len,
                max_len,  visited);
        }

        // If total cable length till now greater than
        // previous length then update it
        if ((*max_len) < curr_len)
            *max_len = curr_len;

        // make curr_len = 0 for next adjacent
        curr_len = 0;
    }
}

// n is number of cities or nodes in graph
// cable_lines is total cable_lines among the cities
// or edges in graph
int longestCable(vector<pair<int,int> > graph[],
                                          int n)
{
    // maximum length of cable among the connected
    // cities
    int max_len = INT_MIN;

    // call DFS for each city to find maximum
    // length of cable
    for (int i=1; i<=n; i++)
    {
        // initialize visited array with 0
        vector< bool > visited(n+1, false);

        // Call DFS for src vertex i
        DFS(graph, i, 0, &max_len, visited);
    }

    return max_len;
}

// driver program to test the input
int main()
{
    // n is number of cities
    int n = 6;

    vector< pair<int,int> > graph[n+1];

    // create undirected graph
    // first edge
    graph[1].push_back(make_pair(2, 3));
    graph[2].push_back(make_pair(1, 3));

    // second edge
    graph[2].push_back(make_pair(3, 4));
    graph[3].push_back(make_pair(2, 4));

    // third edge
    graph[2].push_back(make_pair(6, 2));
    graph[6].push_back(make_pair(2, 2));

    // fourth edge
    graph[4].push_back(make_pair(6, 6));
    graph[6].push_back(make_pair(4, 6));

    // fifth edge
    graph[5].push_back(make_pair(6, 5));
    graph[6].push_back(make_pair(5, 5));

    cout << "Maximum length of cable = "
         << longestCable(graph, n);

    return 0;
}
Run on IDE
Output:

Maximum length of cable = 12
Time Complexity : O(V * (V + E))


Method 2 (Efficient : Works only if Graph is Directed)

We can solve above problem in O(V+E) time if the given graph is directed instead of undirected graph. Below are steps.
1) Create a distance array dist[] and initialize all entries of it as minus infinite
2) Order all vertices in toplogical order.
3) Do following for every vertex u in topological order.
…..Do following for every adjacent vertex v of u
………..if (dist[v] < dist[u] + weight(u, v))
……………dist[v] = dist[u] + weight(u, v)
4) Return maximum value from dist[]


Since there is no negative weight, processing vertices in topological order would always produce an array of longest paths dist[] such that dist[u] indicates longest path ending at vertex ‘u’.

The implementation of above approach can be easily adopted from here. The differences here are, there are no negative weight edges and we need overall longest path (not longest paths from a source vertex). Finally we return maximum of all values in dist[].

Time Complexity : O(V + E)
 */