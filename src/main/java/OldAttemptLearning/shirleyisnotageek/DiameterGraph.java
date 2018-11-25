package OldAttemptLearning.shirleyisnotageek;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.*;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Diameter of a graph

Problem Statement
Diameter
The diameter of a graph is the maximum
shortest path between any two nodes.
At the beginning, there is a simple grpah contains exactly 1 node. Then we add
new nodes one by one to the graph.
Each time when we add a new node to the graph,
we also add exactly one edge to connect
this node to another node which already exists.
We want to find the diameter of the graph
each time we add a new node.
Note that each edge cost 1.
Input Format:
First line of the input contains one integer
N, indicating how many new nodes we will add.
Then following N lines.
The ith line contains an integer X, which means we add the ith node and an edge connecting the Xth node and ith node.
The original node is the 0th node.
Output Format:
Output N lines. The ith line is an integer indicating the diameter of the graph after adding the ith node.
Constraints:
0 < N <= 100000
0 <= Xi < i
i is counting from 1
Sample Input:
5
0
0
1
1
1
Sample Output:
1
2
3
3
3
Explanation:
Firstly the graph contains only node 0
The first line of output is 1 because the diameter becomes
1 when node 1 is added and connected to node 0. Diameter becomes 2 after adding node 2 to node 0. Then adding node 3, 4, 5, all of them are connecting to node 1, caculate the shortest path of all pairs of nodes, the maximum shortest path is 3, so the last 3 lines of output are all 3.

My approach is based on the assumption that


The constructed graph is a tree
The shortest distance between
any node pair will not change when the new node is added
Somehow I think my approach is correct, but I don't know how to prove it.

 */

    public class DiameterGraph {
        static int N;
        static int[][] shortestPath;
        static int newNode = 0;
        public static void maxShortestDistance(String input) throws Exception{
            BufferedReader inStream = new BufferedReader(new FileReader(input));
            N = Integer.parseInt(inStream.readLine());
            shortestPath = new int[N + 1][N + 1];
            for(int i = 0; i <= N; i++)
                //Integer.MAX_VALUE will overflow
                Arrays.fill(shortestPath[i], Integer.MAX_VALUE / 2);
            for(int i = 0; i <= N; i++)
                shortestPath[i][i] = 0;
            int max = 0;
            String line = "";
            try{
                while((line=inStream.readLine())!=null){
                    newNode++;
                    int connected = Integer.parseInt(line);
                    shortestPath[connected][newNode] = 1;
                    shortestPath[newNode][connected] = 1;
                    for(int i = 0; i < newNode; i++){
                        for(int j = 0; j < newNode; j++){
                            shortestPath[i][newNode] = Math.min(shortestPath[i][newNode],
                                    shortestPath[i][j] + shortestPath[j][newNode]);
                        }
                        shortestPath[newNode][i] = shortestPath[i][newNode];
                        max = Math.max(max, shortestPath[i][newNode]);
                        //System.out.println(i + " to " + newNode + ": " + shortestPath[newNode][i]);
                    }
                    System.out.println(max);
                }
            } catch (Exception e){
                System.out.println(e);
            }

            inStream.close();
        }
    }
