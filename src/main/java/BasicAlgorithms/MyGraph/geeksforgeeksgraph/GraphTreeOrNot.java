package BasicAlgorithms.MyGraph.geeksforgeeksgraph;// A Java Program to check whether a graph is tree or not
import java.util.*;
 
// This class represents a directed graph using adjacency
// list representation
class GraphTreeOrNot
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
 
    // Constructor
    GraphTreeOrNot(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
 
    // A recursive function that uses visited[] and parent
    // to detect cycle in subgraph reachable from vertex v.
    Boolean isCyclicUtil(int v, Boolean visited[], int parent)
    {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
 
            // If an adjacent is not visited, then recur for
            // that adjacent
            if (!visited[i])
            {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }
 
            // If an adjacent is visited and not parent of 
            // current vertex, then there is a cycle.
            else if (i != parent)
               return true;
        }
        return false;
    }



    // check if graph has cycle and also check if all ndoes are reachable from a
    // particular node here we picked 0 node .....
    // if its not connected to all nodes than anyway is not gona be tree
    // so pick any node to perform cyclic operaions...

    // Returns true if the graph is a tree, else false.
    Boolean isTree()
    {
        // Mark all the vertices as not visited and not part
        // of recursion stack
        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // The call to isCyclicUtil serves multiple purposes
        // It returns true if graph reachable from vertex 0
        // is cyclcic. It also marks all vertices reachable
        // from 0.
        // check for cycle and also check for conectivty
        if (isCyclicUtil(0, visited, -1))
            return false;
 
        // If we find a vertex which is not reachable from 0
        // (not marked by isCyclicUtil(), then we return false
        for (int u = 0; u < V; u++)
            if (!visited[u])
                return false;
 
        return true;
    }
 
    // Driver method
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        GraphTreeOrNot g1 = new GraphTreeOrNot(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isTree())
            System.out.println("GraphTreeOrNot is Tree");
        else
            System.out.println("GraphTreeOrNot is not Tree");
 
        GraphTreeOrNot g2 = new GraphTreeOrNot(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
 
        if (g2.isTree())
            System.out.println("GraphTreeOrNot is Tree");
        else
            System.out.println("GraphTreeOrNot is not Tree");
 
    }
}
// This code is contributed by Aakash Hasija