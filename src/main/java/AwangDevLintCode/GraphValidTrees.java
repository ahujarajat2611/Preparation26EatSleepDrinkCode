package AwangDevLintCode;

/**
 * Created by hadoop on 4/2/18.
 */
/*
/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
write a function to check whether these edges make up a valid tree.

Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note
You can assume that no duplicate edges will appear in edges.
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Tags Expand
Depth First Search Breadth First Search Union Find Facebook Zenefits Google

*/

/*
How to check if we have disconnected pair? Think about it:
		A valid tree has n-1 edges. If we have 1 disconnected pair, that means,
		we lost 1 edge, like n-2 edgets now.
		OR, keep thinking: if we have a cycle, which is a extra edge, that becomes n edgets.
	Therefore, a first check (assume if with n-1 edgets is valid), just check if edges.lenght == n -1.

So if in this complex case, there must be >=1 cycles. Now just explicitly check for cycle.
	How to use unin-find to check no cycle:
***		if a pair of node has same parent. If they do, that makes an triangle. False.

	What does Union-Find do?
	Union-Find is a data structure (this problem implemented as a array), that union 2 sets and
	checks if 2 elements are in the same set.
	In another problem, it can be implemented with HashMap as well.

 */
public class GraphValidTrees {
    int[] parents;
    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }
        parents = new int[n];
        //Init
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        //Use union-find to detect if pair has common parents, and merge then to 1 set
        for (int i = 0; i < edges.length; i++){
            if (find(edges[i][0]) == find(edges[i][1])) {
                return false;
            }
            union(edges[i][0], edges[i][1]);
        }

        return true;
    }
    /*
		Not only find parent, also update the spot parents[node] with parent node, recursively.

        *** The fact is, at all levels, if any curr != its parent, it'll trigger the find() method,
            Then it makes sure parent node will be assigned to this curr node index.

        Goal: Mark curr node: who is your ancestor parent; and that indicates if other nodes are
            in the same union as curr.
    */
    public int find(int node) {
        if (parents[node] == node) {//If curr node == its parent,  return curr node.
            return node;
        }
        //If curr node != its parent, we will attempt to find its grandparents, and assign to curr node.
        parents[node] = find(parents[node]);
        return parents[node];
    }
    public void union(int x, int y) {
        int findX = parents[x];
        int findY = parents[y];
        if (findX != findY) {
            parents[findX] = findY;
        }
    }
}
